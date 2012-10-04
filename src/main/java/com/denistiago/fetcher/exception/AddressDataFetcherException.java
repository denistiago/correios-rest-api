package com.denistiago.fetcher.exception;

public class AddressDataFetcherException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5203535539150489104L;


	public AddressDataFetcherException(String message) {
        super(message);
    }

    public AddressDataFetcherException(Throwable cause) {
        super(cause);
    }


    public AddressDataFetcherException(String message, Throwable cause) {
        super(message, cause);
    }
}
