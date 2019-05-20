package com.paperquestion.shiro.controller;

import com.paper.question.common.JsonResult;
import com.paper.question.common.JsonResultFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 权限：用户
 * @Date 2018-04-06
 * @Time 20:33
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/getMessage", method = RequestMethod.GET)
    public JsonResult getMessage() {
    	return JsonResultFactory.get("您拥有用户权限，可以获得该接口的信息！");
    }
}
