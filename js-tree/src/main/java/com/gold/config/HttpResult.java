package com.gold.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gold.common.utils.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HttpResult {
    private static final long serialVersionUID = 1L;
    private static final Boolean CORRECT_RET;
    private static final Boolean ERR_RET;
    private static final int DEFAULT_ERR_CODE = 0;
    private Boolean ret;
    private Object data;
    private Integer code;
    private String errmsg;

    public HttpResult() {
    }

    public static HttpResult newCorrectResult() {
        HttpResult correctJsonObject = new HttpResult();
        correctJsonObject.setRet(CORRECT_RET);
        return correctJsonObject;
    }

    public static HttpResult newCorrectResult(Object object) {
        HttpResult correctJsonObject = newCorrectResult();
        correctJsonObject.setData(object);
        return correctJsonObject;
    }

    public static HttpResult newCorrectResult(Integer code, Object object) {
        HttpResult correctJsonObject = newCorrectResult();
        correctJsonObject.setCode(code);
        correctJsonObject.setData(object);
        return correctJsonObject;
    }

    public static HttpResult newErrorResult(Integer code, String msg) {
        HttpResult errorReturnObject = new HttpResult();
        errorReturnObject.setRet(ERR_RET);
        errorReturnObject.setCode(code);
        errorReturnObject.setErrmsg(msg);
        return errorReturnObject;
    }

    public static HttpResult newErrorResult(Integer code, Exception ex) {
        HttpResult errorReturnObject = new HttpResult();
        errorReturnObject.setRet(ERR_RET);
        errorReturnObject.setCode(code);
        errorReturnObject.setErrmsg(ex.getMessage());
        if (ex instanceof NullPointerException) {
            errorReturnObject.setErrmsg("存在空指针风险,请检查后台逻辑.");
        }

        return errorReturnObject;
    }

    public static HttpResult newErrorResult(String msg) {
        return newErrorResult(0, msg);
    }

    public static HttpResult newErrorResult(Exception ex) {
        return newErrorResult(0, ex);
    }

    public static String toJson(HttpResult result) {
        return JsonUtils.json(result);
    }

    public HttpResult putEntry(String key, Object value) {
        if (StringUtils.isBlank(key)) {
            return this;
        } else {
            if (this.data == null) {
                this.data = new HashMap();
            }

            boolean isMapStructure = this.data instanceof Map;
            if (!isMapStructure) {
                throw new RuntimeException("Can't put k-v into not-map data");
            } else {
                ((Map)this.data).put(key, value);
                return this;
            }
        }
    }

    public <T> T getData(Class<T> clazz) {
        return clazz != null && this.data != null ? JsonUtils.parse(JsonUtils.json(this.data), clazz) : null;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getErrmsg() {
        return this.errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Boolean getRet() {
        return this.ret;
    }

    public void setRet(Boolean ret) {
        this.ret = ret;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    static {
        CORRECT_RET = Boolean.TRUE;
        ERR_RET = Boolean.FALSE;
    }
}