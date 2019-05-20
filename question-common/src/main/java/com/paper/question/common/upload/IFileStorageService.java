package com.paper.question.common.upload;

import org.springframework.web.multipart.MultipartFile;

/**
 * 文件存放规则 - 上传根路径/年/月/日/重命名文件名
 * 文件重命名规则：MD5(毫秒级时间戳+文件长度+文件类型+UUID)
 */
public interface IFileStorageService {

    /**
     * 上传文件
     */
    UploadFileResponse storeFile(MultipartFile file);

    /**
     * 上传文件，灵活指定上传根目录中的子目录
     */
    UploadFileResponse storeFile(MultipartFile file, String dirPrefix);
}
