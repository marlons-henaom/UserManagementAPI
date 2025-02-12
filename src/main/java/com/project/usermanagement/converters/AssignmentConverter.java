package com.project.usermanagement.converters;

import com.project.usermanagement.dtos.Assignment;
import com.project.usermanagement.entities.AssignmentEntity;
import org.springframework.stereotype.Component;

@Component
public class AssignmentConverter {

    public AssignmentEntity convertDTOtoEntity(Assignment assignment){
        AssignmentEntity ae = new AssignmentEntity();
        ae.setUser(assignment.getUser());
        ae.setTask(assignment.getTask());
        ae.setDuration(assignment.getDuration());
        return ae;
    }

    public Assignment convertEntityDTO(AssignmentEntity assignmentEntity){
        Assignment assignment = new Assignment();
        assignment.setId(assignmentEntity.getId());
        assignment.setUser(assignmentEntity.getUser());
        assignment.setTask(assignmentEntity.getTask());
        assignment.setDuration(assignmentEntity.getDuration());
        return assignment;
    }
}
