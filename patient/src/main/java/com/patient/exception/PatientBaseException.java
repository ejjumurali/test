package com.patient.exception;

import java.text.MessageFormat;

/**
 * Custom Exception class for patient
 */
public class PatientBaseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final ErrorCode errorCode;
	private final String[] messageParams;

	public PatientBaseException(ErrorCode errorCode, String[] messageParams) {
		super(getMessage(errorCode, messageParams));
		this.errorCode = errorCode;
		this.messageParams = messageParams;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public String[] getMessageParams() {
		return messageParams;
	}

	private static String getMessage(ErrorCode errorCode, String[] messageParams) {
		if (errorCode.getMessage() != null) {
			return new MessageFormat(errorCode.getMessage()).format(messageParams);
		} else {
			return null;
		}
	}
}
