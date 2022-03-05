package com.amino.aminoservice.server.entity;

import com.amino.aminoservice.server.model.Workflow;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author sridharswain
 */
@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "workflows")
public class WorkflowEntity extends Workflow {

    @OneToMany(mappedBy = "workflow", cascade = CascadeType.ALL)
    private List<ProcessEntity> processes;
}
