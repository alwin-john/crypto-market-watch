package com.zoo.cryptopriceapi.exception;

import org.springframework.http.HttpStatus;

import static java.lang.String.format;

public class BusinessException extends RuntimeException {

    private final String code;

    private final String message;

    private final HttpStatus httpStatus;

    BusinessException(final BusinessExceptionReason businessExceptionReason) {
        this.code = businessExceptionReason.getCode();
        this.message = businessExceptionReason.getMessage();
        this.httpStatus = businessExceptionReason.getHttpStatus();
    }

    BusinessException(final BusinessExceptionReason businessExceptionReason, String message) {
        this.code = businessExceptionReason.getCode();
        this.message = message;
        this.httpStatus = businessExceptionReason.getHttpStatus();
    }


    public BusinessException(final BusinessExceptionReason reason, final Object... parameters) {
        if (parameters != null) {
            this.message = format(reason.getMessage(), parameters);
        } else {
            this.message = reason.getMessage();
        }

        this.code = reason.getCode();
        this.httpStatus = reason.getHttpStatus();
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
