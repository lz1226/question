package com.paper.question.interfaces;

import com.paper.question.domain.entity.SysUserRole;

public interface ISysUserRoleService {
    /**
     * 创建用户与角色信息
     * @param sysUserRole
     * @return
     */
    int create(SysUserRole sysUserRole);

    /**
     * 修改用户与角色信息
     * @param sysUserRole
     * @return
     */
    int edit(SysUserRole sysUserRole);

    /**
     * 根据用户与角色的id删除用户与角色信息
     * @param id
     * @return
     */
    int delete(long id);
}
