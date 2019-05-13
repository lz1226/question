package com.paper.question.dao.mapper;

import com.paper.question.domain.entity.SysMenu;


public interface SysMenuMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysMenu sysMenu);

    int insertSelective(SysMenu sysMenu);

    SysMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);
}