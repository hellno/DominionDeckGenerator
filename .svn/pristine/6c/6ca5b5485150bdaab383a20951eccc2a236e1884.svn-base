package de.uniwue.jpp.deckgen.service.csp;

import java.util.HashSet;
import java.util.Set;

public class NoSolutionFoundException extends RuntimeException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String myMessage = "NoSolutionFound, Sir";
	private Set<IConstraint> constraints;
	
	public NoSolutionFoundException(String message, Set<IConstraint> constraints) {
		// TODO Auto-generated constructor stub
		super(message + "|" + myMessage);
		this.constraints=constraints;
	}

	public Set<IConstraint> getConstraints(){
		Set<IConstraint> tempSet = new HashSet<IConstraint>();
		tempSet.addAll(constraints);
		return tempSet;
	}
	
	public NoSolutionFoundException(String message) {
		super(myMessage);
		// TODO Auto-generated constructor stub
	}

	public NoSolutionFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public NoSolutionFoundException(String message, Throwable cause) {
		super(myMessage, cause);
		// TODO Auto-generated constructor stub
	}

	public NoSolutionFoundException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(myMessage, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
