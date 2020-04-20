package com.eatfit.restaurant.exception;

public class InvalidDataException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidDataException() {
		super();
	}

	public InvalidDataException(String msg) {
		super(msg);
	}

}
