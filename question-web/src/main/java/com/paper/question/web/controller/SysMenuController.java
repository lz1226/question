package com.paper.question.web.controller;

import com.paper.question.common.JsonResult;
import com.paper.question.common.JsonResultFactory;
import com.paper.question.domain.dto.SysMenuDto;
import com.paper.question.domain.entity.SysMenu;
import com.paper.question.interfaces.ISysMenuService;
import io.swagger.annotations.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
    @RequestMapping("/sysMenu")
@Api(value = "菜单")
public class SysMenuController {

    @Resource
    private ISysMenuService sysMenuService;

    @ApiOperation(value="通过Id查找菜单接口")
    @GetMapping("/find/{id}")
    public JsonResult findUserById(@ApiParam(required=true, name="id", value="菜单Id")@PathVariable("id") long id){
        SysMenuDto sysMenuDto = sysMenuService.findById(id);
        return JsonResultFactory.get(sysMenuDto);
    }

    @ApiOperation(value="创建菜单接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name="id",value="菜单名Id",required = true,dataType="long"),
            @ApiImplicitParam(paramType = "query",name="parentId",value="父菜单ID，一级菜单为0",required = true,dataType="long"),
            @ApiImplicitParam(paramType = "query",name="name",value="菜单名称",required = true,dataType="String"),
            @ApiImplicitParam(paramType = "query",name="url",value="菜单URL",required = true,dataType="String"),
            @ApiImplicitParam(paramType = "query",name="perms",value="授权(多个用逗号分隔，如：user:list,user:create)",required = true,dataType="String"),
            @ApiImplicitParam(paramType = "query",name="type",value="类型0：目录1：菜单 2：按钮",required = true,dataType="Integer"),
            @ApiImplicitParam(paramType = "query",name="icon",value="菜单图标",required = false,dataType="String"),
            @ApiImplicitParam(paramType = "query",name="orderNum",value="排序",required = false,dataType="Integer"),
            @ApiImplicitParam(paramType = "query",name="createBy",value="创建通过。。",required = false,dataType="Long"),
            @ApiImplicitParam(paramType = "query",name="updateBy",value="更新通过。。",required = false,dataType="Long"),
            @ApiImplicitParam(paramType = "query",name="createTime",value="创建时间",required = false,dataType="Date"),
            @ApiImplicitParam(paramType = "query",name="updateTime",value="更新时间",required = false,dataType="Date"),
            @ApiImplicitParam(paramType = "query",name="delFlag",value="是否删除",required = false,dataType="Boolean"),
    })
    @PostMapping("/create")
    public JsonResult create(@RequestBody SysMenu sysMenu){
        int id = sysMenuService.create(sysMenu);
        return JsonResultFactory.get(new HashMap<String,Object>(){{
            put("id",id);
        }});
    }

    @ApiOperation(value="修改菜单接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name="id",value="菜单名Id",required = true,dataType="long"),
            @ApiImplicitParam(paramType = "query",name="parentId",value="父菜单ID，一级菜单为0",required = true,dataType="long"),
            @ApiImplicitParam(paramType = "query",name="name",value="菜单名称",required = true,dataType="String"),
            @ApiImplicitParam(paramType = "query",name="url",value="菜单URL",required = true,dataType="String"),
            @ApiImplicitParam(paramType = "query",name="perms",value="授权(多个用逗号分隔，如：user:list,user:create)",required = true,dataType="String"),
            @ApiImplicitParam(paramType = "query",name="type",value="类型   0：目录   1：菜单   2：按钮",required = true,dataType="Integer"),
            @ApiImplicitParam(paramType = "query",name="icon",value="菜单图标",required = false,dataType="String"),
            @ApiImplicitParam(paramType = "query",name="orderNum",value="排序",required = false,dataType="Integer"),
            @ApiImplicitParam(paramType = "query",name="createBy",value="创建通过。。",required = false,dataType="long"),
            @ApiImplicitParam(paramType = "query",name="updateBy",value="更新通过。。",required = false,dataType="long"),
            @ApiImplicitParam(paramType = "query",name="createTime",value="创建时间",required = false,dataType="Date"),
            @ApiImplicitParam(paramType = "query",name="updateTime",value="更新时间",required = false,dataType="Date"),
            @ApiImplicitParam(paramType = "query",name="delFlag",value="是否删除",required = false,dataType="Boolean"),
    })
    @PostMapping("/edit")
    public JsonResult update(@RequestBody SysMenu sysMenu){
        int id =  sysMenuService.edit(sysMenu);
        return JsonResultFactory.get(new HashMap<String,Object>(){{
            put("id",id);
        }});
    }

    @ApiOperation(value="删除菜单接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name="id",value="菜单名Id",required = true,dataType="long"),
    })
    @GetMapping("/delete/{id}")
    public JsonResult delete( @ApiParam(required=true, name="id", value="菜单Id")@PathVariable("id") long id){
        sysMenuService.delete(id);
        return JsonResultFactory.ok();
    }

    @GetMapping("/tree/menu")
    public JsonResult treeMenu(SysMenuDto sysMenuDto){
        System.out.println("参数信息");
        System.out.println(sysMenuDto);
        System.out.println(JsonResultFactory.get(sysMenuService.treeMenuList(0L,sysMenuDto)));
        return JsonResultFactory.get(sysMenuService.treeMenuList(0L,sysMenuDto));
    }

    /**
     * 批量删除用户的信息
     */
    @PostMapping("/batchDelete")
    public JsonResult batchDelete(@RequestBody Long ids[]){
        System.out.println("参数");
        System.out.println(ids);
        sysMenuService.batchDelete(ids);
        return JsonResultFactory.ok();
    }
}
