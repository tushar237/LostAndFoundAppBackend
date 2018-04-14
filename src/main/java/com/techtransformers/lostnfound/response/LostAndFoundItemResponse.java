package com.techtransformers.lostnfound.response;

public class LostAndFoundItemResponse {

	private Integer code;
	private String message;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "LostAndFoundItemResponse [code=" + code + ", message=" + message + "]";
	}

}
