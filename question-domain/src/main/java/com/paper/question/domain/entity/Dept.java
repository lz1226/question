package com.paper.question.domain.entity;
import java.util.List;


/**
 * 部门管理
 *
 * @author hs
 */
public class Dept{

    private Long id;
    // 上级部门ID，一级部门为0
    private Long parentId;
    // 部门名称
    private String name;
    // 排序
    private Integer orderNum;
    // 是否删除  -1：已删除  0：正常
    private Integer delFlag;

    private List<?> children;

    private String label;

    private String pname;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public List<?> getChildren() {
        return children;
    }

    public void setChildren(List<?> children) {
        this.children = children;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }


    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                ", orderNum=" + orderNum +
                ", delFlag=" + delFlag +
                ", children=" + children +
                ", label='" + label + '\'' +
                ", pname='" + pname + '\'' +
                '}';
    }
}
