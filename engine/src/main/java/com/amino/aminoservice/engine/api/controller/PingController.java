package com.amino.aminoservice.engine.api.controller;

import com.amino.aminoservice.engine.api.PingApi;
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
