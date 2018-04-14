package com.techtransformers.lostnfound.exceptions;

public class LostAndFoundItemException extends Exception {

	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public LostAndFoundItemException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public LostAndFoundItemException() {
		super();
	}
}
