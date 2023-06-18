package com.blue.dal.dto;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * @createDate 2018/12/20
 **/
public class EasyTreeDtoB {
    private Integer _parentId;
    private Integer id;
    private java.math.BigDecimal number;

    private String name;

    private java.math.BigDecimal currency;

    private java.math.BigDecimal valuationDateCurrency;

    private String valuationDateDegreeCompletion;

    private boolean checked = true;

    private Set<EasyTreeDtoB> children = new HashSet<EasyTreeDtoB>();

    public BigDecimal getNumber() {
        return number;
    }

    public void setNumber(BigDecimal number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCurrency() {
        return currency;
    }

    public void setCurrency(BigDecimal currency) {
        this.currency = currency;
    }

    public BigDecimal getValuationDateCurrency() {
        return valuationDateCurrency;
    }

    public void setValuationDateCurrency(BigDecimal valuationDateCurrency) {
        this.valuationDateCurrency = valuationDateCurrency;
    }

    public String getValuationDateDegreeCompletion() {
        return valuationDateDegreeCompletion;
    }

    public void setValuationDateDegreeCompletion(String valuationDateDegreeCompletion) {
        this.valuationDateDegreeCompletion = valuationDateDegreeCompletion;
    }

    public Integer get_parentId() {
        return _parentId;
    }

    public void set_parentId(Integer _parentId) {
        this._parentId = _parentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Set<EasyTreeDtoB> getChildren() {
        return children;
    }

    public void setChildren(Set<EasyTreeDtoB> children) {
        this.children = children;
    }
}
