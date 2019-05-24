package com.paper.question.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.paper.question.common.PageResult;
import com.paper.question.dao.mapper.SysRoleMapper;
import com.paper.question.domain.dto.SysRoleDto;
import com.paper.question.domain.entity.SysRole;
import com.paper.question.interfaces.ISysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysRoleImpl implements ISysRoleService{

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public PageResult list(SysRole sysRole) {

        Integer pageNum = PageResult.PageInfo.getPageNum(sysRole.getPageNum());
        Integer pageSize = PageResult.PageInfo.getPageSize(sysRole.getPageSize());
        Page<SysRoleDto> page = PageHelper.startPage(pageNum, pageSize).doSelectPage(() -> sysRoleMapper.list(sysRole));
        return new PageResult().get(page);
    }

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

    @Override
    public int batchDelete(Long[] ids) {

        return sysRoleMapper.batchDelete(ids);
    }
}
