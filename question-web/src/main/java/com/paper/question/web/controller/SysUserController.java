package com.paper.question.web.controller;

import com.paper.question.common.JsonResult;
import com.paper.question.common.JsonResultFactory;
import com.paper.question.domain.entity.SysUser;
import com.paper.question.interfaces.ISysUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/sysUser")
public class SysUserController {
    @Resource
    private ISysUserService sysUserService;

    @PostMapping("login")
    public JsonResult login(SysUser sysUser){
       SysUser sysUsers = sysUserService.login(sysUser);
        return JsonResultFactory.get(sysUsers);
    }
}

