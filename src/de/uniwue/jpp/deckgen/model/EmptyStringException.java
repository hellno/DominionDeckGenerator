package de.uniwue.jpp.deckgen.model;

public class EmptyStringException extends java.lang.RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String meineMessage="EmptyStringException, Sir!";
	
	public EmptyStringException() {
		super(meineMessage);

	}

	public EmptyStringException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(meineMessage, cause, enableSuppression, writableStackTrace);
	
	}

	public EmptyStringException(String message, Throwable cause) {
		super(meineMessage, cause);
		
	}

	public EmptyStringException(String message) {
		super(meineMessage);
		
	}

	public EmptyStringException(Throwable cause) {
		super(cause);
	
	}

	
	
}
