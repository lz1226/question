package com.paper.question.dao.mapper;

import java.util.List;

import com.paper.question.domain.dto.SysMenuDto;
import com.paper.question.domain.entity.SysMenu;


public interface SysMenuMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysMenu sysMenu);

    int insertSelective(SysMenu sysMenu);

    SysMenu selectByPrimaryKey(Long id);

    SysMenuDto findById(Long id);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);
    
    List<String> selectMenuByRolecode(Long id);
}