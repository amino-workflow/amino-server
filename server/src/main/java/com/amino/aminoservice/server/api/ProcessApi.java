package com.amino.aminoservice.server.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sridharswain
 */
@RequestMapping("/process")
public interface ProcessApi {

    @GetMapping("/{topic}/poll")
    ResponseEntity<?> pollForTopic(@PathVariable("topic") String topic);
}
