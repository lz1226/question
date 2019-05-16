package com.paper.question.dao.mapper;

import com.paper.question.domain.dto.SysRoleDto;
import com.paper.question.domain.entity.SysRole;

public interface SysRoleMapper {

    int deleteByPrimaryKey(Long id);

    int insertSelective(SysRole sysRole);

    SysRole selectByPrimaryKey(Long id);

    SysRoleDto findById(Long id);

    int updateByPrimaryKeySelective(SysRole record);
}