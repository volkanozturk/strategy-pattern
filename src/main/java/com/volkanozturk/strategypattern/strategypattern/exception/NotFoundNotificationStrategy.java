package com.volkanozturk.strategypattern.strategypattern.exception;

/**
 * @author volkanozturk
 */
public class NotFoundNotificationStrategy extends RuntimeException{

	public NotFoundNotificationStrategy(String message) {
		super(message);
	}
}
