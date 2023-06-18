package com.blue.common;


import java.io.Serializable;

public class BootstrapTableVo<E> implements Serializable {
    public final int PAGE_MAX = 10;
    private Long total;
    private int pageSize;
    private long pageTotal;
    private E rows;

    public BootstrapTableVo() {
    }

    public BootstrapTableVo(Long total, E rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        if (this.getPageTotal() <= 10L) {
            return 1L;
        } else {
            long temp = this.pageTotal / 10L;
            return this.pageTotal % 10L == 0L ? temp : temp + 1L;
        }
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public E getRows() {
        return this.rows;
    }

    public void setRows(E rows) {
        this.rows = rows;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getPageTotal() {
        return this.pageTotal;
    }

    public void setPageTotal(long pageTotal) {
        this.pageTotal = pageTotal;
    }
}
