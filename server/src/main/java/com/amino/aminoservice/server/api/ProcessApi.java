package com.amino.aminoservice.server.api;

import com.amino.aminoservice.server.dto.request.AcknowledgeProcessRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author sridharswain
 */
@RequestMapping("/process")
public interface ProcessApi {

    @GetMapping("/{topic}/poll")
    ResponseEntity<?> pollForTopic(@PathVariable("topic") String topic,
                                   @RequestParam(value = "pollSize", required = false, defaultValue = "2") int pollSize);

    @PostMapping("/acknowledge")
    ResponseEntity<?> acknowledgeProcess(AcknowledgeProcessRequest acknowledgeRequest);
}
