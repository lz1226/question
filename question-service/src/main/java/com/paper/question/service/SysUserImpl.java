package com.paper.question.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.paper.question.common.PageResult;
import com.paper.question.common.Pagination;
import com.paper.question.dao.mapper.SysUserMapper;
import com.paper.question.domain.dto.SysUserDto;
import com.paper.question.domain.entity.SysUser;
import com.paper.question.interfaces.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserImpl implements ISysUserService{

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public PageResult list(Pagination pagination) {
        Integer pageNum = PageResult.PageInfo.getPageNum(pagination.getPageNum());
        Integer pageSize = PageResult.PageInfo.getPageSize(pagination.getPageSize());
        Page<SysUserDto> page = PageHelper.startPage(pageNum, pageSize).doSelectPage(() -> sysUserMapper.list());
        return new PageResult().get(page);
    }

    @Override
    public SysUser login(SysUser sysUser) {
       sysUser = sysUserMapper.selectByNameAndPwd(sysUser.getName(),sysUser.getPassword());
       return sysUser;
    }

    //通过Id查找用户的信息
    @Override
    public SysUserDto findById(long userId) {
       SysUserDto sysUserDto = sysUserMapper.finById(userId);
        return sysUserDto;
    }

    @Override
    public int createUser(SysUser sysUser) {
       int id = sysUserMapper.insertSelective(sysUser);
        return id;
    }

    @Override
    public int editUser(SysUser sysUser) {
        return sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }

    @Override
    public int deleteUser(long userId) {
        return sysUserMapper.deleteByPrimaryKey(userId);
    }
}
