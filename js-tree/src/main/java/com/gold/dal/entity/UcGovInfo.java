package com.gold.dal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 信息公开
 * </p>
 *
 * @author zch
 * @since 2020-06-27
 */
@TableName("tb_uc_gov_info")
public class UcGovInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 文号
     */
    @TableField("word_number_name")
    private String wordNumberName;

    /**
     * 来源
     */
    @TableField("info_source")
    private String infoSource;

    /**
     * 录入时间
     */
    @TableField("entry_date")
    private Date entryDate;

    /**
     * 信息公开时间
     */
    @TableField("info_date")
    private Date infoDate;

    @TableField("user_name")
    private String userName;

    /**
     * 单位
     */
    @TableField("unit")
    private String unit;

    /**
     * 正文
     */
    @TableField("content")
    private String content;

    /**
     * 公开信息标题
     */
    @TableField("title")
    private String title;

    /**
     * 注册时间
     */
    @TableField("CREATE_DATE")
    private Date createDate;

    /**
     * 修改日期
     */
    @TableField("UPDATE_DATE")
    private Date updateDate;

    /**
     * 用作乐观锁
     */
    @TableField("version")
    private Integer version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getWordNumberName() {
        return wordNumberName;
    }

    public void setWordNumberName(String wordNumberName) {
        this.wordNumberName = wordNumberName;
    }
    public String getInfoSource() {
        return infoSource;
    }

    public void setInfoSource(String infoSource) {
        this.infoSource = infoSource;
    }
    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }
    public Date getInfoDate() {
        return infoDate;
    }

    public void setInfoDate(Date infoDate) {
        this.infoDate = infoDate;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public static final String ID = "ID";

    public static final String WORD_NUMBER_NAME = "word_number_name";

    public static final String INFO_SOURCE = "info_source";

    public static final String ENTRY_DATE = "entry_date";

    public static final String INFO_DATE = "info_date";

    public static final String USER_NAME = "user_name";

    public static final String UNIT = "unit";

    public static final String CONTENT = "content";

    public static final String TITLE = "title";

    public static final String CREATE_DATE = "CREATE_DATE";

    public static final String UPDATE_DATE = "UPDATE_DATE";

    public static final String VERSION = "version";

    @Override
    public String toString() {
        return "UcGovInfo{" +
            "id=" + id +
            ", wordNumberName=" + wordNumberName +
            ", infoSource=" + infoSource +
            ", entryDate=" + entryDate +
            ", infoDate=" + infoDate +
            ", userName=" + userName +
            ", unit=" + unit +
            ", content=" + content +
            ", title=" + title +
            ", createDate=" + createDate +
            ", updateDate=" + updateDate +
            ", version=" + version +
        "}";
    }
}
