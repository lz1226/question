package com.paper.question.domain.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.paper.question.domain.common.Pagination;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

public class SysRole extends Pagination implements Serializable {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String roleName;

    private String remark;

    private Date createTime;

    private Date updateTime;

    private Long[] menuIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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


    public Long[] getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(Long[] menuIds) {
        this.menuIds = menuIds;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", menuIds=" + Arrays.toString(menuIds) +
                '}';
    }
}