package com.amino.aminoservice.entity.projections;

import com.amino.aminoservice.enums.WorkflowStatus;
import com.amino.aminoservice.model.WorkflowSequence;

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
