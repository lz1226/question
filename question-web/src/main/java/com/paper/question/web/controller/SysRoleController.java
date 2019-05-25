package com.paper.question.web.controller;

import com.paper.question.common.JsonResult;
import com.paper.question.common.JsonResultFactory;
import com.paper.question.domain.dto.SysRoleDto;
import com.paper.question.domain.entity.SysRole;
import com.paper.question.interfaces.ISysRoleService;
import io.swagger.annotations.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/sysRole")
@Api(value = "角色")
public class SysRoleController {
    
    @Resource
    private ISysRoleService sysRoleService;

    /**
     * 查找用户角色列表信息
     * @return
     */
    @ApiOperation(value="查找用户列表接口")
    @PostMapping("/list")
    public JsonResult list(@RequestBody SysRole sysRole){
        return sysRoleService.list(sysRole);
    }
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
        System.out.println("编辑");
        System.out.println(sysRole);
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

    /**
     * 批量删除用户的信息
     */
    @PostMapping("batchDelete")
    public JsonResult batchDelete(@RequestBody Long ids[]){
        System.out.println("参数");
        System.out.println(ids);
        sysRoleService.batchDelete(ids);
        return JsonResultFactory.ok();
    }

//    @RequiresPermissions("sys:role:saveMenuPerm")
    @PostMapping(value = "/save/menuRole")
    public JsonResult saveMuenPerms(@RequestBody SysRole role){
        System.out.println("角色权限信息");
        System.out.println(role);
        sysRoleService.saveMuenPerms(role);
        return JsonResultFactory.ok();
    }

    @ApiOperation(value = "获取角色的菜单权限")
    @GetMapping(value = "/menu/list/{roleId}")
    public Object roleMenuList(@PathVariable("roleId") Long roleId)  {
        System.out.println("获取角色的菜单权限");
        System.out.println(roleId);
        List<String> strings = new ArrayList<>();
        List<Long> item = sysRoleService.getCheckMenuIds(roleId);
        item.forEach(i->{
            String it = i.toString();
            strings.add(it);
        });
        return  JsonResultFactory.get(strings);
    }
}
