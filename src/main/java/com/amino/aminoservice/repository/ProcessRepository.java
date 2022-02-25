package com.amino.aminoservice.repository;

import com.amino.aminoservice.entity.ProcessEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sridharswain
 */
public interface ProcessRepository extends JpaRepository<ProcessEntity, Long> {
}
