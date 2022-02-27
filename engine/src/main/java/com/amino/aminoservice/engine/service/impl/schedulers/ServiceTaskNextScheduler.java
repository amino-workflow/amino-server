package com.amino.aminoservice.engine.service.impl.schedulers;

import com.amino.aminoservice.engine.model.Workflow;
import com.amino.aminoservice.engine.model.tasks.ServiceTask;
import com.amino.aminoservice.engine.service.TaskNextScheduler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author sridharswain
 */
@Service
@RequiredArgsConstructor
public class ServiceTaskNextScheduler implements TaskNextScheduler<ServiceTask> {

    @Override
    public void execute(Workflow workflow, ServiceTask task, String input) {

    }
}
