package com.paper.question.common;

import com.github.pagehelper.Page;

public class PageResult extends JsonResult {

    private PageInfo pagination;

    public <T> PageResult get(Page<T> page) {
        JsonResult result = JsonResultFactory.get(page.getResult());
        // 构造结果信息
        setCode(result.getCode());
        setData(result.getData());
        setError(result.getError());
        setDesc(result.getDesc());

        // 构造分页信息
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPages(page.getPages());
        pageInfo.setTotal(page.getTotal());
        pageInfo.setPageNum(page.getPageNum());
        pageInfo.setPageSize(page.getPageSize());
        this.pagination = pageInfo;
        
        return this;
    }

    public PageResult() {
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "pagination=" + pagination +
                '}';
    }

    public PageInfo getPagination() {
        return pagination;
    }

    public void setPagination(PageInfo pagination) {
        this.pagination = pagination;
    }

    public static class PageInfo {

        private long total;
        private int pages;
        private int pageNum;
        private int pageSize;

        public PageInfo() {
        }

        public static int getPageNum(Integer pageNum) {
            return pageNum == null ? 1 : pageNum;
        }

        public static int getPageSize(Integer pageSize) {
            return pageSize == null ? 10 : pageSize;
        }

        @Override
        public String toString() {
            return "PageInfo{" +
                    "total=" + total +
                    ", pages=" + pages +
                    ", pageNum=" + pageNum +
                    ", pageSize=" + pageSize +
                    '}';
        }

        public long getTotal() {
            return total;
        }

        public void setTotal(long total) {
            this.total = total;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public int getPageNum() {
            return pageNum;
        }

        public void setPageNum(int pageNum) {
            this.pageNum = pageNum;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }
    }
}
