package com.itexico.main.testableCode.examples.refactor.exceptions;

public class UserNotAuthorizedException extends InvoicePrinterException {

    public UserNotAuthorizedException() {
    }

    public UserNotAuthorizedException(Throwable cause) {
        super(cause);
    }
}
