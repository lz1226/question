package com.paper.question.interfaces.common;

import com.paper.question.domain.dto.common.ImageResource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface IFileUploadService {
    // 图片保存路径
    String SYSUSER_IMAGE = "sysuser/IMAGE";

    /**
     * 保存用户的头像
     */
    List<Map<String, Object>> saveImage(List<MultipartFile> files);

    /**
     * 通过id查找用户头像
     */
    ImageResource findImageById(Integer resourceId);
}
