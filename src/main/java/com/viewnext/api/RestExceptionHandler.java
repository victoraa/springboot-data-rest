package com.viewnext.api;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	// other exception handlers

	@ExceptionHandler(EntityNotFoundException.class)
	protected ResponseEntity<ApiError> handleEntityNotFound(EntityNotFoundException ex) {

		ApiError apiError = new ApiError(ex.getMessage(), "Any detail you want to add.");
		apiError.setMessage(ex.getMessage());
		return new ResponseEntity<ApiError>(apiError, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
}