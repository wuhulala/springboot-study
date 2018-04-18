package com.wuhulala.api.base;

/**
 * 功能说明: com.wuhulala.springboot.transcation.base<br>
 * 注意事项: <br>
 * 系统版本: v1.0<br>
 * 开发人员: wuhulala<br>
 * 开发时间: 2018/4/14<br>
 */
public class BaseReq<T> {

    private T query;

    public BaseReq() {
    }

    public BaseReq(T query) {
        this.query = query;
    }

    public T getQuery() {
        return query;
    }

    public void setQuery(T query) {
        this.query = query;
    }
}
