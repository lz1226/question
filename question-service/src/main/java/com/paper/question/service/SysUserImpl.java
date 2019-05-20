package com.paper.question.service;

import com.paper.question.dao.mapper.SysUserMapper;
import com.paper.question.domain.dto.SysUserDto;
import com.paper.question.domain.entity.SysUser;
import com.paper.question.interfaces.ISysUserService;
import com.paper.question.shiro.domain.ResourceMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserImpl implements ISysUserService{

    @Resource
    private SysUserMapper sysUserMapper;

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

	@Override
	public ResourceMap selectResourceMapByUserId(Long id) {
//		List<String> list=hmrolemapper.selectRolesByUserid(userId);
//		ResourceMap resourcemap=new ResourceMap();
//		Set roles=new HashSet();
//		Set permissions=new HashSet();
//		for(String rolecode :list){
//			List<String> permission=hmpermissionmapper.selectPermissionByRolecode(rolecode);
//			for(String sign:permission){
//				permissions.add(sign);
//			}
//			roles.add(rolecode);
//		}
		
		
		//需要写逻辑
		ResourceMap resourceMap = new ResourceMap();
		//用户id 获取到改用户的 所有角色   然后根据角色 去拿角色的权限
		//然后附上值
		
		resourceMap.setRoleSet(null);
		resourceMap.setPermissionSet(null);
		return resourceMap;
	}
}
