package com.amino.aminoservice.engine.service;

import com.amino.aminoservice.engine.model.Task;
import com.amino.aminoservice.engine.model.Workflow;

/**
 * @author sridharswain
 */

public interface TaskNextScheduler<TTask extends Task> {

    void execute(Workflow workflow, TTask task, String input);
}
