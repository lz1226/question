package com.paper.question.common.upload;


import com.paper.question.common.exception.FileStorageException;
import com.paper.question.common.util.DateTimeUtil;
import com.paper.question.common.util.Md5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;
import java.util.UUID;

// - https://spring.io/guides/gs/uploading-files/
// - https://www.callicoder.com/spring-boot-file-upload-download-rest-api-example/
// - http://www.mkyong.com/spring-boot/spring-boot-file-upload-example/
// - http://www.mkyong.com/spring-boot/spring-boot-file-upload-example-ajax-and-rest/
@Service
public class FileStorageServiceImpl implements IFileStorageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileStorageServiceImpl.class);

    private final Path fileStorageLocation;

    private boolean isWindows;

    @Autowired
    public FileStorageServiceImpl(FileStorageProperties fileStorageProperties) {
        String osName = System.getProperty("os.name");
        isWindows = osName != null && osName.contains("Windows");
        this.fileStorageLocation =
                Paths.get(fileStorageProperties.getUploadDir())
                        .toAbsolutePath()
                        .normalize();
        try {
            if (Files.notExists(this.fileStorageLocation)) {
                Files.createDirectories(this.fileStorageLocation);
            }
        } catch (IOException e) {
            throw new FileStorageException("上传路径无写权限", e);
        }
    }

    /**
     * 上传文件到配置文件指定的文件夹中
     */
    public UploadFileResponse storeFile(MultipartFile file) {
        return storeFile(file, "");
    }

    /**
     * 以配置文件指定的文件夹作为根目录，dirPrefix为根目录下的子目录，将文件上传到指定的子目录下
     * 如：配置文件中指定上传根目录为 /tmp/upload，dirPrefix为"a/b/c"，文件最终会上传到 /tmp/upload/a/b/c 目录下
     */
    public UploadFileResponse storeFile(MultipartFile file, String dirPrefix) {
        LOGGER.debug("开始上传文件");
        // normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        if (fileName.contains("..")) {
            throw new FileStorageException("文件名包含非法字符序列:" + fileName);
        }

        if (dirPrefix == null) {
            dirPrefix = "";
        }
        if (dirPrefix.startsWith("/") || dirPrefix.contains("..")) {
            throw new FileStorageException("子目录不能包含非法字符'..'，不能以'/'开头");
        }


        UploadFileResponse uploadFileResponse = new UploadFileResponse();
        uploadFileResponse.setFileOriginalName(file.getOriginalFilename());
        uploadFileResponse.setFileType(file.getContentType());
        uploadFileResponse.setSize(file.getSize());
        String newFilename = Md5Util.md5(
                String.format("%s%s%s%s",
                        DateTimeUtil.nowMilli(),
                        uploadFileResponse.getSize(),
                        uploadFileResponse.getFileType(),
                        UUID.randomUUID().toString()
                ));
        newFilename += uploadFileResponse.getExtName();

        uploadFileResponse.setFileName(newFilename);
        String downloadUri = Paths.get(
                dirPrefix,
                String.valueOf(DateTimeUtil.nowYear()),
                String.valueOf(DateTimeUtil.nowMonth()),
                String.valueOf(DateTimeUtil.nowDayOfMonth()),
                newFilename).toString();
        uploadFileResponse.setFileDownloadUri(downloadUri);

        // copy file to the target location（replacing existing file with the same name)
        Path targetLocation = this.fileStorageLocation.resolve(downloadUri);

        // 文件权限
        Set<PosixFilePermission> permissions = PosixFilePermissions.fromString("rwxr-xr-x");

        synchronized (this) {
            // create folder
            if (Files.notExists(targetLocation.getParent())) {
                try {
                    if (isWindows) {
                        Files.createDirectories(targetLocation.getParent());
                    } else {
                        FileAttribute<Set<PosixFilePermission>> attr = PosixFilePermissions.asFileAttribute(permissions);
                        Files.createDirectories(targetLocation.getParent(), attr);
                    }
                } catch (IOException e) {
                    throw new FileStorageException("文件上传目录创建失败", e);
                }
            }
        }

        try {
            ByteArrayOutputStream baos = cloneInputStream(file.getInputStream());
            if (baos == null) {
                throw new FileStorageException("文件上传失败 - 输入流转换失败");
            }

            // 文件存储
            Files.copy(new ByteArrayInputStream(baos.toByteArray()), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            // 图片处理
            int[] widthHeight = getImageWidthHeight(new ByteArrayInputStream(baos.toByteArray()));
            uploadFileResponse.setWidth(widthHeight[0]);
            uploadFileResponse.setHeight(widthHeight[1]);

        } catch (IOException e) {
            throw new FileStorageException("文件上传失败", e);
        }

        try {
            if (!isWindows) {
                // 设置文件权限
                Files.setPosixFilePermissions(targetLocation, permissions);
            }
        } catch (IOException e) {
            throw new FileStorageException("文件权限设置失败", e);
        }
        LOGGER.debug("上传文件完成");
        return uploadFileResponse;
    }

    // 重复利用inputStream流
    private ByteArrayOutputStream cloneInputStream(InputStream inputStream) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) > -1) {
                baos.write(buffer, 0, len);
            }
            baos.flush();
            return baos;
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * 获取图片文件的宽度和高度
     */
    private int[] getImageWidthHeight(InputStream inputStream) {
        int[] widthHeight = {0, 0};
        try {
            BufferedImage image = ImageIO.read(inputStream);
            if (image != null) {
                widthHeight[0] = image.getWidth();
                widthHeight[1] = image.getHeight();
            }
        } catch (IOException e) {
            LOGGER.debug("非图片文件");
        }
        return widthHeight;
    }


}
