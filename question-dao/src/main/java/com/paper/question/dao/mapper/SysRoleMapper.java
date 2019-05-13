package com.paper.question.dao.mapper;

import com.paper.question.domain.entity.SysRole;

public interface SysRoleMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysRole sysRole);

    int insertSelective(SysRole sysRole);

    SysRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
}