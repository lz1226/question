package com.paper.question.shiro.model;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.paper.question.dao.mapper.SysUserMapper;
import com.paper.question.domain.entity.SysUser;
import com.paper.question.service.SysUserImpl;
import com.paper.question.shiro.domain.ResourceMap;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

/**
 * 
 * @description: 这里用一句话描述这个方法的作用 TODO
 * @author 郑晓龙
 * @update 2019年5月20日 下午2:22:10
 */
@Component
public class CustomRealm extends AuthorizingRealm {
	
    private final SysUserMapper sysUserMapper;
    
    @Autowired
    private SysUserImpl sysUserImpl ;
    
    @Autowired
    public CustomRealm(SysUserMapper userMapper) {
        this.sysUserMapper = userMapper;
    }
    
    

    /**
     * 获取身份验证信息
     * Shiro中，最终是通过 Realm 来获取应用程序中的用户、角色及权限信息的。
     *
     * @param authenticationToken 用户身份信息 token
     * @return 返回封装了用户信息的 AuthenticationInfo 实例
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("————身份认证方法————");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        // 从数据库获取对应用户名密码的用户
        String password = sysUserMapper.getPassword(token.getUsername());
        if (null == password) {
            throw new AccountException("用户名不正确");
        } else if (!password.equals(new String((char[]) token.getCredentials()))) {
            throw new AccountException("密码不正确");
        }
        return new SimpleAuthenticationInfo(token.getPrincipal(), password, getName());
    }

    /**
     * 
     * @description: 获取授权信息
     * @param principalCollection
     * @return
     * @author 郑晓龙
     * @update 2019年5月20日 下午3:42:29
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("————权限认证————");
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获得该用户角色
        SysUser sysUser = sysUserMapper.getRole(username);
        //需要将 role 封装到 Set 作为 info.setRoles() 的参数
        //获取到改用户的角色  以后再获取权限内容写道一个方法里边
        //自己定义一个 然后在获取到
        ResourceMap resourceMap = sysUserImpl.selectResourceMapByUserId(sysUser.getId());
        //设置该用户拥有的角色
        info.setRoles(resourceMap.getRoleSet());
        info.setStringPermissions(resourceMap.getPermissionSet());
        return info;
    }
}
