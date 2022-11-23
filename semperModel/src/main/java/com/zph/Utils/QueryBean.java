package com.zph.Utils;

import lombok.Data;

@Data
public class QueryBean {

    private Integer currentPage;
    private Integer pageSize;
    private String queryString;

    public QueryBean(Integer currentPage, Integer pageSize, String queryString) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.queryString = queryString;
    }
}
