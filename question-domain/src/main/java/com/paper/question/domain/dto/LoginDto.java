package com.paper.question.domain.dto;

import com.paper.question.domain.entity.SysUser;

public class LoginDto {
    String name;
    String password;

    SysUser sysUser;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    @Override
    public String toString() {
        return "LoginDto{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sysUser=" + sysUser +
                '}';
    }
}
