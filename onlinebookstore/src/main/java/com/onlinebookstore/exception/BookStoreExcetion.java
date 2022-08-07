package com.onlinebookstore.exception;

public class BookStoreExcetion extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	private String message;
	
	public BookStoreExcetion() {
		
	}

	public BookStoreExcetion(String message) {
		super(message);
		this.message = message;
	}
	
	

}
