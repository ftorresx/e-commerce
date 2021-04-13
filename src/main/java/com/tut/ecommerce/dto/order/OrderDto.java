package com.tut.ecommerce.dto.order;

import javax.validation.constraints.NotNull;

import com.tut.ecommerce.model.Order;

/**
 * DTO DE LA ORDEN CREADA POR EL CHECKOUT
 * @author ferdando.torres
 *
 */
public class OrderDto {
    private String id;
    private @NotNull Integer userId;

    public OrderDto() {
    }

    public OrderDto(Order order) {
        this.setId(order.getId());
        this.setUserId(order.getUserId());
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

}
