package com.tut.ecommerce.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "orderitems")
public class OrderItem {

    @Id
    private String orderItemId;

    @Column(name = "productId")
    private @NotNull String productId;

    @Column(name = "quantity")
    private @NotNull int quantity;

    @Column(name = "price")
    private @NotNull double price;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "created_date")
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "order_id",referencedColumnName = "id",insertable = false,updatable = false)
    private Order order;

    @OneToOne
    @JoinColumn(name = "productId",referencedColumnName = "id",insertable = false,updatable = false)
    private Product product;

    public OrderItem(){}

    public OrderItem(String orderId, @NotNull String product_id, @NotNull int quantity, @NotNull double price) {
    	this.orderItemId = UUID.randomUUID().toString();
        this.productId = product_id;
        this.quantity = quantity;
        this.price = price;
        this.orderId=orderId;
        this.createdDate = new Date();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getOrder_id() {
        return orderItemId;
    }

    public void setOrder_id(String order_id) {
        this.orderItemId = order_id;
    }

    public String getProduct_id() {
        return productId;
    }

    public void setProduct_id(String product_id) {
        this.productId = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }


}
