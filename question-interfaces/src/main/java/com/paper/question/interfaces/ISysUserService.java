package com.paper.question.interfaces;

import com.paper.question.common.PageResult;
import com.paper.question.domain.dto.SysUserDto;
import com.paper.question.domain.dto.SysUserEditDto;
import com.paper.question.domain.entity.SysUser;
import com.paper.question.shiro.domain.ResourceMap;

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
<<<<<<< HEAD
     
     /**
      * 
      * @description: 根据用户id 查询到用户的角色 和 权限
      * @param id
      * @return
      * @author 郑晓龙
      * @update 2019年5月20日 下午4:30:21
      */
     ResourceMap selectResourceMapByUserId(Long id);
=======

     int batchDelete(Long userIds[]);

     /**
      * 修改用户的状态
      * @param id
      * @param status
      * @return
      */
     int changeStatus(long id,Integer status);
>>>>>>> 72e304e4f0e0b63da055d9995e00b6dd70995a65
}
