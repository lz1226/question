package com.paper.question.dao.mapper;

import com.paper.question.domain.entity.SysUserRole;

public interface SysUserRoleMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysUserRole sysUserRole);

    int insertSelective(SysUserRole sysUserRole);


    SysUserRole selectByPrimaryKey(Long id);


    int updateByPrimaryKeySelective(SysUserRole sysUserRole);

    int updateByPrimaryKey(SysUserRole sysUserRole);
}