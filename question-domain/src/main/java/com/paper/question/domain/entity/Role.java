package com.paper.question.domain.entity;

import java.util.Arrays;


/**
 * 角色
 *
 */
public class Role{

    //
    private Long id;
    // 角色名称
    private String roleName;
    // 备注
    private String remark;

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

    public Long[] getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(Long[] menuIds) {
        this.menuIds = menuIds;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", remark='" + remark + '\'' +
                ", menuIds=" + Arrays.toString(menuIds) +
                '}';
    }
}
