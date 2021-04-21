package com.entelgy.reto.errors.exceptions;

import com.entelgy.reto.errors.ErrorResponse;

public class EntelgyRetoException extends RuntimeException {

	private static final long serialVersionUID = -2553276714304450672L;

	private final ErrorResponse errorResponse;

	public ErrorResponse getErrorResponse() {
		return errorResponse;
	}

	public EntelgyRetoException(String codigo, String mensajeCustom) {
		this.errorResponse = new ErrorResponse(codigo, mensajeCustom);
	}

}
