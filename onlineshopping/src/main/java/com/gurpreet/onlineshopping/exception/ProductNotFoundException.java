package com.gurpreet.onlineshopping.exception;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ProductNotFoundException extends Exception implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public ProductNotFoundException() {
		this("Product is not available");
	}

	public ProductNotFoundException(String message) {

		this.message = System.currentTimeMillis() + " : " + message;
	}

	public String getmessage() {

		return message;
	}

}
