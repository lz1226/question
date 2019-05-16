package com.paper.question.service;

import com.paper.question.dao.mapper.SysRoleMenuMapper;
import com.paper.question.domain.entity.SysRoleMenu;
import com.paper.question.interfaces.ISysRoleMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysRoleMenuImpl implements ISysRoleMenuService{

    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;
    @Override
    public int create(SysRoleMenu sysRoleMenu) {
        return sysRoleMenuMapper.insertSelective(sysRoleMenu);
    }

    @Override
    public int edit(SysRoleMenu sysRoleMenu) {
        return sysRoleMenuMapper.updateByPrimaryKeySelective(sysRoleMenu);
    }

    @Override
    public int delete(long id) {
        return sysRoleMenuMapper.deleteByPrimaryKey(id);
    }
}
