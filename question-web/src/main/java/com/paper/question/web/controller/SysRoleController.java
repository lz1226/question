package com.paper.question.web.controller;

import com.paper.question.common.JsonResult;
import com.paper.question.common.JsonResultFactory;
import com.paper.question.domain.dto.SysRoleDto;
import com.paper.question.domain.entity.SysRole;
import com.paper.question.interfaces.ISysRoleService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
@RequestMapping("/sysRole")
@Api(value = "角色")
public class SysRoleController {
    
    @Resource
    private ISysRoleService sysRoleService;

    @ApiOperation(value="通过Id查找角色接口")
    @GetMapping("/find/{id}")
    public JsonResult findById(@ApiParam(required=true, name="id", value="角色Id")@PathVariable("id") long id){
        SysRoleDto sysRole = sysRoleService.findById(id);
        return JsonResultFactory.get(sysRole);
    }

    @ApiOperation(value="创建角色接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name="id",value="角色名Id",required = true,dataType="long"),
            @ApiImplicitParam(paramType = "query",name="roleName",value="角色名称",required = true,dataType="String"),
            @ApiImplicitParam(paramType = "query",name="remark",value="备注",required = true,dataType="String"),
            @ApiImplicitParam(paramType = "query",name="createTime",value="创建时间",required = false,dataType="Date"),
            @ApiImplicitParam(paramType = "query",name="updateTime",value="更新时间",required = false,dataType="Date"),
    })
    @PostMapping("create")
    public JsonResult create(@RequestBody SysRole sysRole){
        int id = sysRoleService.create(sysRole);
        return JsonResultFactory.get(new HashMap<String,Object>(){{
            put("id",id);
        }});
    }

    @ApiOperation(value="修改角色接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name="id",value="角色名Id",required = true,dataType="long"),
            @ApiImplicitParam(paramType = "query",name="roleName",value="角色名称",required = true,dataType="String"),
            @ApiImplicitParam(paramType = "query",name="remark",value="备注",required = true,dataType="String"),
            @ApiImplicitParam(paramType = "query",name="createTime",value="创建时间",required = false,dataType="Date"),
            @ApiImplicitParam(paramType = "query",name="updateTime",value="更新时间",required = false,dataType="Date"),
    })
    @PostMapping("edit")
    public JsonResult update(@RequestBody SysRole sysRole){
        int id =  sysRoleService.edit(sysRole);
        return JsonResultFactory.get(new HashMap<String,Object>(){{
            put("id",id);
        }});
    }

    @ApiOperation(value="删除角色接口")
    @GetMapping("/delete/{id}")
    public JsonResult delete(@ApiParam(required=true, name="id", value="角色Id")@PathVariable("id") long id){
        sysRoleService.delete(id);
        return JsonResultFactory.ok();
    }
}
