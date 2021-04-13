package com.tut.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tut.ecommerce.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	/**
	 * METODO QUE PERMITE RETORNAR UNA LISTA DE TODOS LOS USUARIOS
	 */
	List<User> findAll();

	/**
	 * METODO QUE PERMITE RETORNAR UN USUARIO SEGUN SU EMAIL
	 * @param email
	 * @return
	 */
	User findByEmail(String email);

}
