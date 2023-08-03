package com.my.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author zch
 * @since 2023-08-03
 */
@TableName("tb_school_fraction_info")
public class SchoolFractionInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("uuid")
    private String uuid;

    @TableField("year")
    private String year;

    @TableField("fraction")
    private String fraction;

    @TableField("max_score")
    private String maxScore;

    @TableField("min_score")
    private String minScore;

    @TableField("enrollment")
    private String enrollment;

    @TableField("province")
    private String province;

    @TableField("type")
    private String type;

    @TableField("primary_classification")
    private String primaryClassification;

    @TableField("method")
    private String method;

    @TableField("speciality")
    private String speciality;

    @TableField("source_text")
    private String sourceText;

    @TableField("school")
    private String school;

    @TableField("batch")
    private String batch;

    @TableField("type_enum")
    private String typeEnum;

    @TableField("remark")
    private String remark;

    @TableField("gmt_created")
    private LocalDateTime gmtCreated;

    @TableField("gmt_modified")
    private LocalDateTime gmtModified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getFraction() {
        return fraction;
    }

    public void setFraction(String fraction) {
        this.fraction = fraction;
    }

    public String getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(String maxScore) {
        this.maxScore = maxScore;
    }

    public String getMinScore() {
        return minScore;
    }

    public void setMinScore(String minScore) {
        this.minScore = minScore;
    }

    public String getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrimaryClassification() {
        return primaryClassification;
    }

    public void setPrimaryClassification(String primaryClassification) {
        this.primaryClassification = primaryClassification;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getSourceText() {
        return sourceText;
    }

    public void setSourceText(String sourceText) {
        this.sourceText = sourceText;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getTypeEnum() {
        return typeEnum;
    }

    public void setTypeEnum(String typeEnum) {
        this.typeEnum = typeEnum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public LocalDateTime getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(LocalDateTime gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public LocalDateTime getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }

    public static final String ID = "id";

    public static final String UUID = "uuid";

    public static final String YEAR = "year";

    public static final String FRACTION = "fraction";

    public static final String MAX_SCORE = "max_score";

    public static final String MIN_SCORE = "min_score";

    public static final String ENROLLMENT = "enrollment";

    public static final String PROVINCE = "province";

    public static final String TYPE = "type";

    public static final String PRIMARY_CLASSIFICATION = "primary_classification";

    public static final String METHOD = "method";

    public static final String SPECIALITY = "speciality";

    public static final String SOURCE_TEXT = "source_text";

    public static final String SCHOOL = "school";

    public static final String BATCH = "batch";

    public static final String TYPE_ENUM = "type_enum";

    public static final String REMARK = "remark";

    public static final String GMT_CREATED = "gmt_created";

    public static final String GMT_MODIFIED = "gmt_modified";

    @Override
    public String toString() {
        return "SchoolFractionInfo{" +
            "id = " + id +
            ", uuid = " + uuid +
            ", year = " + year +
            ", fraction = " + fraction +
            ", maxScore = " + maxScore +
            ", minScore = " + minScore +
            ", enrollment = " + enrollment +
            ", province = " + province +
            ", type = " + type +
            ", primaryClassification = " + primaryClassification +
            ", method = " + method +
            ", speciality = " + speciality +
            ", sourceText = " + sourceText +
            ", school = " + school +
            ", batch = " + batch +
            ", typeEnum = " + typeEnum +
            ", remark = " + remark +
            ", gmtCreated = " + gmtCreated +
            ", gmtModified = " + gmtModified +
        "}";
    }
}
