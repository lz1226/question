package com.paper.question.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.paper.question.common.PageResult;
import com.paper.question.dao.mapper.SysMenuMapper;
import com.paper.question.dao.mapper.SysRoleMapper;
import com.paper.question.dao.mapper.SysUserMapper;
import com.paper.question.dao.mapper.SysUserRoleMapper;
import com.paper.question.domain.dto.SysUserDto;
import com.paper.question.domain.dto.SysUserEditDto;
import com.paper.question.domain.entity.SysUser;
import com.paper.question.domain.entity.SysUserRole;
import com.paper.question.interfaces.ISysUserService;
import com.paper.question.shiro.domain.ResourceMap;


@Service
public class SysUserImpl implements ISysUserService{

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Resource
    private SysMenuMapper sysMenuMapper;
    
    
    @Override
    public PageResult list( SysUser pagination) {
        System.out.println("用户分页");
        System.out.println(pagination);
        Integer pageNum = PageResult.PageInfo.getPageNum(pagination.getPageNum());
        Integer pageSize = PageResult.PageInfo.getPageSize(pagination.getPageSize());
        Page<SysUserDto> page = PageHelper.startPage(pageNum, pageSize).doSelectPage(() -> sysUserMapper.list(pagination));
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
        int userId = 0;
        if(sysUserEditDto.getSysUser().getId() != null){
            //更新用户的信息
            userId =  sysUserMapper.updateByPrimaryKeySelective(sysUserEditDto.getSysUser());

        }else{
            //初始密码为123456
           sysUserEditDto.getSysUser().setPassword("123456");
           userId = sysUserMapper.insertSelective(sysUserEditDto.getSysUser());
        }
        //先将用户的角色进行删除再进行添加
        List<Long> roleId = sysUserEditDto.getRoleIds();
        System.out.println("角色信息");
        System.out.println(roleId);
        if(roleId != null){
            for (Long item: roleId) {
                sysUserRoleMapper.deleteByPrimaryKey(item);
                SysUserRole sysUserRole = new SysUserRole();
                sysUserRole.setRoleId(item);
                long uid = userId;
                sysUserRole.setUserId(uid);
                sysUserRoleMapper.insertSelective(sysUserRole);
            }
        }
//        roleId.forEach(item -> {
//
//        });

        return userId;
    }

    @Override
    public int deleteUser(long userId) {
        return sysUserMapper.deleteByPrimaryKey(userId);
    }
    
   
	@Override
	public ResourceMap selectResourceMapByUserId(Long id) {
		Set roles=new HashSet();
		Set permissions=new HashSet();
		List<String> list = sysRoleMapper.selectRolesByUserid(id);
		for (String roleId : list) {
			List<String> permission = sysMenuMapper.selectMenuByRolecode(Long.parseLong(roleId));
			for (String sign : permission) {
				permissions.add(sign);
			}
			roles.add(roleId);
		}
		//需要写逻辑
		ResourceMap resourceMap = new ResourceMap();		
		resourceMap.setRoleSet(roles);
		resourceMap.setPermissionSet(permissions);
		return resourceMap;
	}
    @Override
    public int batchDelete(Long[] userIds) {
        return sysUserMapper.batchDelete(userIds);
    }

    @Override
    public int changeStatus(long id, Integer status) {
        SysUser sysUser = new SysUser();
        sysUser.setId(id);
        sysUser.setStatus(status);
        return sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }
}
