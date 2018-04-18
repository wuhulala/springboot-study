package com.wuhulala.springboot.transcation.model;

import javax.persistence.*;

@Table(name = "customer")
public class Customer {
    @Id
    private Long id;

    /**
     * 顾客名称
     */
    private String name;

    /**
     * 余额
     */
    private Long balance;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取顾客名称
     *
     * @return name - 顾客名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置顾客名称
     *
     * @param name 顾客名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取余额
     *
     * @return balance - 余额
     */
    public Long getBalance() {
        return balance;
    }

    /**
     * 设置余额
     *
     * @param balance 余额
     */
    public void setBalance(Long balance) {
        this.balance = balance;
    }
}