package com.paper.question.dao.mapper;

import com.paper.question.domain.dto.SysRoleDto;
import com.paper.question.domain.entity.SysRole;

import java.util.List;

public interface SysRoleMapper {

    int deleteByPrimaryKey(Long id);

    int insertSelective(SysRole sysRole);

    SysRole selectByPrimaryKey(Long id);

    SysRoleDto findById(Long id);

    List<SysRoleDto> list();

    int updateByPrimaryKeySelective(SysRole record);
    
    List<String> selectRolesByUserid(Long id);
}