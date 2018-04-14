package com.techtransformers.lostnfound.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.techtransformers.lostnfound.response.LostAndFoundItemResponse;

@ControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<LostAndFoundItemResponse> exceptionHandler(Exception ex) {
		LostAndFoundItemResponse error = new LostAndFoundItemResponse();
		error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage("Please contact your administrator");
		return new ResponseEntity<LostAndFoundItemResponse>(error, HttpStatus.OK);
	}
}
