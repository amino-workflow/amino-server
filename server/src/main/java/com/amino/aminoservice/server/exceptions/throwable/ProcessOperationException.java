package com.amino.aminoservice.server.exceptions.throwable;

import com.amino.aminoservice.server.exceptions.ServiceException;
import org.springframework.http.HttpStatus;

/**
 * @author sridharswain
 */
public class ProcessOperationException extends ServiceException {
    public ProcessOperationException(String message, String... info) {
        super(message, info);
    }

    public ProcessOperationException(String message, Exception exception, String... info) {
        super(message, exception, info);
    }

    public ProcessOperationException(String message, HttpStatus httpStatus, String... info) {
        super(message, httpStatus, info);
    }

    public ProcessOperationException(String message, Exception exception, HttpStatus httpStatus, String... info) {
        super(message, exception, httpStatus, info);
    }
}
