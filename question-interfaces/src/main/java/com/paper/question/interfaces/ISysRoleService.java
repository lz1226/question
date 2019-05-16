package com.paper.question.interfaces;

import com.paper.question.domain.dto.SysRoleDto;
import com.paper.question.domain.entity.SysRole;

public interface ISysRoleService {
    /**
     * 通过id查找角色的信息
     * @param id
     * @return
     */
    SysRoleDto findById(long id);

    /**
     * 创建角色信息
     * @param sysRole
     * @return
     */
    int create(SysRole sysRole);

    /**
     * 修改角色信息
     * @param sysRole
     * @return
     */
    int edit(SysRole sysRole);

    /**
     * 根据角色的id删除角色信息
     * @param id
     * @return
     */
    int delete(long id);
}
