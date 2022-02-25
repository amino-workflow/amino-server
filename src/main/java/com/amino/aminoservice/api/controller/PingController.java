package com.amino.aminoservice.api.controller;

import com.amino.aminoservice.api.PingApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sridharswain
 */
@RestController
public class PingController implements PingApi {

    @Override
    public ResponseEntity<?> ping() {
        return ResponseEntity.ok("pong");
    }
}
