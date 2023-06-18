package com.gold.config;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * 描述: 请求参数数据
 *
 * @author Red
 * @version 1.0
 * @date: 2017/07/20 17:57
 */
public class RequestBaseParam {
    private String currentUser;

    /**
     * 默认页码
     */
    public static final int DEFAULT_PAGE_NO = 1;

    /**
     * 默认每页显示个数
     */
    public static final int DEFAULT_PER_PAGE_SIZE = 10;

    /**
     * 页码
     */
    public static final String PARAMETER_PAGE = "offset";

    /**
     * 每页显示个数
     */
    public static final String PARAMETER_PER_PAGE_SIZE = "limit";
    public static final String SEARCH_STR = "search";
    public static final String MENU_ID_STR = "menuId";
    public static final String ORDER_STR = "order";
    public static final String SORT_STR = "sort";

    private String appKey;
    private Integer menuId;
    private Integer limit;
    private Integer offset;
    private String search;
    private String order;
    private String sort;

    /**
     * 排序串,在有order情况下
     */
    private String orderStr;

    private transient HttpServletRequest request;

    private Page<PageInfo> page;

    public String getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Page<PageInfo> getPage() {
        return page;
    }

    public void setPage(Page<PageInfo> page) {
        this.page = page;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public String getOrderStr() {
        return orderStr;
    }

    public void setOrderStr(String orderStr) {
        this.orderStr = orderStr;
    }
}
