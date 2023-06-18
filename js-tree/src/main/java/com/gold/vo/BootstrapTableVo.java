package com.gold.vo;

import java.io.Serializable;
import java.util.List;

public class BootstrapTableVo<E> implements Serializable {
    private Long total;
    private List<E> rows;

    public BootstrapTableVo() {
    }

    public BootstrapTableVo(Long total, List<E> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return this.total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<E> getRows() {
        return this.rows;
    }

    public void setRows(List<E> rows) {
        this.rows = rows;
    }
}