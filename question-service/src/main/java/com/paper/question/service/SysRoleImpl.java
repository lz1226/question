package com.paper.question.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.paper.question.common.PageResult;
import com.paper.question.dao.mapper.SysRoleMapper;
import com.paper.question.dao.mapper.SysRoleMenuMapper;
import com.paper.question.domain.dto.SysRoleDto;
import com.paper.question.domain.entity.SysRole;
import com.paper.question.domain.entity.SysRoleMenu;
import com.paper.question.interfaces.ISysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysRoleImpl implements ISysRoleService{

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;

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

    @Override
    public int saveMuenPerms(SysRole role) {
        //先删除这个角色的权限再添加这个角色的权限
        sysRoleMenuMapper.deleteByRoleId(role.getId());
        for (Long item: role.getMenuIds()) {
            SysRoleMenu sysRoleMenu = new SysRoleMenu();
            sysRoleMenu.setRoleId(role.getId());
            sysRoleMenu.setMenuId(item);
            sysRoleMenuMapper.insertSelective(sysRoleMenu);
        }
        return 0;
    }

    @Override
    public List<Long> getCheckMenuIds(Long roleId) {
        return sysRoleMenuMapper.getCheckMenuIds(roleId);
    }
}
