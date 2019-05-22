package com.paper.question.domain.entity;

import com.paper.question.domain.common.Pagination;
import io.swagger.annotations.ApiParam;

import java.io.Serializable;
import java.util.Date;

public class SysUser extends Pagination implements Serializable {
	
	@ApiParam(hidden = true)
    private Long id;
	@ApiParam(hidden = true)
    private String avatar;
	@ApiParam(hidden = true)
    private String account;
	@ApiParam(hidden = true)
    private String password;
	@ApiParam(hidden = true)
    private String salt;
	@ApiParam(hidden = true)
    private String name;
	@ApiParam(hidden = true)
    private Long deptId;
	@ApiParam(hidden = true)
    private Date birthday;
	@ApiParam(hidden = true)
    private Integer sex;
	@ApiParam(hidden = true)
    private String email;
	@ApiParam(hidden = true)
    private String phone;
	@ApiParam(hidden = true)
    private Integer status;
	@ApiParam(hidden = true)
    private Integer version;
	@ApiParam(hidden = true)
    private Long createBy;
	@ApiParam(hidden = true)
    private Long updateBy;
	@ApiParam(hidden = true)
    private Date createTime;
	@ApiParam(hidden = true)
    private Date updateTime;
	@ApiParam(hidden = true)
    private Boolean delFlag;
	private Integer headImageId;

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

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getHeadImageId() {
        return headImageId;
    }

    public void setHeadImageId(Integer headImageId) {
        this.headImageId = headImageId;
    }

    @Override
    public String toString() {
        return "SysUser{" +
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
                ", createBy=" + createBy +
                ", updateBy=" + updateBy +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", delFlag=" + delFlag +
                ", headImageId=" + headImageId +
                '}';
    }
}