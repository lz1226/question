package com.paper.question.web.controller;

import com.paper.question.common.JsonResult;
import com.paper.question.common.JsonResultFactory;
import com.paper.question.domain.entity.SysUserRole;
import com.paper.question.interfaces.ISysUserRoleService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
@RequestMapping("/sysUserRole")
@Api(value = "用户与角色")
public class SysUserRoleController {

    @Resource
    private ISysUserRoleService sysUserRoleService;

    @ApiOperation(value="创建用户与角色接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name="id",value="id",required = true,dataType="long"),
            @ApiImplicitParam(paramType = "query",name="userId",value="用户ID",required = true,dataType="long"),
            @ApiImplicitParam(paramType = "query",name="roleId",value="角色ID",required = true,dataType="long"),
    })
    @PostMapping("create")
    public JsonResult create(@RequestBody SysUserRole sysUserRole){
       int id = sysUserRoleService.create(sysUserRole);
        return JsonResultFactory.get(new HashMap<String,Object>(){{
            put("id",id);
        }});
    }

    @ApiOperation(value="修改用户与角色接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name="id",value="id",required = true,dataType="long"),
            @ApiImplicitParam(paramType = "query",name="userId",value="用户ID",required = true,dataType="long"),
            @ApiImplicitParam(paramType = "query",name="roleId",value="角色ID",required = true,dataType="long"),
    })
    @PostMapping("edit")
    public JsonResult update(@RequestBody SysUserRole sysUserRole){
        int id = sysUserRoleService.edit(sysUserRole);
        return JsonResultFactory.get(new HashMap<String,Object>(){{
            put("id",id);
        }});
    }

    @ApiOperation(value="删除角色与用户接口")
    @GetMapping("/delete/{id}")
    public JsonResult delete(@ApiParam(required=true, name="id", value="角色与用户Id")@PathVariable("id") long id){
        sysUserRoleService.delete(id);
        return JsonResultFactory.ok();
    }
}
