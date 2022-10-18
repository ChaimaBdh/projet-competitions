package main.exceptions;

/** A class representing an exception when the player does not exist */
public class UnknownPlayerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** */
	public UnknownPlayerException() {
		super();
	}
	
	/** An exception is defined by its message thrown
	 * @param msg the message thrown
	 */
	public UnknownPlayerException(String msg) {
		super(msg);
	}
	
}