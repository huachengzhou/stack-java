package com.blue.dal.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @createDate 2018/12/15
 **/
public class EasyTreeDtoA {
    private Integer itemid;
    private Integer productid ;
    private List<BigDecimal>  listprice = new ArrayList<BigDecimal>(10);

    private List<String> unitcost = new ArrayList<String>(10);

    private String attribute;

    private String status;

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public List<BigDecimal> getListprice() {
        return listprice;
    }

    public void setListprice(List<BigDecimal> listprice) {
        this.listprice = listprice;
    }

    public List<String> getUnitcost() {
        return unitcost;
    }

    public void setUnitcost(List<String> unitcost) {
        this.unitcost = unitcost;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
