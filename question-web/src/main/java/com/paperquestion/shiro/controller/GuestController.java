package com.paperquestion.shiro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.paper.question.common.JsonResult;
import com.paper.question.common.JsonResultFactory;

/**
 * 
 * @description: 这里用一句话描述这个方法的作用 TODO
 * @author 郑晓龙
 * @update 2019年5月20日 下午2:44:43
 */
@RestController
@RequestMapping("/guest")
public class GuestController {

    @RequestMapping(value = "/enter", method = RequestMethod.GET)
    public JsonResult login() {
        return JsonResultFactory.get("欢迎进入，您的身份是游客");
    }

    @RequestMapping(value = "/getMessage", method = RequestMethod.GET)
    public JsonResult submitLogin() {
    	return JsonResultFactory.get("您拥有获得该接口的信息的权限！");
    }
}
