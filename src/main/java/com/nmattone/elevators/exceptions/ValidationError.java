package com.nmattone.elevators.exceptions;

@SuppressWarnings("serial")
public class ValidationError extends Exception {

	public ValidationError(String message) {
		super(message);
	}

}
