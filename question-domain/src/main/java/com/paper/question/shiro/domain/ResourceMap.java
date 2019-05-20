package com.paper.question.shiro.domain;


import java.io.Serializable;
import java.util.Set;

 
/**
 * 
 * @description: 用于装 角色 和 权限
 * @author 郑晓龙
 * @update 2019年5月20日 下午4:07:20
 */
public class ResourceMap implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5791382636181185749L;

	private Set<String> RoleSet;
	
	private Set<String> PermissionSet;

	public Set<String> getRoleSet() {
		return RoleSet;
	}

	public Set<String> getPermissionSet() {
		return PermissionSet;
	}

	public void setRoleSet(Set<String> roleSet) {
		RoleSet = roleSet;
	}

	public void setPermissionSet(Set<String> permissionSet) {
		PermissionSet = permissionSet;
	}
}
