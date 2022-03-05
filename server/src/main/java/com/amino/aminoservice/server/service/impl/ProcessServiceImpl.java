package com.amino.aminoservice.server.service.impl;

import com.amino.aminoservice.server.entity.ProcessEntity;
import com.amino.aminoservice.server.mappers.ProcessMapper;
import com.amino.aminoservice.server.model.Task;
import com.amino.aminoservice.server.model.Workflow;
import com.amino.aminoservice.server.repository.ProcessRepository;
import com.amino.aminoservice.server.service.ProcessService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Process> poll(String topic) {
        return null;
    }
}
