package com.paper.question.web.controller;

import javax.annotation.Resource;

import com.paper.question.common.Pagination;
import com.paper.question.domain.dto.SysUserDto;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import com.paper.question.common.JsonResult;
import com.paper.question.common.JsonResultFactory;
import com.paper.question.domain.entity.SysUser;
import com.paper.question.interfaces.ISysUserService;

import java.util.HashMap;

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
    @PostMapping("login")
    public JsonResult login(@RequestBody SysUser sysUser){
       SysUser sysUsers = sysUserService.login(sysUser);
       return JsonResultFactory.get(sysUsers);
    }

    @ApiOperation(value="通过Id查找用户用户接口")
    @PostMapping("/list")
    public JsonResult list( @RequestBody Pagination pagination){
        return sysUserService.list(pagination);
    }

    @ApiOperation(value="通过Id查找用户用户接口")
    @GetMapping("/find/{id}")
    public JsonResult findUserById( @ApiParam(required=true, name="id", value="用户Id")@PathVariable("id") long id){
       SysUserDto sysUser = sysUserService.findById(id);
        return JsonResultFactory.get(sysUser);
    }

    @ApiOperation(value="创建用户接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name="id",value="用户名Id",required = true,dataType="long"),
            @ApiImplicitParam(paramType = "query",name="avatar",value="头像",required = false,dataType="String"),
            @ApiImplicitParam(paramType = "query",name="account",value="账号",required = true,dataType="String"),
            @ApiImplicitParam(paramType = "query",name="password",value="密码",required = true,dataType="String"),
            @ApiImplicitParam(paramType = "query",name="salt",value="md5密码盐",required = false,dataType="String"),
            @ApiImplicitParam(paramType = "query",name="name",value="名字",required = true,dataType="String"),
            @ApiImplicitParam(paramType = "query",name="deptId",value="所属部门Id",required = false,dataType="long"),
            @ApiImplicitParam(paramType = "query",name="birthday",value="名字",required = false,dataType="Date"),
            @ApiImplicitParam(paramType = "query",name="sex",value="性别（1：男 2：女）",required = false,dataType="Integer"),
            @ApiImplicitParam(paramType = "query",name="email",value="电子邮件",required = false,dataType="String"),
            @ApiImplicitParam(paramType = "query",name="phone",value="电话",required = false,dataType="String"),
            @ApiImplicitParam(paramType = "query",name="status",value="状态(1：启用  2：冻结  3：删除）",required = false,dataType="Integer"),
            @ApiImplicitParam(paramType = "query",name="version",value="保留字段",required = false,dataType="Integer"),
            @ApiImplicitParam(paramType = "query",name="createBy",value="创建通过",required = false,dataType="long"),
            @ApiImplicitParam(paramType = "query",name="updateBy",value="更新通过",required = false,dataType="long"),
            @ApiImplicitParam(paramType = "query",name="createTime",value="创建时间",required = false,dataType="Date"),
            @ApiImplicitParam(paramType = "query",name="updateTime",value="更新时间",required = false,dataType="Date"),
            @ApiImplicitParam(paramType = "query",name="delFlag",value="是否删除",required = false,dataType="Boolean"),
    })
    @PostMapping("createUser")
    public JsonResult createUser(@RequestBody SysUser sysUser){
       int userId = sysUserService.createUser(sysUser);
        return JsonResultFactory.get(new HashMap<String,Object>(){{
            put("userId",userId);
        }});
   }

   @ApiOperation(value="修改用户接口")
   @ApiImplicitParams({
           @ApiImplicitParam(paramType = "query",name="id",value="用户名Id",required = true,dataType="long"),
           @ApiImplicitParam(paramType = "query",name="avatar",value="头像",required = false,dataType="String"),
           @ApiImplicitParam(paramType = "query",name="account",value="账号",required = true,dataType="String"),
           @ApiImplicitParam(paramType = "query",name="password",value="密码",required = true,dataType="String"),
           @ApiImplicitParam(paramType = "query",name="salt",value="md5密码盐",required = false,dataType="String"),
           @ApiImplicitParam(paramType = "query",name="name",value="名字",required = true,dataType="String"),
           @ApiImplicitParam(paramType = "query",name="deptId",value="所属部门Id",required = false,dataType="long"),
           @ApiImplicitParam(paramType = "query",name="birthday",value="名字",required = false,dataType="Date"),
           @ApiImplicitParam(paramType = "query",name="sex",value="性别（1：男 2：女）",required = false,dataType="Integer"),
           @ApiImplicitParam(paramType = "query",name="email",value="电子邮件",required = false,dataType="String"),
           @ApiImplicitParam(paramType = "query",name="phone",value="电话",required = false,dataType="String"),
           @ApiImplicitParam(paramType = "query",name="status",value="状态(1：启用  2：冻结  3：删除）",required = false,dataType="Integer"),
           @ApiImplicitParam(paramType = "query",name="version",value="保留字段",required = false,dataType="Integer"),
           @ApiImplicitParam(paramType = "query",name="createBy",value="创建通过",required = false,dataType="long"),
           @ApiImplicitParam(paramType = "query",name="updateBy",value="更新通过",required = false,dataType="long"),
           @ApiImplicitParam(paramType = "query",name="createTime",value="创建时间",required = false,dataType="Date"),
           @ApiImplicitParam(paramType = "query",name="updateTime",value="更新时间",required = false,dataType="Date"),
           @ApiImplicitParam(paramType = "query",name="delFlag",value="是否删除",required = false,dataType="Boolean"),
   })
   @PostMapping("editUser")
   public JsonResult updateUser(@RequestBody SysUser sysUser){
      int userId =  sysUserService.editUser(sysUser);
       return JsonResultFactory.get(new HashMap<String,Object>(){{
           put("userId",userId);
       }});
   }

    @ApiOperation(value="删除用户接口")
    @GetMapping("/delete/{id}")
    public JsonResult deleteUser( @ApiParam(required=true, name="id", value="用户Id")@PathVariable("id") long id){
         sysUserService.deleteUser(id);
        return JsonResultFactory.ok();
    }

}

