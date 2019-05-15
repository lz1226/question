package com.paper.question.web.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paper.question.common.JsonResult;
import com.paper.question.common.JsonResultFactory;
import com.paper.question.domain.entity.SysUser;
import com.paper.question.interfaces.ISysUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/sysUser")
@Api(value = "用户登录")
public class SysUserController {
	
    @Resource
    private ISysUserService sysUserService;

    
   
    @ApiOperation(value="用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name="name",value="用户名",required = true,dataType="String"),
            @ApiImplicitParam(paramType = "query",name="password",value="用户密码",required = true,dataType = "String")
    })
    @GetMapping("login")
    public JsonResult login(SysUser sysUser){
       SysUser sysUsers = sysUserService.login(sysUser);
       return JsonResultFactory.get(sysUsers);
    }
}

