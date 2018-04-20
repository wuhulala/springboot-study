package com.wuhulala.api.model;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * 功能说明: 产品<br>
 * 注意事项: <br>
 * 系统版本: v1.0<br>
 * 开发人员: wuhulala<br>
 * 开发时间: 2018/4/20<br>
 */
public class Product implements Serializable{
    @Id
    private String id;

    private String name;

    private double price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
