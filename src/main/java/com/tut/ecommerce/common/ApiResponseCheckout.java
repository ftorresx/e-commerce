package com.tut.ecommerce.common;

import java.time.LocalDateTime;

public class ApiResponseCheckout {
	private final boolean success;
	private final String message;
	private final Double total;

	public ApiResponseCheckout(boolean success, String message, Double total) {
		this.success = success;
		this.message = message;
		this.total = total;
	}

	public Double getTotal() {
		return total;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public String getTimestamp() {
		return LocalDateTime.now().toString();
	}
}
