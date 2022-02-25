package com.amino.aminoservice.service.impl.schedulers;

import com.amino.aminoservice.constants.ServiceConstant;
import com.amino.aminoservice.model.Task;
import com.amino.aminoservice.model.Workflow;
import com.amino.aminoservice.model.WorkflowSequence;
import com.amino.aminoservice.model.tasks.StartWorkflowTask;
import com.amino.aminoservice.repository.WorkflowRepository;
import com.amino.aminoservice.service.TaskNextScheduler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author sridharswain
 */
@Service
@RequiredArgsConstructor
public class StartTaskNextScheduler implements TaskNextScheduler<StartWorkflowTask> {

    private final WorkflowRepository workflowRepository;

    @Override
    public void execute(Workflow workflow, StartWorkflowTask startWorkflowTask, String input) {
        List<Task> task = getFirstTask(workflow.getSequence());

    }

    private List<Task> getFirstTask(WorkflowSequence workflowSequence) {
        Map<String, Task> taskMap = workflowSequence.getTasks().stream()
                .collect(Collectors.toMap(Task::getName, Function.identity()));

        return workflowSequence.getSequences().stream()
                .filter(sequence -> ServiceConstant.START_EVENT_TAG.equals(sequence.getSource()))
                .map(sequence -> taskMap.get(sequence.getTarget()))
                .collect(Collectors.toList());
    }
}
