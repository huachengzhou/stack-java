package com.gold.dal.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author zch
 * @since 2020-06-27
 */
@TableName("tb_uc_user")
public class UcUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    @TableField("USER_NAME")
    private String userName;

    /**
     * 密码
     */
    @TableField("USER_PWD")
    private String userPwd;

    /**
     * 生日
     */
    @TableField("BIRTHDAY")
    private Date birthday;

    /**
     * 姓名
     */
    @TableField("NAME")
    private String name;

    /**
     * 头像图片
     */
    @TableField("USER_ICON")
    private String userIcon;

    /**
     * 性别, 1:男，2:女，3：保密
     */
    @TableField("SEX")
    private String sex;

    /**
     * 昵称
     */
    @TableField("NICKNAME")
    private String nickname;

    /**
     * 用户状态，01:正常，02:冻结
     */
    @TableField("STAT")
    private String stat;

    /**
     * 当前所属MALL
     */
    @TableField("USER_MALL")
    private Long userMall;

    /**
     * 最后登录时间
     */
    @TableField("LAST_LOGIN_DATE")
    private Date lastLoginDate;

    /**
     * 最后登录IP
     */
    @TableField("LAST_LOGIN_IP")
    private String lastLoginIp;

    /**
     * 来源的联合登录
     */
    @TableField("SRC_OPEN_USER_ID")
    private Long srcOpenUserId;

    /**
     * 邮箱
     */
    @TableField("EMAIL")
    private String email;

    /**
     * 手机
     */
    @TableField("MOBILE")
    private String mobile;

    /**
     * 是否删除
     */
    @TableField("IS_DEL")
    private String isDel;

    /**
     * 是否绑定邮箱
     */
    @TableField("IS_EMAIL_CONFIRMED")
    private String isEmailConfirmed;

    /**
     * 是否绑定手机
     */
    @TableField("IS_PHONE_CONFIRMED")
    private String isPhoneConfirmed;

    /**
     * 创建人
     */
    @TableField("CREATER")
    private Long creater;

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
     * 密码强度
     */
    @TableField("PWD_INTENSITY")
    private String pwdIntensity;

    /**
     * 手机登录标识
     */
    @TableField("MOBILE_TGC")
    private String mobileTgc;

    /**
     * mac地址
     */
    @TableField("MAC")
    private String mac;

    /**
     * 1:WEB,2:IOS,3:ANDROID,4:WIFI,5:管理系统, 0:未知
     */
    @TableField("SOURCE")
    private String source;

    /**
     * 激活，1：激活，0：未激活
     */
    @TableField("ACTIVATE")
    private String activate;

    /**
     * 激活类型，0：自动，1：手动
     */
    @TableField("ACTIVATE_TYPE")
    private String activateType;

    /**
     * 用作乐观锁
     */
    @Version
    private Integer version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
    public Long getUserMall() {
        return userMall;
    }

    public void setUserMall(Long userMall) {
        this.userMall = userMall;
    }
    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }
    public Long getSrcOpenUserId() {
        return srcOpenUserId;
    }

    public void setSrcOpenUserId(Long srcOpenUserId) {
        this.srcOpenUserId = srcOpenUserId;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }
    public String getIsEmailConfirmed() {
        return isEmailConfirmed;
    }

    public void setIsEmailConfirmed(String isEmailConfirmed) {
        this.isEmailConfirmed = isEmailConfirmed;
    }
    public String getIsPhoneConfirmed() {
        return isPhoneConfirmed;
    }

    public void setIsPhoneConfirmed(String isPhoneConfirmed) {
        this.isPhoneConfirmed = isPhoneConfirmed;
    }
    public Long getCreater() {
        return creater;
    }

    public void setCreater(Long creater) {
        this.creater = creater;
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
    public String getPwdIntensity() {
        return pwdIntensity;
    }

    public void setPwdIntensity(String pwdIntensity) {
        this.pwdIntensity = pwdIntensity;
    }
    public String getMobileTgc() {
        return mobileTgc;
    }

    public void setMobileTgc(String mobileTgc) {
        this.mobileTgc = mobileTgc;
    }
    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
    public String getActivate() {
        return activate;
    }

    public void setActivate(String activate) {
        this.activate = activate;
    }
    public String getActivateType() {
        return activateType;
    }

    public void setActivateType(String activateType) {
        this.activateType = activateType;
    }
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public static final String ID = "ID";

    public static final String USER_NAME = "USER_NAME";

    public static final String USER_PWD = "USER_PWD";

    public static final String BIRTHDAY = "BIRTHDAY";

    public static final String NAME = "NAME";

    public static final String USER_ICON = "USER_ICON";

    public static final String SEX = "SEX";

    public static final String NICKNAME = "NICKNAME";

    public static final String STAT = "STAT";

    public static final String USER_MALL = "USER_MALL";

    public static final String LAST_LOGIN_DATE = "LAST_LOGIN_DATE";

    public static final String LAST_LOGIN_IP = "LAST_LOGIN_IP";

    public static final String SRC_OPEN_USER_ID = "SRC_OPEN_USER_ID";

    public static final String EMAIL = "EMAIL";

    public static final String MOBILE = "MOBILE";

    public static final String IS_DEL = "IS_DEL";

    public static final String IS_EMAIL_CONFIRMED = "IS_EMAIL_CONFIRMED";

    public static final String IS_PHONE_CONFIRMED = "IS_PHONE_CONFIRMED";

    public static final String CREATER = "CREATER";

    public static final String CREATE_DATE = "CREATE_DATE";

    public static final String UPDATE_DATE = "UPDATE_DATE";

    public static final String PWD_INTENSITY = "PWD_INTENSITY";

    public static final String MOBILE_TGC = "MOBILE_TGC";

    public static final String MAC = "MAC";

    public static final String SOURCE = "SOURCE";

    public static final String ACTIVATE = "ACTIVATE";

    public static final String ACTIVATE_TYPE = "ACTIVATE_TYPE";

    public static final String VERSION = "version";

    @Override
    public String toString() {
        return "UcUser{" +
            "id=" + id +
            ", userName=" + userName +
            ", userPwd=" + userPwd +
            ", birthday=" + birthday +
            ", name=" + name +
            ", userIcon=" + userIcon +
            ", sex=" + sex +
            ", nickname=" + nickname +
            ", stat=" + stat +
            ", userMall=" + userMall +
            ", lastLoginDate=" + lastLoginDate +
            ", lastLoginIp=" + lastLoginIp +
            ", srcOpenUserId=" + srcOpenUserId +
            ", email=" + email +
            ", mobile=" + mobile +
            ", isDel=" + isDel +
            ", isEmailConfirmed=" + isEmailConfirmed +
            ", isPhoneConfirmed=" + isPhoneConfirmed +
            ", creater=" + creater +
            ", createDate=" + createDate +
            ", updateDate=" + updateDate +
            ", pwdIntensity=" + pwdIntensity +
            ", mobileTgc=" + mobileTgc +
            ", mac=" + mac +
            ", source=" + source +
            ", activate=" + activate +
            ", activateType=" + activateType +
            ", version=" + version +
        "}";
    }
}
