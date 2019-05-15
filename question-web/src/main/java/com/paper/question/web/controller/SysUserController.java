package com.paper.question.web.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paper.question.common.JsonResult;
import com.paper.question.common.JsonResultFactory;
import com.paper.question.domain.entity.SysUser;
import com.paper.question.interfaces.ISysUserService;

@RestController
@RequestMapping("/sysUser")
public class SysUserController {
    @Resource
    private ISysUserService sysUserService;

    @GetMapping("login")
    public JsonResult login(SysUser sysUser){
       SysUser sysUsers = sysUserService.login(sysUser);
        return JsonResultFactory.get(sysUsers);
    }
}

