package com.tut.ecommerce.dto.product;

import javax.validation.constraints.NotNull;

import com.tut.ecommerce.model.Product;

/**
 * DTO PRODUCTO PARA CARRITO DE COMPRAS Y CHECKOUT
 * 
 * @author ferdando.torres
 *
 */
public class ProductDto {

	private String id;
	private @NotNull String name;
	private @NotNull double price;
	private @NotNull String description;
	private @NotNull String sku;
	private @NotNull Long categoryId;

	public ProductDto(Product product) {
		this.setId(product.getId());
		this.setName(product.getName());
		this.setDescription(product.getDescription());
		this.setPrice(product.getPrice());
		this.setSku(product.getSku());
		this.setCategoryId(product.getCategory().getId());
	}

	public ProductDto(@NotNull String name, @NotNull double price, @NotNull String description,
			@NotNull Long categoryId) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.categoryId = categoryId;
	}

	public ProductDto() {
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}
}
