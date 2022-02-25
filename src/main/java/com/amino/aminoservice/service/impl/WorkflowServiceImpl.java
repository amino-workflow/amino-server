package com.amino.aminoservice.service.impl;

import com.amino.aminoservice.entity.WorkflowEntity;
import com.amino.aminoservice.enums.WorkflowStatus;
import com.amino.aminoservice.exceptions.throwable.WorkflowOperationException;
import com.amino.aminoservice.model.tasks.StartWorkflowTask;
import com.amino.aminoservice.repository.WorkflowRepository;
import com.amino.aminoservice.service.WorkflowService;
import com.amino.aminoservice.service.impl.schedulers.StartTaskNextScheduler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author sridharswain
 */
@Service
@RequiredArgsConstructor
public class WorkflowServiceImpl implements WorkflowService {

    private final WorkflowRepository workflowRepository;

    private final StartTaskNextScheduler startTaskNextScheduler;

    @Override
    public void start(String workflowName, String input) {
        WorkflowEntity workflow = workflowRepository
                .findFirstByNameAndWorkflowStatusOrderByVersion(workflowName, WorkflowStatus.ACTIVE)
                .orElseThrow(() -> new WorkflowOperationException(String.format("No such workflow exist : %s", workflowName)));

        startTaskNextScheduler.execute(workflow, new StartWorkflowTask.Default(), input);
    }
}
