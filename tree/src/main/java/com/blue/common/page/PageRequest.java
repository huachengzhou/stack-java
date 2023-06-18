package com.blue.common.page;

import java.io.Serializable;

/**
 * 分页请求
 */
public class PageRequest implements Serializable {
    /**
     * 当前页码
     */
    private int pageNumber;
    /**
     * 每页数量
     */
    private int pageSize;

    private int limit;

    private int offset;



    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }



    public void setOffset(int offset) {
        this.offset = offset;
    }
}