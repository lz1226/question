package com.paper.question.interfaces;

import com.paper.question.domain.entity.SysRoleMenu;

public interface ISysRoleMenuService {
    /**
     * 创建角色与菜单信息
     * @param sysRoleMenu
     * @return
     */
    int create(SysRoleMenu sysRoleMenu);

    /**
     * 修改角色与菜单信息
     * @param sysRoleMenu
     * @return
     */
    int edit(SysRoleMenu sysRoleMenu);

    /**
     * 根据角色与菜单的id删除角色与菜单信息
     * @param id
     * @return
     */
    int delete(long id);
}
