package com.paper.question.web.controller.common;

import com.paper.question.common.JsonResult;
import com.paper.question.common.JsonResultFactory;
import com.paper.question.domain.dto.common.FileUploadDto;
import com.paper.question.interfaces.common.IFileUploadService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/upload")
public class FileUploadController {

    @Resource
    private IFileUploadService fileUploadService;

    @PostMapping("/sysuser/image")
    public JsonResult upload(FileUploadDto fileUploadDto) {
        List<Map<String, Object>> idList = fileUploadService.saveImage(fileUploadDto.getFiles());
        return JsonResultFactory.get(idList);
    }

}
