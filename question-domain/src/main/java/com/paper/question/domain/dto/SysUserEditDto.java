package com.paper.question.domain.dto;

import com.paper.question.domain.entity.SysUser;
import io.swagger.annotations.ApiParam;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SysUserEditDto implements Serializable {
	private SysUser sysUser;
    private List<Long> roleIds;

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public List<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }

    @Override
    public String toString() {
        return "SysUserEditDto{" +
                "sysUser=" + sysUser +
                ", roleIds=" + roleIds +
                '}';
    }
}