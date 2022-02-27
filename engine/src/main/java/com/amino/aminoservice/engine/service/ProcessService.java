package com.amino.aminoservice.engine.service;

import com.amino.aminoservice.engine.model.Task;
import com.amino.aminoservice.engine.model.Workflow;
import com.amino.aminoservice.engine.entity.ProcessEntity;

import java.util.List;

/**
 * @author sridharswain
 */
public interface ProcessService {

    List<ProcessEntity> schedule(Workflow workflow, List<Task> task, String input_json);

    List<Process> poll(String topic);
}
