package com.paper.question.dao.mapper;

import com.paper.question.domain.entity.SysRoleMenu;

public interface SysRoleMenuMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysRoleMenu sysRoleMenu);

    int insertSelective(SysRoleMenu sysRoleMenu);


    SysRoleMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRoleMenu sysRoleMenu);

    int updateByPrimaryKey(SysRoleMenu sysRoleMenu);
}