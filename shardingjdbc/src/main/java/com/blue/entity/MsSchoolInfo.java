package com.blue.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * <p>
 * 学校信息
 * </p>
 *
 * @author zch
 * @since 2023-08-11
 */
@TableName("tb_ms_school_info")
public class MsSchoolInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Long id;

    /**
     * *实体唯一uuid
     */
    @TableField("uuid")
    private String uuid;

    /**
     * *标题
     */
    @TableField("title")
    private String title;

    /**
     * *名称
     */
    @TableField("name")
    private String name;

    /**
     * 立校时间*
     */
    @TableField("base_date")
    private Date baseDate;

    /**
     * 人数
     */
    @TableField("number")
    private Integer number;

    /**
     * *地址
     */
    @TableField("address")
    private String address;

    /**
     * 创建人
     */
    @TableField("creator")
    private String creator;

    /**
     * 创建时间
     */
    @TableField("gmt_created")
    private Timestamp gmtCreated;

    /**
     * 最后更新时间，记录变化后会自动更新时间戳
     */
    @TableField("gmt_modified")
    private Timestamp gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBaseDate() {
        return baseDate;
    }

    public void setBaseDate(Date baseDate) {
        this.baseDate = baseDate;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Timestamp getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Timestamp gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Timestamp getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Timestamp gmtModified) {
        this.gmtModified = gmtModified;
    }

    public static final String ID = "id";

    public static final String UUID = "uuid";

    public static final String TITLE = "title";

    public static final String NAME = "name";

    public static final String BASE_DATE = "base_date";

    public static final String NUMBER = "number";

    public static final String ADDRESS = "address";

    public static final String CREATOR = "creator";

    public static final String GMT_CREATED = "gmt_created";

    public static final String GMT_MODIFIED = "gmt_modified";

    @Override
    public String toString() {
        return "MsSchoolInfo{" +
            "id = " + id +
            ", uuid = " + uuid +
            ", title = " + title +
            ", name = " + name +
            ", baseDate = " + baseDate +
            ", number = " + number +
            ", address = " + address +
            ", creator = " + creator +
            ", gmtCreated = " + gmtCreated +
            ", gmtModified = " + gmtModified +
        "}";
    }
}
