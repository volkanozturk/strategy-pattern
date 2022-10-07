package com.volkanozturk.strategypattern.strategypattern.exception;

import com.volkanozturk.strategypattern.strategypattern.dto.shared.CustomRestError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.el.MethodNotFoundException;
import javax.servlet.http.HttpServletRequest;

/**
 * @author volkanozturk
 */
@ControllerAdvice
public class GlobalRestExceptionHandler {

	@ExceptionHandler(value = {NotFoundNotificationStrategy.class})
	public ResponseEntity<CustomRestError> handleNotFoundNotificationStrategy(NotFoundNotificationStrategy ex) {
		return responseEntity(CustomRestError.builder()
				.status(HttpStatus.BAD_REQUEST.value())
				.message(ex.getMessage())
				.build());
	}

	@ExceptionHandler(value = {NoHandlerFoundException.class, MethodNotFoundException.class})
	public ResponseEntity<CustomRestError> processNoHandlerFoundException(final Exception exception, final HttpServletRequest request) {
		return responseEntity(CustomRestError.builder()
				.status(HttpStatus.NOT_FOUND.value())
				.message((HttpStatus.NOT_FOUND.getReasonPhrase()))
				.build());
	}

	private ResponseEntity<CustomRestError> responseEntity(CustomRestError error) {
		return new ResponseEntity(error, HttpStatus.valueOf(error.getStatus()));
	}


}
