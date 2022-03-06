package com.amino.aminoservice.server.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author sridharswain
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenericResponse<TData> {
    private HttpStatus httpStatus;
    private TData data;
    private String message;

    public GenericResponse(HttpStatus httpStatus, TData data) {
        this.httpStatus = httpStatus;
        this.data = data;
    }

    public GenericResponse(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public static <U> ResponseEntity<GenericResponse<U>> getResponseWithCode(HttpStatus status, U data) {
        return ResponseEntity.ok(new GenericResponse<>(status, data));
    }

    public static <U> ResponseEntity<GenericResponse<U>> getResponseMessageWithCode(HttpStatus status, String message) {
        return ResponseEntity.ok(new GenericResponse<>(status, message));
    }

    public static <U> ResponseEntity<GenericResponse<U>> ok(U data) {
        GenericResponse<U> responseData = new GenericResponse<>(HttpStatus.OK, data);
        return ResponseEntity.ok(responseData);
    }
}
