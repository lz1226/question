package com.paper.question.dao.mapper;

import com.paper.question.domain.entity.SysUser;
import org.apache.ibatis.annotations.Param;


public interface SysUserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUser selectByNameAndPwd(@Param("name") String name,@Param("pwd") String pwd);
}