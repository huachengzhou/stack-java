package com.jpa.entity;


import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="tb_goods_store")
public class GoodsStore implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_code",nullable=false,length=22)
    private String code;

    @Column(name="store",length = 15)
    private int store;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getStore() {
        return store;
    }

    public void setStore(int store) {
        this.store = store;
    }
}
