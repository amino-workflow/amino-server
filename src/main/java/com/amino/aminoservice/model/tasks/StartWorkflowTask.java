package com.amino.aminoservice.model.tasks;

import com.amino.aminoservice.enums.TaskType;
import com.amino.aminoservice.model.Task;
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
public class StartWorkflowTask extends Task {

    public static class Default extends StartWorkflowTask {
        public Default() {
            this.taskType = TaskType.START_WORKFLOW_TASK;
            this.name = "start";
        }
    }
}
