package com.blue.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: zch
 * @Date: 2018/7/30 21:27
 * @Description:
 */
public class Message implements Serializable {
    private String id;
    private String title;
    private String content;
    private String describe;
    private Date create;
    private Integer gender;

    public String getId() {
        return id;
    }

    public Message setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Message setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Message setContent(String content) {
        this.content = content;
        return this;
    }

    public String getDescribe() {
        return describe;
    }

    public Message setDescribe(String describe) {
        this.describe = describe;
        return this;
    }

    public Date getCreate() {
        return create;
    }

    public Message setCreate(Date create) {
        this.create = create;
        return this;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", describe='" + describe + '\'' +
                ", create=" + create +
                ", gender=" + gender +
                '}';
    }

    public Integer getGender() {
        return gender;
    }

    public Message setGender(Integer gender) {
        this.gender = gender;
        return this;
    }
}
