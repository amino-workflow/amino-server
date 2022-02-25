package com.amino.aminoservice.entity;

import com.amino.aminoservice.model.Process;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author sridharswain
 */
@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "processes")
public class ProcessEntity extends Process {

    @ManyToOne
    @JoinColumn(name = "workflow_id", nullable = false)
    private WorkflowEntity workflow;
}
