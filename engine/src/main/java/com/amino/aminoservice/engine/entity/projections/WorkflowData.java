package com.amino.aminoservice.engine.entity.projections;

import com.amino.aminoservice.engine.enums.WorkflowStatus;
import com.amino.aminoservice.engine.model.WorkflowSequence;

/**
 * @author sridharswain
 */
public interface WorkflowData {
    String getId();

    String getName();

    WorkflowSequence getSequence();

    Integer getVersion();

    WorkflowStatus getWorkflowStatus();
}
