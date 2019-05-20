package com.paper.question.interfaces;

import com.paper.question.common.PageResult;
import com.paper.question.domain.dto.SysUserDto;
import com.paper.question.domain.dto.SysUserEditDto;
import com.paper.question.domain.entity.SysUser;

public interface ISysUserService {

     /**
      * 分页查询用户信息
      */
     PageResult list( SysUser sysUser);
     /**
      * 用户登录
      * @param sysUser
      * @return
      */
     SysUser login(SysUser sysUser);

     /**
      * 通过id查找用户的信息
      * @param userId
      * @return
      */
     SysUserDto findById(long userId);

     /**
      * 创建用户信息
      * @param sysUser
      * @return
      */
     int createUser(SysUser sysUser);

     /**
      * 修改用户信息
      * @param sysUserEditDto
      * @return
      */
     int editUser(SysUserEditDto sysUserEditDto);

     /**
      * 根据用户的id删除用户信息
      * @param userId
      * @return
      */
     int deleteUser(long userId);

     int batchDelete(Long userIds[]);

     /**
      * 修改用户的状态
      * @param id
      * @param status
      * @return
      */
     int changeStatus(long id,Integer status);
}
