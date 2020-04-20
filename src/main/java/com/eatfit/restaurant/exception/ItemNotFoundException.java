package com.eatfit.restaurant.exception;

public class ItemNotFoundException extends RuntimeException {


	private static final long serialVersionUID = 1L;

	public ItemNotFoundException() {
		super();
	}

	public ItemNotFoundException(String msg) {
		super(msg);
	}
	
}
