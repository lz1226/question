package com.paper.question.interfaces;

import com.paper.question.common.PageResult;
import com.paper.question.common.Pagination;
import com.paper.question.domain.dto.SysUserDto;
import com.paper.question.domain.entity.SysUser;

public interface ISysUserService {

     /**
      * 分页查询用户信息
      */
     PageResult list(Pagination pagination);
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
      * @param sysUser
      * @return
      */
     int editUser(SysUser sysUser);

     /**
      * 根据用户的id删除用户信息
      * @param userId
      * @return
      */
     int deleteUser(long userId);
}
