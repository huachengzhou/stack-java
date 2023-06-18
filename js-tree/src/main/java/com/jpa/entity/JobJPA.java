package com.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Lenovo on 2020/8/15.
 */

@Entity
@Table(name = "tb_job_jpa")
public class JobJPA implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 32)
    private String name;
    @Column(length = 64)
    private String url;

    @Lob
    @Column(name = "describe_z", columnDefinition = "TEXT")
    private String describe;

    @Column(name = "create_date")
    private java.util.Date createDate ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "JobJPA{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", describe='" + describe + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
