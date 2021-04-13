package com.tut.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tut.ecommerce.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, String> {

	/**
	 * METODO QUE PERMITE LA BUSQUEDA POR USUARIO Y FECHA DE CREACION
	 * 
	 * @param userId
	 * @return
	 */
	List<Cart> findAllByUserIdOrderByCreatedDateDesc(Integer userId);

}
