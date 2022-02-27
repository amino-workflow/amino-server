package com.amino.aminoservice.engine.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sridharswain
 */
@RequestMapping("/ping")
public interface PingApi {

    @GetMapping
    ResponseEntity<?> ping();
}
