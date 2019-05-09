package com.paper.question.dao.mapper;

import com.paper.question.domain.entity.Dept;

import java.util.List;

/**
 * 部门管理
 * 
 * @author hs
 * @email 457030599@qq.com
 * @date 2018-12-17 15:21:00
 */
public interface DeptMapper{

    List<Dept> queryListParentId(Long parentId);



}
