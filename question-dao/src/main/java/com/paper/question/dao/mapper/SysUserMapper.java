package com.paper.question.dao.mapper;

import com.paper.question.domain.dto.SysUserDto;
import com.paper.question.domain.entity.SysUser;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysUserMapper {

    int deleteByPrimaryKey(long id);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(long id);

    SysUserDto finById(long id);

    int updateByPrimaryKeySelective(SysUser record);

    SysUser selectByNameAndPwd(@Param("name") String name,@Param("pwd") String pwd);

    List<SysUserDto> list();
}