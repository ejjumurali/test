package com.patient.exception;

public class PatientRunTimeException extends PatientBaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PatientRunTimeException( ErrorCode errorCode, String... string) {
		super(errorCode, string);
	}

	
}
