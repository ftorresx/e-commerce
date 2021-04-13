package com.tut.ecommerce.service;

import static com.tut.ecommerce.config.MessageStrings.USER_CREATED;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tut.ecommerce.config.MessageStrings;
import com.tut.ecommerce.dto.ResponseDto;
import com.tut.ecommerce.dto.user.SignInDto;
import com.tut.ecommerce.dto.user.SignInResponseDto;
import com.tut.ecommerce.dto.user.SignupDto;
import com.tut.ecommerce.dto.user.UserCreateDto;
import com.tut.ecommerce.enums.ResponseStatus;
import com.tut.ecommerce.enums.Role;
import com.tut.ecommerce.exceptions.AuthenticationFailException;
import com.tut.ecommerce.exceptions.CustomException;
import com.tut.ecommerce.model.AuthenticationToken;
import com.tut.ecommerce.model.User;
import com.tut.ecommerce.repository.UserRepository;
import com.tut.ecommerce.utils.Helper;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	AuthenticationService authenticationService;

	Logger logger = LoggerFactory.getLogger(UserService.class);

	public ResponseDto signUp(SignupDto signupDto) throws CustomException {
		if (Helper.notNull(userRepository.findByEmail(signupDto.getEmail()))) {
			throw new CustomException("User already exists");
		}
		String encryptedPassword = signupDto.getPassword();
		try {
			encryptedPassword = hashPassword(signupDto.getPassword());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			logger.error("hashing password failed {}", e.getMessage());
		}

		User user = new User(signupDto.getFirstName(), signupDto.getLastName(), signupDto.getEmail(), Role.user,
				encryptedPassword);

		User createdUser;
		try {
			createdUser = userRepository.save(user);
			final AuthenticationToken authenticationToken = new AuthenticationToken(createdUser);
			authenticationService.saveConfirmationToken(authenticationToken);
			return new ResponseDto(ResponseStatus.success.toString(), USER_CREATED);
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
	}

	public SignInResponseDto signIn(SignInDto signInDto) throws CustomException {
		User user = userRepository.findByEmail(signInDto.getEmail());
		if (!Helper.notNull(user)) {
			throw new AuthenticationFailException("user not present");
		}
		try {
			if (!user.getPassword().equals(hashPassword(signInDto.getPassword()))) {
				throw new AuthenticationFailException(MessageStrings.WRONG_PASSWORD);
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			logger.error("hashing password failed {}", e.getMessage());
			throw new CustomException(e.getMessage());
		}

		AuthenticationToken token = authenticationService.getToken(user);

		if (!Helper.notNull(token)) {
			throw new CustomException("token not present");
		}

		return new SignInResponseDto("success", token.getToken());
	}

	String hashPassword(String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		byte[] digest = md.digest();
		String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
		return myHash;
	}

	public ResponseDto createUser(String token, UserCreateDto userCreateDto)
			throws CustomException, AuthenticationFailException {
		User creatingUser = authenticationService.getUser(token);
		if (!canCrudUser(creatingUser.getRole())) {
			throw new AuthenticationFailException(MessageStrings.USER_NOT_PERMITTED);
		}
		String encryptedPassword = userCreateDto.getPassword();
		try {
			encryptedPassword = hashPassword(userCreateDto.getPassword());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			logger.error("hashing password failed {}", e.getMessage());
		}

		User user = new User(userCreateDto.getFirstName(), userCreateDto.getLastName(), userCreateDto.getEmail(),
				userCreateDto.getRole(), encryptedPassword);
		User createdUser;
		try {
			createdUser = userRepository.save(user);
			final AuthenticationToken authenticationToken = new AuthenticationToken(createdUser);
			authenticationService.saveConfirmationToken(authenticationToken);
			return new ResponseDto(ResponseStatus.success.toString(), USER_CREATED);
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}

	}

	boolean canCrudUser(Role role) {
		if (role == Role.admin || role == Role.manager) {
			return true;
		}
		return false;
	}

	boolean canCrudUser(User userUpdating, Integer userIdBeingUpdated) {
		Role role = userUpdating.getRole();
		if (role == Role.admin || role == Role.manager) {
			return true;
		}
		if (role == Role.user && userUpdating.getId() == userIdBeingUpdated) {
			return true;
		}
		return false;
	}
}
