package com.amino.aminoservice.server.repository;

import com.amino.aminoservice.server.entity.ProcessEntity;
import com.amino.aminoservice.server.enums.ProcessStatus;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * @author sridharswain
 */
public interface ProcessRepository extends JpaRepository<ProcessEntity, Long> {

    @Query("SELECT pe FROM ProcessEntity pe " +
            "WHERE pe.topic=:topic " +
            "AND pe.processStatus=com.amino.aminoservice.server.enums.ProcessStatus.SCHEDULED")
    List<ProcessEntity> fetchScheduledProcess(@Param("topic") String topic, Pageable pageable);

    @Modifying
    @Query("UPDATE ProcessEntity pe SET pe.processStatus=:status " +
            "WHERE pe.id in (:processIds)")
    int updateProcessStatus(@Param("status") ProcessStatus processStatus,
                            @Param("processIds") List<Long> processIds);

    @Query("SELECT pe FROM ProcessEntity pe " +
            "WHERE pe.referenceId=:referenceId " +
            "AND pe.processStatus=com.amino.aminoservice.server.enums.ProcessStatus.RUNNING")
    Optional<ProcessEntity> fetchRunningProcessByReferenceId(@Param("referenceId") String referenceId);
}
