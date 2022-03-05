package com.amino.aminoservice.server.service.impl.schedulers;

import com.amino.aminoservice.server.model.Workflow;
import com.amino.aminoservice.server.model.tasks.ServiceTask;
import com.amino.aminoservice.server.service.TaskNextScheduler;
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
