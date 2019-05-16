package com.paper.question.service;

import com.paper.question.dao.mapper.SysMenuMapper;
import com.paper.question.domain.dto.SysMenuDto;
import com.paper.question.domain.entity.SysMenu;
import com.paper.question.interfaces.ISysMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysMenuImpl implements ISysMenuService{

    @Resource
    private SysMenuMapper sysMenuMapper;

    @Override
    public SysMenuDto findById(long id) {
        return sysMenuMapper.findById(id);
    }

    @Override
    public int create(SysMenu sysMenu) {
        return  sysMenuMapper.insertSelective(sysMenu);
    }

    @Override
    public int edit(SysMenu sysMenu) {
        return sysMenuMapper.updateByPrimaryKeySelective(sysMenu);
    }

    @Override
    public int delete(long id) {
        return sysMenuMapper.deleteByPrimaryKey(id);
    }
}
