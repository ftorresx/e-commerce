package com.tut.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tut.ecommerce.model.Category;

@Repository
public interface Categoryrepository extends JpaRepository<Category, Long> {
	
	/**
	 * METODO QUE PERMITE BUSQUEDA POR NOMBRE DE CATEGORIA 
	 * @param categoryName
	 * @return
	 */
	Category findByCategoryName(String categoryName);
	
}
