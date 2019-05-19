package com.paper.question.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.paper.question.common.PageResult;
import com.paper.question.common.Pagination;
import com.paper.question.dao.mapper.SysRoleMapper;
import com.paper.question.dao.mapper.SysUserMapper;
import com.paper.question.dao.mapper.SysUserRoleMapper;
import com.paper.question.domain.dto.SysUserDto;
import com.paper.question.domain.dto.SysUserEditDto;
import com.paper.question.domain.entity.SysUser;
import com.paper.question.domain.entity.SysUserRole;
import com.paper.question.interfaces.ISysUserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;


@Service
public class SysUserImpl implements ISysUserService{

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

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
    public int editUser(SysUserEditDto sysUserEditDto) {
        //更新用户的信息
       int userId = sysUserMapper.updateByPrimaryKeySelective(sysUserEditDto.getSysUser());
       //先将用户的角色进行删除再进行添加
        List<Long> roleId = sysUserEditDto.getRoleIds();
        roleId.forEach(item -> {
            sysUserRoleMapper.deleteByPrimaryKey(item);
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setRoleId(item);
            long uid = userId;
            sysUserRole.setUserId(uid);
            sysUserRoleMapper.insertSelective(sysUserRole);
         });

        return userId;
    }

    @Override
    public int deleteUser(long userId) {
        return sysUserMapper.deleteByPrimaryKey(userId);
    }
}
