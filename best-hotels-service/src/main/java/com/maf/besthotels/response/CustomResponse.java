package com.maf.besthotels.response;

import lombok.Data;


@Data
public class CustomResponse {

	private final boolean success = true;

	private final Object code;

	private String message;

	private Object data;

	public CustomResponse(Object code, String message, Object data) {
		this.message = message;
		this.code = code.toString();
		this.data = data;
	}

	public CustomResponse(Object code, String message) {
		this.message = message;
		this.code = code.toString();
	}
}
