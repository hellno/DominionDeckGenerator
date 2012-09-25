package de.uniwue.jpp.deckgen.io;

public class ExportException extends RuntimeException {

	private static String myMessage = "ExcportException, Sir!";
	private static final long serialVersionUID = 1L;

	public ExportException() {
		super(myMessage);
	}

	public ExportException(String message) {
		super(myMessage);
	}

	public ExportException(Throwable cause) {
		super(cause);
	}

	public ExportException(String message, Throwable cause) {
		super(myMessage, cause);
	}

	public ExportException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(myMessage, cause, enableSuppression, writableStackTrace);
	}

}
