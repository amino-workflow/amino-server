package com.amino.aminoservice.service.impl;

import com.amino.aminoservice.entity.ProcessEntity;
import com.amino.aminoservice.mappers.ProcessMapper;
import com.amino.aminoservice.model.Process;
import com.amino.aminoservice.model.Task;
import com.amino.aminoservice.model.Workflow;
import com.amino.aminoservice.repository.ProcessRepository;
import com.amino.aminoservice.service.ProcessService;
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
    public Process schedule(Workflow workflow, List<Task> tasks, String inputJson) {
        List<ProcessEntity> process = processRepository.saveAll(ProcessMapper.mapToEntity(workflow, tasks, inputJson));
    }
}
