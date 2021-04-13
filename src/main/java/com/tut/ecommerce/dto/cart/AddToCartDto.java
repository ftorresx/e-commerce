package com.tut.ecommerce.dto.cart;

import javax.validation.constraints.NotNull;

import com.tut.ecommerce.model.Cart;

/**
 *DTO PARA ADICIONAR ELEMENTOS AL CARRITO 
 * @author ferdando.torres
 *
 */
public class AddToCartDto {
	private String id;
	private @NotNull Integer userId;
	private @NotNull String productId;
	private @NotNull Integer quantity;

	public AddToCartDto() {
	}

	public AddToCartDto(String id, @NotNull Integer userId, @NotNull String productId, @NotNull Integer quantity) {
		this.id = id;
		this.userId = userId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public AddToCartDto(Cart cart) {
		this.setId(cart.getId());
		this.setProductId(cart.getProductId());
		this.setUserId(cart.getUserId());
		this.setQuantity(cart.getQuantity());
	}

	@Override
	public String toString() {
		return "CartDto{" + "id=" + id + ", userId=" + userId + ", productId=" + productId + ", quantity=" + quantity
				+ ",";
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
