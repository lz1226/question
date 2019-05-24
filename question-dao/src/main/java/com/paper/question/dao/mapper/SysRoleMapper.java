package com.paper.question.dao.mapper;

import com.paper.question.domain.dto.SysRoleDto;
import com.paper.question.domain.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleMapper {

    int deleteByPrimaryKey(Long id);

    int insertSelective(SysRole sysRole);

    SysRole selectByPrimaryKey(Long id);

    SysRoleDto findById(Long id);

    List<SysRoleDto> list(@Param("condition") SysRole sysRole);

    int updateByPrimaryKeySelective(SysRole record);
    
    List<String> selectRolesByUserid(Long id);

    int batchDelete(Long[] roleIds);
}