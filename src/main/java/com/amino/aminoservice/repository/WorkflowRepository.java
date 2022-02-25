package com.amino.aminoservice.repository;

import com.amino.aminoservice.entity.WorkflowEntity;
import com.amino.aminoservice.enums.WorkflowStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author sridharswain
 */
public interface WorkflowRepository extends JpaRepository<WorkflowEntity, String> {

    Optional<WorkflowEntity> findFirstByNameAndWorkflowStatusOrderByVersion(String workflowName, WorkflowStatus status);
}
