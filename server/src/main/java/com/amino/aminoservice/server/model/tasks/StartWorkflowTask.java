package com.amino.aminoservice.server.model.tasks;

import com.amino.aminoservice.server.enums.TaskType;
import com.amino.aminoservice.server.model.Task;
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
public class StartWorkflowTask extends Task {

    public static class Default extends StartWorkflowTask {
        public Default() {
            this.taskType = TaskType.START_WORKFLOW_TASK;
            this.name = "start";
        }
    }
}
