package com.paper.question.web.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import com.paper.question.domain.dto.LoginDto;
import com.paper.question.domain.dto.SysUserDto;
import com.paper.question.domain.dto.SysUserEditDto;
import io.swagger.annotations.*;

import org.apache.shiro.authz.annotation.RequiresPermissions;
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

    
    /**
     * 分页查找用户列表信息
     * @param sysUser
     * @return
     */
    @ApiOperation(value="查找用户列表接口")
    @PostMapping("/list")
//    @RequiresPermissions("sys:user:list")
    public JsonResult list(@RequestBody SysUser sysUser){
        return sysUserService.list(sysUser);
    }

    /**
     * 根据用户的id查找用户信息
     * @param id
     * @return
     */
    @ApiOperation(value="通过Id查找用户接口")
    @GetMapping("/find/{id}")
    public JsonResult findUserById( @ApiParam(required=true, name="id", value="用户Id")@PathVariable("id") long id){
        SysUserDto sysUser = sysUserService.findById(id);
        return JsonResultFactory.get(sysUser);
    }

    /**
     * 创建用户信息
     * @param sysUser
     * @return
     */
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
    @PostMapping("/createUser")
    public JsonResult createUser(@RequestBody SysUser sysUser){
       int userId = sysUserService.createUser(sysUser);
        return JsonResultFactory.get(new HashMap<String,Object>(){{
            put("userId",userId);
        }});
   }

    /**
     * 修改用户信息
     * @return
     */
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
   @PostMapping("/editUser")
   public JsonResult updateUser(@RequestBody SysUserEditDto sysUserEditDto){
      int userId =  sysUserService.editUser(sysUserEditDto);
       return JsonResultFactory.get(new HashMap<String,Object>(){{
           put("userId",userId);
       }});
   }

    /**
     * 删除用户信息
     * @param id
     * @return
     */
    @ApiOperation(value="删除用户接口")
    @GetMapping("/delete/{id}")
    public JsonResult deleteUser( @ApiParam(required=true, name="id", value="用户Id")@PathVariable("id") long id){
         sysUserService.deleteUser(id);
        return JsonResultFactory.ok();
    }
    /**
     * 批量删除用户的信息
     */
    @PostMapping("batchDelete")
    public JsonResult batchDelete(@RequestBody Long ids[]){
        sysUserService.batchDelete(ids);
        return JsonResultFactory.ok();
    }

    /**
     * 更新用户的状态
     */
    @GetMapping("/changeStatus/{id}/{status}")
    public JsonResult changeStatus(@PathVariable("id") long id,@PathVariable("status") Integer status){
        sysUserService.changeStatus( id,status);
        return JsonResultFactory.ok();
    }

}

