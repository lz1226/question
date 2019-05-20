package com.paperquestion.shiro.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.paper.question.common.JsonResult;
import com.paper.question.common.JsonResultFactory;
import com.paper.question.common.ReturnCode;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 权限：管理员
 * @Date 2018-04-06
 * @Time 20:31
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping(value = "/getMessage", method = RequestMethod.GET)
    public JsonResult getMessage() {
    	return JsonResultFactory.get("您拥有管理员权限，可以获得该接口的信息！");
    }
}
