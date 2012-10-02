package com.denistiago.fetcher.exception;

public class AddressDataFetcherException extends Exception {

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
