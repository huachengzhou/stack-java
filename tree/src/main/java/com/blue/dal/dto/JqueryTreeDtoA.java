package com.blue.dal.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @createDate 2018/12/22
 **/
public class JqueryTreeDtoA {
    private Integer id;
    private String text;
    private double num;
    private Set<JqueryTreeDtoA> nodes = new HashSet<JqueryTreeDtoA>(10);
    private Date createTime;

    public String getText() {
        return text;
    }

    public JqueryTreeDtoA setText(String text) {
        this.text = text;
        return this;
    }

    public double getNum() {
        return num;
    }

    public JqueryTreeDtoA setNum(double num) {
        this.num = num;
        return this;
    }

    public Set<JqueryTreeDtoA> getNodes() {
        return nodes;
    }

    public JqueryTreeDtoA setNodes(Set<JqueryTreeDtoA> nodes) {
        this.nodes = nodes;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public JqueryTreeDtoA setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public JqueryTreeDtoA setId(Integer id) {
        this.id = id;
        return this;
    }
}
