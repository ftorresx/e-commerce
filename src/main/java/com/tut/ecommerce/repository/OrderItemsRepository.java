package com.tut.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tut.ecommerce.model.OrderItem;

public interface OrderItemsRepository extends JpaRepository<OrderItem,Integer> {
}
