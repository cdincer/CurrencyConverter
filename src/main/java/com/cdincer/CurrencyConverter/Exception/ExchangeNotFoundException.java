package com.cdincer.CurrencyConverter.Exception;

public class ExchangeNotFoundException extends RuntimeException {

    public ExchangeNotFoundException() {
    }

    public ExchangeNotFoundException(String message) {
        super(message);
    }

    public ExchangeNotFoundException(Throwable cause) {
        super(cause);
    }

    public ExchangeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExchangeNotFoundException(String message, Throwable cause, boolean arg2, boolean arg3) {
        super(message, cause, arg2, arg3);
    }

}
