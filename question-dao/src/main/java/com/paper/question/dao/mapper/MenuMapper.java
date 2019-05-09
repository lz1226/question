package com.paper.question.dao.mapper;
import java.util.List;
import java.util.Map;

/**
 * 菜单管理
 * 
 * @author hs
 * @email 457030599@qq.com
 * @date 2018-10-08 16:33:17
 */
public interface MenuMapper{

    /**
     * 根据父菜单，查询子菜单
     * @param parentId 父菜单ID
     */
    List<Map> queryListParentId(Long parentId);

    /**
     * 获取不包含按钮的菜单列表
     */
    List<Map> queryNotButtonList();
	
}
