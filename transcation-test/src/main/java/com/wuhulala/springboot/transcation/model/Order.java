package com.wuhulala.springboot.transcation.model;

import javax.persistence.*;

@Table(name = "order")
public class Order {
    @Id
    private Long id;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_num")
    private Integer productNum;

    @Column(name = "total_cost")
    private Long totalCost;

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
     * @return customer_id
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    /**
     * @return product_id
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * @param productId
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * @return product_num
     */
    public Integer getProductNum() {
        return productNum;
    }

    /**
     * @param productNum
     */
    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }

    /**
     * @return total_cost
     */
    public Long getTotalCost() {
        return totalCost;
    }

    /**
     * @param totalCost
     */
    public void setTotalCost(Long totalCost) {
        this.totalCost = totalCost;
    }
}