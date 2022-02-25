package com.amino.aminoservice.service;

import com.amino.aminoservice.model.Process;
import com.amino.aminoservice.model.Task;
import com.amino.aminoservice.model.Workflow;

import java.util.List;

/**
 * @author sridharswain
 */
public interface ProcessService {

    Process schedule(Workflow workflow, List<Task> task, String input_json);
}
