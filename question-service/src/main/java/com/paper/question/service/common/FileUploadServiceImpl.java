package com.paper.question.service.common;

import com.paper.question.common.upload.IFileStorageService;
import com.paper.question.common.upload.UploadFileResponse;
import com.paper.question.dao.mapper.ImageResourceMapper;
import com.paper.question.dao.mapper.SysUserMapper;
import com.paper.question.domain.dto.common.ImageResource;
import com.paper.question.interfaces.common.IFileUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class FileUploadServiceImpl implements IFileUploadService {

    @Resource
    private IFileStorageService fileStorageService;

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private ImageResourceMapper imageResourceMapper;

    @Override
    public List<Map<String, Object>> saveImage(List<MultipartFile> files) {
        System.out.println("图片上传新");
        System.out.println(files);
        List<UploadFileResponse> uploadFileResponseList =
                Arrays
                        .stream(files.toArray(new MultipartFile[0]))
                        .map(file -> fileStorageService.storeFile(file, IFileUploadService.SYSUSER_IMAGE))
                        .collect(Collectors.toList());
        System.out.println("图片上传");
        System.out.println(uploadFileResponseList);
        List<Map<String, Object>> idList = new ArrayList<>(uploadFileResponseList.size());

        uploadFileResponseList.forEach(resp -> {
            ImageResource resource = new ImageResource();
            resource.setSize((int) resp.getSize());
            resource.setUrl(resp.getFileDownloadUri());
            resource.setType(resp.getFileType());
            resource.setWidth((short) resp.getWidth());
            resource.setHeight((short) resp.getHeight());
            imageResourceMapper.insertSelective(resource);
//            SysUser sysUser = new SysUser();
//            //用户的id
//            long id = 2;
//            sysUser.setId(id);
//            sysUser.setAvatar(resp.getFileDownloadUri());
//            sysUserMapper.updateByPrimaryKeySelective(sysUser);
            Map<String, Object> map = new HashMap<>();
            map.put("imageId", resource.getId());
            map.put("imageUrl", resp.getFileDownloadUri());
            idList.add(map);
        });
        return idList;
    }

    @Override
    public ImageResource findImageById(Integer resourceId) {
        return imageResourceMapper.findImageResource(resourceId);
    }

}
