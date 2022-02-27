package com.amino.aminoservice.engine.model;

import com.amino.aminoservice.engine.model.tasks.ServiceTask;
import com.amino.aminoservice.engine.model.tasks.StartWorkflowTask;
import com.amino.aminoservice.engine.enums.TaskType;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * @author sridharswain
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        property = "taskType", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = StartWorkflowTask.class, name = "START_WORKFLOW_TASK"),
        @JsonSubTypes.Type(value = ServiceTask.class, name = "SERVICE_TASK")
})
public abstract class Task {

    protected TaskType taskType;

    protected String name;
}
