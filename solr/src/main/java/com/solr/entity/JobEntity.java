
package com.solr.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author : chengdu
 * @date :  2023/7/24-07
 **/
@Data
public class JobEntity {
    private String property;
    private String jobId;
    private String jobType;
    private String jobName;
    private List<String> jobTags;
    private String jobNumString;
    private String workAreaCode;
    private String jobAreaCode;
    private String jobAreaString;
    private String hrefAreaPinYin;
    private JobAreaLevelDetail jobAreaLevelDetail;
    private String provideSalaryString;
    private Date issueDateString;
    private Date confirmDateString;
    private String workYearString;
    private String degreeString;
    private String industryType1Str;
    private String industryType2Str;
    private String funcType1Code;
    private String funcType2Code;
    private String major1Str;
    private String major2Str;
    private String encCoId;
    private String companyName;
    private String fullCompanyName;
    private String companyLogo;
    private String companyTypeString;
    private String companySizeString;
    private String companySizeCode;
    private String hrUid;
    private String hrName;
    private String smallHrLogoUrl;
    private String hrPosition;
    private Date updateDateTime;
    private String lon;
    private String lat;
    private boolean isCommunicate;
    private boolean isFromXyx;
    private boolean isIntern;
    private boolean isModelEmployer;
    private boolean isQuickFeedback;
    private boolean isPromotion;
    private boolean isApply;
    private boolean isExpire;
    private String jobHref;
    private boolean allowChatOnline;
    private long ctmId;
    private String term;
    private String termStr;
    private String landmarkId;
    private String landmarkString;
    private String retrieverName;
    private String exrInfo02;
    private int hrInfoType;
    private String jobScheme;
    private String coId;
}
