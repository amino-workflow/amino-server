package com.amino.aminoservice.engine.mappers;

import com.amino.aminoservice.engine.entity.WorkflowEntity;
import com.amino.aminoservice.engine.enums.ProcessStatus;
import com.amino.aminoservice.engine.model.Task;
import com.amino.aminoservice.engine.model.Workflow;
import com.amino.aminoservice.engine.entity.ProcessEntity;
import lombok.experimental.UtilityClass;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author sridharswain
 */
@UtilityClass
public class ProcessMapper {

    public List<ProcessEntity> mapToEntity(Workflow workflow, List<Task> tasks, String inputJson) {
        if (CollectionUtils.isEmpty(tasks)) {
            return Collections.emptyList();
        }
        return tasks.stream()
                .map(task -> mapToEntity(workflow, task, inputJson))
                .collect(Collectors.toList());
    }

    public ProcessEntity mapToEntity(Workflow workflow, Task task, String inputJson) {
        return ProcessEntity.builder()
                .taskName(task.getName())
                .inputJson(inputJson)
                .processStatus(ProcessStatus.SCHEDULED)
                .workflow((WorkflowEntity) workflow)
                .referenceId(UUID.randomUUID().toString())
                .build();
    }
}
