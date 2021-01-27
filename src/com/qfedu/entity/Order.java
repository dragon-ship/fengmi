package com.qfedu.entity;

import java.util.Date;

public class Order {
    private int id;
    private String orderCode;
    private String totalPrice;
    private Date createDate;
    private String username;
    private String order_status;

    public Order() {
    }

    public Order(int id, String orderCode, String totalPrice, Date createDate, String username, String order_status) {
        this.id = id;
        this.orderCode = orderCode;
        this.totalPrice = totalPrice;
        this.createDate = createDate;
        this.username = username;
        this.order_status = order_status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderCode='" + orderCode + '\'' +
                ", totalPrice='" + totalPrice + '\'' +
                ", createDate=" + createDate +
                ", username='" + username + '\'' +
                ", order_status='" + order_status + '\'' +
                '}';
    }
}
