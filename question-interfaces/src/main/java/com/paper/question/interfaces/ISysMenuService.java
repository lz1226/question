package com.paper.question.interfaces;

import com.paper.question.common.PageResult;
import com.paper.question.domain.dto.SysMenuDto;
import com.paper.question.domain.entity.SysMenu;
import com.paper.question.domain.entity.SysRole;

import java.util.List;
import java.util.Map;

public interface ISysMenuService {
    /**
     * 通过id查找菜单的信息
     * @param id
     * @return
     */
    SysMenuDto findById(long id);

    /**
     * 创建菜单信息
     * @param sysMenu
     * @return
     */
    int create(SysMenu sysMenu);

    /**
     * 修改菜单信息
     * @param sysMenu
     * @return
     */
    int edit(SysMenu sysMenu);

    /**
     * 根据菜单的id删除菜单信息
     * @param id
     * @return
     */
    int delete(long id);

    /**
     * 获取树形菜单列表
     */
    List<SysMenuDto> treeMenuList(Long menuId, SysMenuDto sysMenu);
    
    /**
     * 查询权限列表
     * @return
     */
    PageResult list(SysRole sysRole);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int batchDelete(Long ids[]);

    /**
     * 获取该角色的菜单列表
     */
    List<SysMenuDto> getUserMenuList(Long userId);
}
