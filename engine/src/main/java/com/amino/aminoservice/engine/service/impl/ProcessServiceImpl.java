package com.amino.aminoservice.engine.service.impl;

import com.amino.aminoservice.engine.repository.ProcessRepository;
import com.amino.aminoservice.engine.entity.ProcessEntity;
import com.amino.aminoservice.engine.mappers.ProcessMapper;
import com.amino.aminoservice.engine.model.Task;
import com.amino.aminoservice.engine.model.Workflow;
import com.amino.aminoservice.engine.service.ProcessService;
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
