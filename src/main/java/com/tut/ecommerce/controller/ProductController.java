package com.tut.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tut.ecommerce.common.ApiResponse;
import com.tut.ecommerce.dto.product.ProductDto;
import com.tut.ecommerce.model.Category;
import com.tut.ecommerce.service.CategoryService;
import com.tut.ecommerce.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;

	/**
	 * METODO QUE PERMITE LISTAR LOS PRODUCTOS ACTUALES
	 * 
	 * @return
	 */
	@GetMapping("/")
	public ResponseEntity<List<ProductDto>> getProducts() {
		List<ProductDto> body = productService.listProducts();
		return new ResponseEntity<List<ProductDto>>(body, HttpStatus.OK);
	}

	/**
	 * METODO QUE PERMITE ADICIONAR UN PRODUCTO
	 * 
	 * @param productDto
	 * @return
	 */
	@PostMapping("/add")
	public ResponseEntity<ApiResponse> addProduct(@RequestBody ProductDto productDto) {
		Optional<Category> optionalCategory = categoryService.readCategory(productDto.getCategoryId());
		if (!optionalCategory.isPresent()) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category is invalid"), HttpStatus.CONFLICT);
		}
		Category category = optionalCategory.get();
		productService.addProduct(productDto, category);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been added"), HttpStatus.CREATED);
	}

	/**
	 * METODO QUE PERMITE ACTUALIZAR UN PRODUCTO
	 * 
	 * @param productID
	 * @param productDto
	 * @return
	 */
	@PostMapping("/update/{productID}")
	public ResponseEntity<ApiResponse> updateProduct(@PathVariable("productID") String productID,
			@RequestBody @Valid ProductDto productDto) {
		Optional<Category> optionalCategory = categoryService.readCategory(productDto.getCategoryId());
		if (!optionalCategory.isPresent()) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category is invalid"), HttpStatus.CONFLICT);
		}
		Category category = optionalCategory.get();
		productService.updateProduct(productID, productDto, category);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been updated"), HttpStatus.OK);
	}
}
