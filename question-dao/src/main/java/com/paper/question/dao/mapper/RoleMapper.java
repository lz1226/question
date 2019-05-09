package com.paper.question.dao.mapper;

import com.paper.question.domain.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 角色
 *
 */
public interface RoleMapper {

    Integer getCountByRoleId(Long roleId);

    List<Long> getCheckMenuIds(Long roleId);

    void saveMenuPerms(@Param("role") Role role);

    void delMenuPermByRoleId(Long roleId);

}
