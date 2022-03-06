package com.amino.aminoservice.server.service;

import com.amino.aminoservice.server.dto.request.AcknowledgeProcessRequest;
import com.amino.aminoservice.server.dto.response.ProcessPollResponse;
import com.amino.aminoservice.server.entity.ProcessEntity;
import com.amino.aminoservice.server.model.Task;
import com.amino.aminoservice.server.model.Workflow;

import java.util.List;

/**
 * @author sridharswain
 */
public interface ProcessService {

    List<ProcessEntity> schedule(Workflow workflow, List<Task> task, String input_json);

    List<ProcessPollResponse> poll(String topic, int pollSize);

    void acknowledge(AcknowledgeProcessRequest acknowledgeRequest);
}
