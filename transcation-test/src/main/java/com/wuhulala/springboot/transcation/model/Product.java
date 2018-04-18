package com.wuhulala.springboot.transcation.model;

import javax.persistence.*;

@Table(name = "product")
public class Product {
    @Id
    private Long id;

    private String name;

    /**
     * ��
     */
    private Long price;

    private String description;

    private Integer remain;

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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ��ȡ��
     *
     * @return price - ��
     */
    public Long getPrice() {
        return price;
    }

    /**
     * ���÷�
     *
     * @param price ��
     */
    public void setPrice(Long price) {
        this.price = price;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return remain
     */
    public Integer getRemain() {
        return remain;
    }

    /**
     * @param remain
     */
    public void setRemain(Integer remain) {
        this.remain = remain;
    }
}