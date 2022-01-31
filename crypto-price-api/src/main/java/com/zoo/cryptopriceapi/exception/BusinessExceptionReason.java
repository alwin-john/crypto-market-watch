package com.zoo.cryptopriceapi.exception;

import org.springframework.http.HttpStatus;

public enum BusinessExceptionReason implements BusinessExceptionPolicy{

    NOT_FOUND("No data is available from database", HttpStatus.NOT_FOUND);

    private static final String code = BusinessExceptionReason.class.getSimpleName();

    private final String message;

    private HttpStatus httpStatus;

    BusinessExceptionReason(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }
}
