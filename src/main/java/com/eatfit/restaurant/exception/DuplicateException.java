package com.eatfit.restaurant.exception;

public class DuplicateException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DuplicateException() {
		super();
	}

	public DuplicateException(String msg) {
		super(msg);
	}
}
