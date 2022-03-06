package com.amino.aminoservice.server.service.impl;

import com.amino.aminoservice.server.constants.StringConstants;
import com.amino.aminoservice.server.dto.request.AcknowledgeProcessRequest;
import com.amino.aminoservice.server.dto.response.ProcessPollResponse;
import com.amino.aminoservice.server.entity.ProcessEntity;
import com.amino.aminoservice.server.enums.ProcessStatus;
import com.amino.aminoservice.server.exceptions.throwable.ProcessOperationException;
import com.amino.aminoservice.server.mappers.ProcessMapper;
import com.amino.aminoservice.server.model.Task;
import com.amino.aminoservice.server.model.Workflow;
import com.amino.aminoservice.server.repository.ProcessRepository;
import com.amino.aminoservice.server.service.ProcessService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sridharswain
 */
@Service
@RequiredArgsConstructor
public class ProcessServiceImpl implements ProcessService {

    private final ProcessRepository processRepository;

    @Override
    public List<ProcessEntity> schedule(Workflow workflow, List<Task> tasks, String inputJson) {
        return processRepository.saveAll(ProcessMapper.mapToEntity(workflow, tasks, inputJson));
    }

    @Override
    @Transactional
    public List<ProcessPollResponse> poll(String topic, int pollSize) {

        // Get scheduled processes to run
        List<ProcessEntity> scheduledProcesses = processRepository.fetchScheduledProcess(topic,
                PageRequest.of(0, pollSize));

        // Update processes to running status
        processRepository.updateProcessStatus(ProcessStatus.RUNNING, scheduledProcesses.stream()
                .map(ProcessEntity::getId)
                .collect(Collectors.toList()));

        // Map and return
        return ProcessMapper.mapToPollResponses(scheduledProcesses);
    }

    @Override
    @Transactional
    public void acknowledge(AcknowledgeProcessRequest acknowledgeRequest) {
        ProcessEntity process = processRepository.fetchRunningProcessByReferenceId(acknowledgeRequest.getReferenceId())
                .orElseThrow(() -> new ProcessOperationException(StringConstants.Errors.INVALID_PROCESS));


    }
}
