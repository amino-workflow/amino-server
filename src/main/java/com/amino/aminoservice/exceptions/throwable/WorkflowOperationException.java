package com.amino.aminoservice.exceptions.throwable;

import com.amino.aminoservice.exceptions.ServiceException;
import org.springframework.http.HttpStatus;

/**
 * @author sridharswain
 */
public class WorkflowOperationException extends ServiceException {

    public WorkflowOperationException(String message, String... info) {
        super(message, info);
    }

    public WorkflowOperationException(String message, Exception exception, String... info) {
        super(message, exception, info);
    }

    public WorkflowOperationException(String message, HttpStatus httpStatus, String... info) {
        super(message, httpStatus, info);
    }

    public WorkflowOperationException(String message, Exception exception, HttpStatus httpStatus, String... info) {
        super(message, exception, httpStatus, info);
    }
}
