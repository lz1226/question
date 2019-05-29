package com.paper.question.dao.mapper;

import java.util.List;
import java.util.Map;

import com.paper.question.domain.dto.SysMenuDto;
import com.paper.question.domain.entity.SysMenu;
import org.apache.ibatis.annotations.Param;


public interface SysMenuMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysMenu sysMenu);

    int insertSelective(SysMenu sysMenu);

    SysMenu selectByPrimaryKey(Long id);

    SysMenuDto findById(Long id);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);
    
    List<String> selectMenuByRolecode(Long id);

    /**
     * 根据父菜单，查询子菜单
     * @param parentId 父菜单ID
     */
    List<SysMenuDto> queryListParentId(@Param("parentId") Long parentId);

    int batchDelete(Long[] roleIds);
}