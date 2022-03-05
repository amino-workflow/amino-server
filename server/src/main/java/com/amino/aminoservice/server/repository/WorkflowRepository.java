package com.amino.aminoservice.server.repository;

import com.amino.aminoservice.server.entity.WorkflowEntity;
import com.amino.aminoservice.server.enums.WorkflowStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author sridharswain
 */
public interface WorkflowRepository extends JpaRepository<WorkflowEntity, String> {

    Optional<WorkflowEntity> findFirstByNameAndWorkflowStatusOrderByVersion(String workflowName, WorkflowStatus status);
}
