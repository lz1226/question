package com.paper.question.service;

import com.paper.question.dao.mapper.SysUserRoleMapper;
import com.paper.question.domain.entity.SysUserRole;
import com.paper.question.interfaces.ISysUserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserRoleImpl implements ISysUserRoleService{

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public int create(SysUserRole sysUserRole) {
        return sysUserRoleMapper.insertSelective(sysUserRole);
    }

    @Override
    public int edit(SysUserRole sysUserRole) {
        return sysUserRoleMapper.updateByPrimaryKeySelective(sysUserRole);
    }

    @Override
    public int delete(long id) {
        return sysUserRoleMapper.deleteByPrimaryKey(id);
    }
}
