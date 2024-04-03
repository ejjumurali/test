package com.visit.exception;

public class VisitRunTimeException extends VisitBaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VisitRunTimeException( ErrorCode errorCode, String... string) {
		super(errorCode, string);
	}

	
}
