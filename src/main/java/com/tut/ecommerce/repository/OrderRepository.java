package com.tut.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tut.ecommerce.model.Order;

import java.util.List;

@Repository
public interface OrderRepository  extends JpaRepository<Order, Integer> {
	
	/**
	 * METODO QUE RETORNA TODAS LAS ORDENES DE UN USUARIO
	 * @param userId
	 * @return
	 */
    List<Order> findAllByUserIdOrderByCreatedDateDesc(Integer userId);

}
