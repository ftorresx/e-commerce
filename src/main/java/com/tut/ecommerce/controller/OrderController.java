package com.tut.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tut.ecommerce.common.ApiResponseCheckout;
import com.tut.ecommerce.exceptions.AuthenticationFailException;
import com.tut.ecommerce.model.Order;
import com.tut.ecommerce.service.AuthenticationService;
import com.tut.ecommerce.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderService;

	@Autowired
	private AuthenticationService authenticationService;

	/**
	 * METODO QUE PERMITE LISTAR LAS ORDENES ACTUALES CON ESTADO ACTIVO
	 * 
	 * @param token
	 * @return List<Order>
	 * @throws AuthenticationFailException
	 */
	@GetMapping("/")
	public ResponseEntity<List<Order>> getAllOrders(@RequestParam("token") String token)
			throws AuthenticationFailException {
		authenticationService.authenticate(token);
		int userId = authenticationService.getUser(token).getId();
		List<Order> orderDtoList = orderService.listOrders(userId);
		return new ResponseEntity<List<Order>>(orderDtoList, HttpStatus.OK);
	}

	/**
	 * METODO QUE REALIZA EL CHECKOUT DEL CARRITO DE COMPRAS
	 * 
	 * @param token
	 * @return ApiResponseCheckout
	 * @throws AuthenticationFailException
	 */
	@PostMapping("/checkout")
	public ResponseEntity<ApiResponseCheckout> checkoutList(@RequestParam("token") String token)
			throws AuthenticationFailException {
		authenticationService.authenticate(token);
		int userId = authenticationService.getUser(token).getId();
		Double totalCheckout = orderService.generateCheckoutByUser(userId);
		return new ResponseEntity<ApiResponseCheckout>(
				new ApiResponseCheckout(true, "Checkout has been created", totalCheckout), HttpStatus.CREATED);
	}

}
