package com.paper.question.interfaces;

import com.paper.question.domain.dto.SysUserDto;
import com.paper.question.domain.entity.SysUser;
import com.paper.question.shiro.domain.ResourceMap;

public interface ISysUserService {

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
     
     /**
      * 
      * @description: 根据用户id 查询到用户的角色 和 权限
      * @param id
      * @return
      * @author 郑晓龙
      * @update 2019年5月20日 下午4:30:21
      */
     ResourceMap selectResourceMapByUserId(Long id);
}
