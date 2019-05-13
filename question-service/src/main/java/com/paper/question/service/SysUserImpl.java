package com.paper.question.service;

import com.paper.question.dao.mapper.SysUserMapper;
import com.paper.question.domain.entity.SysUser;
import com.paper.question.interfaces.ISysUserService;
import org.springframework.stereotype.Service;

@Service
public class SysUserImpl implements ISysUserService{

    private SysUserMapper sysUserMapper;

    @Override
    public SysUser login(SysUser sysUser) {
        System.out.println("信息。。。"+sysUser);
       SysUser sysUser1 = sysUserMapper.selectByNameAndPwd(sysUser.getAccount(),sysUser.getPassword());
        sysUser1.setAccount("aa");
        System.out.println("信息2。。。"+sysUser1);
        return sysUser1;
    }
}
