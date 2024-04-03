package com.patient.exception;

import jakarta.servlet.http.HttpServletResponse;

/**
 * Error codes
 */
public enum PatientErrorCode implements ErrorCode{
	PT_001("Patient already exists",HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

	private final String message;
	private final int httpStatusCode;
	
	private PatientErrorCode(String message, int httpStatusCode) {
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
