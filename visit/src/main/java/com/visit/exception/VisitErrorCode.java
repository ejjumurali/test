package com.visit.exception;

import jakarta.servlet.http.HttpServletResponse;

/**
 * Error codes
 */
public enum VisitErrorCode implements ErrorCode{
	VT_001("Visit already exists",HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

	private final String message;
	private final int httpStatusCode;
	
	private VisitErrorCode(String message, int httpStatusCode) {
		this.message = message;
		this.httpStatusCode = httpStatusCode;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public int getHttpStatusCode() {
		return httpStatusCode;
	}

}
