package com.tut.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tut.ecommerce.dto.product.ProductDto;

import java.util.UUID;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "products")
public class Product {

	@Id
	private String id;

	private @NotNull String name;
	private @NotNull double price;
	private @NotNull String sku;
	private @NotNull String description;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "category_id", nullable = false)
	Category category;

	public Product(ProductDto productDto, Category category) {
		this.id = UUID.randomUUID().toString();
		this.name = productDto.getName();
		this.description = productDto.getDescription();
		this.price = productDto.getPrice();
		this.sku = productDto.getSku();
		this.category = category;
	}

	public Product(String name, String imageURL, double price, String description, Category category) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.category = category;
	}

	public Product() {
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", sku=" + sku + ", description="
				+ description + ", category=" + category + "]";
	}

}
