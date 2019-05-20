package com.paper.question.dao.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.paper.question.domain.dto.SysUserDto;
import com.paper.question.domain.entity.SysUser;


public interface SysUserMapper {

    int deleteByPrimaryKey(long id);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(long id);

    SysUserDto finById(long id);

    int updateByPrimaryKeySelective(SysUser record);

    SysUser selectByNameAndPwd(@Param("name") String name,@Param("pwd") String pwd);
    
    /**
     * 获得密码
     * @param username 用户名
     */
    String getPassword(@Param("username")String username);

    /**
     * 获得角色权限
     * @param username 用户名
     * @return user/admin
     */
    SysUser getRole(@Param("username")String username);

    List<SysUserDto> list(@Param("condition")SysUser pagination);

    int batchDelete(Long[] userIds);
}