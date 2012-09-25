package de.uniwue.jpp.deckgen.io;

public class ImportException extends RuntimeException {

	private static String myMessage = "ImportException, Sir!";
	private static final long serialVersionUID = 1L;

	public ImportException() {
		super(myMessage);
	}

	public ImportException(String message) {
		super(myMessage);
		// TODO Auto-generated constructor stub
	}

	public ImportException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public ImportException(String message, Throwable cause) {
		super(myMessage, cause);
		// TODO Auto-generated constructor stub
	}

	public ImportException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(myMessage, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
