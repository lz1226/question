package com.paper.question.dao.mapper;

import com.paper.question.domain.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 管理员表
 * 
 * @author hs
 * @email 457030599@qq.com
 * @date 2018-10-07 18:03:20
 */
public interface UserMapper{

//    IPage<Map> selectPageList(Page page, @Param("user") User user);

    /**
     * 查询用户的所有权限
     * @param userId  用户ID
     */
    List<String> queryAllPerms(Long userId);

    /**
     * 查询用户的所有菜单ID
     */
    List<Long> queryAllMenuId(Long userId);


    List<Long> getRoleIdsById(@Param("userId") Long userId);

    void saveUserRole(@Param("user") User user);

    void delURByUserId(Long userId);

    User selectOne(@Param("account") String account);

}
