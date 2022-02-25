package com.amino.aminoservice.mappers;

import com.amino.aminoservice.entity.ProcessEntity;
import com.amino.aminoservice.entity.WorkflowEntity;
import com.amino.aminoservice.enums.ProcessStatus;
import com.amino.aminoservice.model.Task;
import com.amino.aminoservice.model.Workflow;
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
                .processStatus(ProcessStatus.READY)
                .workflow((WorkflowEntity) workflow)
                .referenceId(UUID.randomUUID().toString())
                .build();
    }
}
