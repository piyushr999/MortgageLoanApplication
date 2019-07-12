package com.hcl.mortgageloan.exception;

/**
 * @author Administrator
 *
 */
public class InvalidInputException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidInputException(Throwable t, String message) {
		super(message, t);
	}

	public InvalidInputException(String message) {
		super(message);
	}

	public InvalidInputException(Throwable t) {
		super(t);
	}

}
