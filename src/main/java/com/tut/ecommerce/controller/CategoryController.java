package com.tut.ecommerce.controller;

import java.util.List;

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
import com.tut.ecommerce.model.Category;
import com.tut.ecommerce.service.CategoryService;
import com.tut.ecommerce.utils.Helper;

@RestController
@RequestMapping("/category")

public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	/**
	 * METODO QUE PERMITE LISTAR LAS CATEGORIAS
	 * 
	 * @return
	 */
	@GetMapping("/")
	public ResponseEntity<List<Category>> getCategories() {
		List<Category> body = categoryService.listCategories();
		return new ResponseEntity<List<Category>>(body, HttpStatus.OK);
	}

	/**
	 * METODO QUE PERMITE CREAR UNA CATEGORIA
	 * 
	 * @param category
	 * @return
	 */
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createCategory(@Valid @RequestBody Category category) {
		if (Helper.notNull(categoryService.readCategory(category.getCategoryName()))) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category already exists"),
					HttpStatus.CONFLICT);
		}
		categoryService.createCategory(category);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "created the category"), HttpStatus.CREATED);
	}

	/**
	 * METODO QUE PERMITE ACTUALIZAR UNA CATEGORIA
	 * 
	 * @param categoryID
	 * @param category
	 * @return
	 */
	@PostMapping("/update/{categoryID}")
	public ResponseEntity<ApiResponse> updateCategory(@PathVariable("categoryID") long categoryID,
			@Valid @RequestBody Category category) {
		if (Helper.notNull(categoryService.readCategory(categoryID))) {
			categoryService.updateCategory(categoryID, category);
			return new ResponseEntity<ApiResponse>(new ApiResponse(true, "updated the category"), HttpStatus.OK);
		}
		return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category does not exist"), HttpStatus.NOT_FOUND);
	}
}
