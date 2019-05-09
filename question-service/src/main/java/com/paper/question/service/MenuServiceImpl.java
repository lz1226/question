package com.paper.question.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 菜单管理
 *
 * @author hs
 * @email 457030599@qq.com
 * @date 2018-10-08 16:33:17
 */
@Service
public class MenuServiceImpl{

//    @Autowired
//    private IUserService userService;
//
//
//
//    @Override
//    @Cacheable(value = Cache.CONSTANT, key = "'" + CacheKey.USER_ID + "'+#userId")
//    public List<Map> getUserMenuList(Long userId) {
//
//        //系统管理员，拥有最高权限
//        if(userId == Constant.SUPER_ADMIN){
//            return getAllMenuList(null);
//        }
//
//        //用户菜单列表
//        List<Long> menuIdList = userService.queryAllMenuId(userId);
//        return getAllMenuList(menuIdList);
//    }
}
