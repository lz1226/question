package com.paper.question.service;

import com.paper.question.dao.mapper.SysRoleMapper;
import com.paper.question.domain.dto.SysRoleDto;
import com.paper.question.domain.entity.SysRole;
import com.paper.question.interfaces.ISysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysRoleImpl implements ISysRoleService{

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public SysRoleDto findById(long id) {
        return sysRoleMapper.findById(id);
    }

    @Override
    public int create(SysRole sysRole) {
        return sysRoleMapper.insertSelective(sysRole);
    }

    @Override
    public int edit(SysRole sysRole) {
        return sysRoleMapper.updateByPrimaryKeySelective(sysRole);
    }

    @Override
    public int delete(long id) {
        return sysRoleMapper.deleteByPrimaryKey(id);
    }
}
