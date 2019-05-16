package com.paper.question.web.controller;

import com.paper.question.common.JsonResult;
import com.paper.question.common.JsonResultFactory;
import com.paper.question.domain.entity.SysRoleMenu;
import com.paper.question.interfaces.ISysRoleMenuService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
@RequestMapping("/sysRoleMenu")
@Api(value = "角色与菜单")
public class SysRoleMenuController {

    @Resource
    private ISysRoleMenuService sysRoleMenuService;

    @ApiOperation(value = "创建角色与菜单接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "角色与菜单名Id", required = true, dataType = "long"),
            @ApiImplicitParam(paramType = "query", name = "roleId", value = "角色ID", required = true, dataType = "long"),
            @ApiImplicitParam(paramType = "query", name = "menuId", value = "菜单ID", required = true, dataType = "long"),
    })
    @PostMapping("create")
    public JsonResult create(@RequestBody SysRoleMenu sysRoleMenu) {
        int id = sysRoleMenuService.create(sysRoleMenu);
        return JsonResultFactory.get(new HashMap<String, Object>() {{
            put("id", id);
        }});
    }

    @ApiOperation(value = "修改角色与菜单接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "角色与菜单名Id", required = true, dataType = "long"),
            @ApiImplicitParam(paramType = "query", name = "roleId", value = "角色ID", required = true, dataType = "long"),
            @ApiImplicitParam(paramType = "query", name = "menuId", value = "菜单ID", required = true, dataType = "long"),
    })
    @PostMapping("edit")
    public JsonResult update(@RequestBody SysRoleMenu sysRoleMenu) {
        int id = sysRoleMenuService.edit(sysRoleMenu);
        return JsonResultFactory.get(new HashMap<String, Object>() {{
            put("id", id);
        }});
    }

    @ApiOperation(value = "删除角色与菜单接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "角色与菜单名Id", required = true, dataType = "long"),
    })
    @GetMapping("/delete/{id}")
    public JsonResult delete(@ApiParam(required=true, name="id", value="角色与菜单Id")@PathVariable("id") long id) {
        sysRoleMenuService.delete(id);
        return JsonResultFactory.ok();
    }
}
