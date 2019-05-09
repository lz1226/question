package com.paper.question.web.controller.test;

import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guest")
public class GuestController {
    @Autowired
//    private final ResultMap resultMap;

    @RequestMapping(value = "/enter", method = RequestMethod.GET)
    public String login() {
//        return resultMap.success().message("欢迎进入，您的身份是游客");
        return "欢迎进入，您的身份是游客";
    }

//    @RequestMapping(value = "/getMessage", method = RequestMethod.GET)
//    public ResultMap submitLogin() {
//        return resultMap.success().message("您拥有获得该接口的信息的权限！");
//    }
}
