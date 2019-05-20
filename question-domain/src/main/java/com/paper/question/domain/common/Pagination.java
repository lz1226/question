package com.paper.question.domain.common;

public class Pagination {

    private Integer pageNum;
    private Integer pageSize;

    public Pagination() {
    }

    @Override
    public String toString() {
        return "Pagination{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
