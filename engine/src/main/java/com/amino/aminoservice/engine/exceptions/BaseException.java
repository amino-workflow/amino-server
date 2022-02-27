package com.amino.aminoservice.engine.exceptions;


import org.springframework.http.HttpStatus;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * @author sridharswain
 */
public abstract class BaseException extends RuntimeException {

    private Exception exception;

    private String code;

    private String[] info = new String[0];

    private HttpStatus httpStatus;

    protected BaseException(String message, String... info) {
        super(message);
        this.exception = null;
        this.info = info == null ? new String[0] : info;
    }

    protected BaseException(String message, Exception exception,
                            String... info) {
        super(message, exception);
        this.exception = exception;
    }

    protected BaseException(String message, HttpStatus httpStatus,
                            String... info) {
        this.httpStatus = httpStatus;
    }

    protected BaseException(String message, Exception exception,
                            HttpStatus httpStatus, String... info) {
        super(message, exception);
        this.exception = exception;
        this.httpStatus = httpStatus;
    }

    public String[] getInfo() {
        return info;
    }

    public Exception getException() {
        return exception;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getCode() {
        return code;
    }

    public static String getStackTraceInStringFmt(Exception exceptionTrace) {
        Writer writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);
        exceptionTrace.printStackTrace(printWriter);
        printWriter.close();
        int len = writer.toString().length();
        return writer.toString().substring(0, Math.min(len,7000));
    }
}
