package de.uniwue.jpp.deckgen.model;

public class NegativeNumberException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String myMessage="Negative Zahl übergeben";
	
	public NegativeNumberException() {
		// TODO Auto-generated constructor stub
	}

	public NegativeNumberException(String message) {
		super(myMessage);
		// TODO Auto-generated constructor stub
	}

	public NegativeNumberException(Throwable cause) {
		super(myMessage);
		// TODO Auto-generated constructor stub
	}

	public NegativeNumberException(String message, Throwable cause) {
		super(myMessage, cause);
		// TODO Auto-generated constructor stub
	}

	public NegativeNumberException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(myMessage, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
