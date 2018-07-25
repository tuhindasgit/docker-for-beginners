package com.cloud.banking.system.exception;
/**
 * exception class for bank exception
 * @author tuhindas
 *
 */
public class BankException extends Exception {

	private static final long serialVersionUID = 6486886526335652652L;

	private String message;
	/**
	 * Constructor that sends message
	 */
	public BankException(final String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return  "message= " + message;
	}
}
