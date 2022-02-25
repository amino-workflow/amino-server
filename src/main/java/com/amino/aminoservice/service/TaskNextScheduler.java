package com.amino.aminoservice.service;

import com.amino.aminoservice.model.Task;
import com.amino.aminoservice.model.Workflow;

/**
 * @author sridharswain
 */

public interface TaskNextScheduler<TTask extends Task> {

    void execute(Workflow workflow, TTask task, String input);
}
