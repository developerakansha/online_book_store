package com.onlinebookstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerClass {

	@ExceptionHandler(value = BookStoreExcetion.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorResponse handleBookAlreadyExistsException(BookStoreExcetion ex) {
		return new ErrorResponse(HttpStatus.NOT_FOUND.value() , ex.getMessage());
	}
}
