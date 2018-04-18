package com.wuhulala.springboot.transcation.base;

/**
 * 功能说明: com.wuhulala.springboot.transcation.base<br>
 * 注意事项: <br>
 * 系统版本: v1.0<br>
 * 开发人员: wuhulala<br>
 * 开发时间: 2018/4/14<br>
 */
public class BaseResp<T> {
    private String code = "200";

    private String message = "success";

    private T item;

    public BaseResp(){

    }

    public BaseResp(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
