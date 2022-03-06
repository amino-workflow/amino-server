package com.amino.aminoservice.server.api.controller;

import com.amino.aminoservice.server.api.ProcessApi;
import com.amino.aminoservice.server.dto.request.AcknowledgeProcessRequest;
import com.amino.aminoservice.server.dto.response.GenericResponse;
import com.amino.aminoservice.server.service.ProcessService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sridharswain
 */
@RestController
@RequiredArgsConstructor
public class ProcessController implements ProcessApi {

    private final ProcessService processService;

    @Override
    public ResponseEntity<?> pollForTopic(String topic, int pollSize) {
        return GenericResponse.ok(processService.poll(topic, pollSize));
    }

    @Override
    public ResponseEntity<?> acknowledgeProcess(AcknowledgeProcessRequest acknowledgeRequest) {
        return null;
    }
}
