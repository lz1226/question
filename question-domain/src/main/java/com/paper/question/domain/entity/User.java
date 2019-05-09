package com.paper.question.domain.entity;

import java.util.Date;
import java.util.List;

/**
 * 管理员表
 * 
 * @author hs
 * @email 457030599@qq.com
 * @date 2018-10-07 18:03:20
 */

public class User {
	private static final long serialVersionUID = 1L;
	/**
	 * 主键id
	 */
	private Long id;
	/**
	 * 头像
	 */
	private String avatar;
	/**
	 * 账号
	 */
	private String account;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * md5密码盐
	 */
	private String salt;
	/**
	 * 名字
	 */
	private String name;
	/**
	 * 部门ID
	 */
	private Long deptId;
	/**
	 * 生日
	 */
	private Date birthday;
	/**
	 * 性别（1：男 2：女）
	 */
	private Integer sex;
	/**
	 * 电子邮件
	 */
	private String email;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 状态(1：启用  2：冻结  3：删除）
	 */
	private Integer status;
	/**
	 * 保留字段
	 */
	private Integer version;

	private String deptName;
	//查询
	private String deptIds;

	private List<Long> roleIds;

	private String sexName;

	private String statusName;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptIds() {
		return deptIds;
	}

	public void setDeptIds(String deptIds) {
		this.deptIds = deptIds;
	}

	public List<Long> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<Long> roleIds) {
		this.roleIds = roleIds;
	}

	public String getSexName() {
		return sexName;
	}

	public void setSexName(String sexName) {
		this.sexName = sexName;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", avatar='" + avatar + '\'' +
				", account='" + account + '\'' +
				", password='" + password + '\'' +
				", salt='" + salt + '\'' +
				", name='" + name + '\'' +
				", deptId=" + deptId +
				", birthday=" + birthday +
				", sex=" + sex +
				", email='" + email + '\'' +
				", phone='" + phone + '\'' +
				", status=" + status +
				", version=" + version +
				", deptName='" + deptName + '\'' +
				", deptIds='" + deptIds + '\'' +
				", roleIds=" + roleIds +
				", sexName='" + sexName + '\'' +
				", statusName='" + statusName + '\'' +
				'}';
	}
}
