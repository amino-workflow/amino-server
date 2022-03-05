package com.amino.aminoservice.server.service.impl;

import com.amino.aminoservice.server.constants.ServiceConstant;
import com.amino.aminoservice.server.entity.WorkflowEntity;
import com.amino.aminoservice.server.enums.WorkflowStatus;
import com.amino.aminoservice.server.exceptions.throwable.WorkflowOperationException;
import com.amino.aminoservice.server.model.Task;
import com.amino.aminoservice.server.model.WorkflowSequence;
import com.amino.aminoservice.server.repository.WorkflowRepository;
import com.amino.aminoservice.server.service.ProcessService;
import com.amino.aminoservice.server.service.WorkflowService;
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
public class WorkflowServiceImpl implements WorkflowService {

    private final WorkflowRepository workflowRepository;

    private final ProcessService processService;

    @Override
    public void start(String workflowName, String input) {
        WorkflowEntity workflow = workflowRepository
                .findFirstByNameAndWorkflowStatusOrderByVersion(workflowName, WorkflowStatus.ACTIVE)
                .orElseThrow(() -> new WorkflowOperationException(String.format("No such workflow exist : %s", workflowName)));

        processService.schedule(workflow, getFirstTask(workflow.getSequence()), input);
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
