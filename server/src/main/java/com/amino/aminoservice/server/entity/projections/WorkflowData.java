package com.amino.aminoservice.server.entity.projections;

import com.amino.aminoservice.server.enums.WorkflowStatus;
import com.amino.aminoservice.server.model.WorkflowSequence;

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
