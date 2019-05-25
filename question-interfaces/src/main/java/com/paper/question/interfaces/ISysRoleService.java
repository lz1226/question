package com.paper.question.interfaces;

import com.paper.question.common.PageResult;
import com.paper.question.domain.dto.SysRoleDto;
import com.paper.question.domain.entity.SysRole;

import java.util.List;

public interface ISysRoleService {

    /**
     * 查询角色列表
     * @return
     */
    PageResult list(SysRole sysRole);

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

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int batchDelete(Long ids[]);

    /**
     * 保存角色的权限信息
     * @param role
     * @return
     */
    int saveMuenPerms(SysRole role);

    /**
     * 检查角色的信息
     * @param roleId
     * @return
     */
    List<Long> getCheckMenuIds(Long roleId);
}
