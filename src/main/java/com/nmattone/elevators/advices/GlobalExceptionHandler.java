package com.nmattone.elevators.advices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nmattone.elevators.exceptions.ElevatorNotFound;
import com.nmattone.elevators.exceptions.ValidationError;

@RestControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(ElevatorNotFound.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String elevatorNotFoundHandler(ElevatorNotFound error) {
		return "El ascensor con ID "+error.getElevatorId()+" no fue encontrado.";
	}
	
	@ExceptionHandler(ValidationError.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String elevatorNotFoundHandler(ValidationError error) {
		return error.getMessage();
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public void defaultErrorHandler(Exception error) {
		log.error("Error no esperado", error);
	}
	
}
