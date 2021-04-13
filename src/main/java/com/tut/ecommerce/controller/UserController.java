package com.tut.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tut.ecommerce.dto.ResponseDto;
import com.tut.ecommerce.dto.user.SignInDto;
import com.tut.ecommerce.dto.user.SignInResponseDto;
import com.tut.ecommerce.dto.user.SignupDto;
import com.tut.ecommerce.exceptions.AuthenticationFailException;
import com.tut.ecommerce.exceptions.CustomException;
import com.tut.ecommerce.model.User;
import com.tut.ecommerce.repository.UserRepository;
import com.tut.ecommerce.service.AuthenticationService;
import com.tut.ecommerce.service.UserService;

@RequestMapping("user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	AuthenticationService authenticationService;

	@Autowired
	UserService userService;

	/**
	 * METODO QUE PERMITE RETORNAR TODOS LOS USUARIOS
	 * 
	 * @param token
	 * @return
	 * @throws AuthenticationFailException
	 */
	@GetMapping("/all")
	public List<User> findAllUser(@RequestParam("token") String token) throws AuthenticationFailException {
		authenticationService.authenticate(token);
		return userRepository.findAll();
	}

	/**
	 * METODO QUE PERMITE REALIZAR UN SIGNUP AL USUARIO
	 * 
	 * @param signupDto
	 * @return
	 * @throws CustomException
	 */
	@PostMapping("/signup")
	public ResponseDto SignUp(@RequestBody SignupDto signupDto) throws CustomException {
		return userService.signUp(signupDto);
	}

	/**
	 * METODO QUE PERMITE REALIZAR UN SIGNUP AL USUARIO
	 * 
	 * @param signInDto
	 * @return
	 * @throws CustomException
	 */
	@PostMapping("/signIn")
	public SignInResponseDto SignIp(@RequestBody SignInDto signInDto) throws CustomException {
		return userService.signIn(signInDto);
	}

}
