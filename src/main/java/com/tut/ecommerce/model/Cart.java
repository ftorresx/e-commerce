package com.tut.ecommerce.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.tut.ecommerce.dto.cart.AddToCartDto;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="cart")
public class Cart {

	@Id
	private String id;

    @Column(name = "user_id")
    private @NotBlank Integer userId;

    @Column(name = "product_id")
    private @NotBlank String productId;

    @Column(name = "created_date")
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Product product;


    private int quantity;

    public Cart() {
    }

    public Cart(AddToCartDto addToCartDto,int userId){
    	this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.productId = addToCartDto.getProductId();
        this.quantity = addToCartDto.getQuantity();
        this.createdDate = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
