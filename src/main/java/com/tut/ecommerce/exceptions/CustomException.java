package com.tut.ecommerce.exceptions;

/**
 * MENSAJE DE EXEPCION
 * 
 * @author ferdando.torres
 *
 */
public class CustomException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	public CustomException(String msg) {
		super(msg);
	}
}
