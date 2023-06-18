package com.blue.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BootstrapTreeNode implements Serializable {

    private Integer id;
    private String pid;

    private String parentName;

    private String name;

    private String htmlText;

    private String json;

    private String content;

    private String remark;

    private Date exampleDate;
    private String url;
    private String ipAdress;
    private String ipType;

    private Date lastUpdateTime;
    private String text;
    private List<BootstrapTreeNode> nodes = new ArrayList<>(10) ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHtmlText() {
        return htmlText;
    }

    public void setHtmlText(String htmlText) {
        this.htmlText = htmlText;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getExampleDate() {
        return exampleDate;
    }

    public void setExampleDate(Date exampleDate) {
        this.exampleDate = exampleDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIpAdress() {
        return ipAdress;
    }

    public void setIpAdress(String ipAdress) {
        this.ipAdress = ipAdress;
    }

    public String getIpType() {
        return ipType;
    }

    public void setIpType(String ipType) {
        this.ipType = ipType;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getText() {
        return getName();
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<BootstrapTreeNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<BootstrapTreeNode> nodes) {
        this.nodes = nodes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BootstrapTreeNode that = (BootstrapTreeNode) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (pid != null ? !pid.equals(that.pid) : that.pid != null) return false;
        if (parentName != null ? !parentName.equals(that.parentName) : that.parentName != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (htmlText != null ? !htmlText.equals(that.htmlText) : that.htmlText != null) return false;
        if (json != null ? !json.equals(that.json) : that.json != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (exampleDate != null ? !exampleDate.equals(that.exampleDate) : that.exampleDate != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (ipAdress != null ? !ipAdress.equals(that.ipAdress) : that.ipAdress != null) return false;
        if (ipType != null ? !ipType.equals(that.ipType) : that.ipType != null) return false;
        return lastUpdateTime != null ? lastUpdateTime.equals(that.lastUpdateTime) : that.lastUpdateTime == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (pid != null ? pid.hashCode() : 0);
        result = 31 * result + (parentName != null ? parentName.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (htmlText != null ? htmlText.hashCode() : 0);
        result = 31 * result + (json != null ? json.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (exampleDate != null ? exampleDate.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (ipAdress != null ? ipAdress.hashCode() : 0);
        result = 31 * result + (ipType != null ? ipType.hashCode() : 0);
        result = 31 * result + (lastUpdateTime != null ? lastUpdateTime.hashCode() : 0);
        return result;
    }
}
