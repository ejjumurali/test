package com.visit.exception;

/**
 * Interface represents Error Codes
 * */
public interface ErrorCode {

	String name();
	String getMessage();
	int getHttpStatusCode();
}
