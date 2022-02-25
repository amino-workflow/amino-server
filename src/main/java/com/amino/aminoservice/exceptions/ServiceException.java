package com.amino.aminoservice.exceptions;


import org.springframework.http.HttpStatus;

/**
 * @author sridharswain
 */
public abstract class ServiceException extends BaseException {

    public ServiceException(String message, String... info) {
        super(message, info);
    }

    public ServiceException(String message, Exception exception, String... info) {
        super(message, exception, info);
    }

    public ServiceException(String message, HttpStatus httpStatus, String... info) {
        super(message, httpStatus, info);
    }

    public ServiceException(String message, Exception exception, HttpStatus httpStatus, String... info) {
        super(message, exception, httpStatus, info);
    }
}
