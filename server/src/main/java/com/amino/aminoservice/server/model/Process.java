package com.amino.aminoservice.server.model;

import com.amino.aminoservice.server.enums.ProcessStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author sridharswain
 */
@Getter
@Setter
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public abstract class Process extends Audit {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "reference_id")
    private String referenceId;

    @Column(name = "task_name")
    private String taskName;

    @Column(name = "topic")
    private String topic;

    @Column(name = "input_json")
    private String inputJson;

    @Enumerated(EnumType.STRING)
    @Column(name = "process_status")
    private ProcessStatus processStatus;
}
