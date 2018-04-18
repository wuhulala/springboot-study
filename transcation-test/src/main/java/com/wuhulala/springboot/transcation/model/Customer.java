package com.wuhulala.springboot.transcation.model;

import javax.persistence.*;

@Table(name = "customer")
public class Customer {
    @Id
    private Long id;

    /**
     * �˿�����
     */
    private String name;

    /**
     * ���
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
     * ��ȡ�˿�����
     *
     * @return name - �˿�����
     */
    public String getName() {
        return name;
    }

    /**
     * ���ù˿�����
     *
     * @param name �˿�����
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ��ȡ���
     *
     * @return balance - ���
     */
    public Long getBalance() {
        return balance;
    }

    /**
     * �������
     *
     * @param balance ���
     */
    public void setBalance(Long balance) {
        this.balance = balance;
    }
}