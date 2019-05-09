package com.paper.question.interfaces;

import java.util.List;
import java.util.Map;

public interface IMenuService {
    /**
     * 获取该角色的菜单列表
     */
    List<Map> getUserMenuList(Long userId);
}
