package com.amino.aminoservice.server.service;

import com.amino.aminoservice.server.model.Task;
import com.amino.aminoservice.server.model.Workflow;

/**
 * @author sridharswain
 */

public interface TaskNextScheduler<TTask extends Task> {

    void execute(Workflow workflow, TTask task, String input);
}
