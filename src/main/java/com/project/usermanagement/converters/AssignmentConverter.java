package com.project.usermanagement.converters;

import com.project.usermanagement.dtos.Assignment;
import com.project.usermanagement.entities.AssignmentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AssignmentConverter {

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private TaskConverter taskConverter;

    public AssignmentEntity convertDTOtoEntity(Assignment assignment){
        AssignmentEntity ae = new AssignmentEntity();
        ae.setUser(userConverter.convertDTOtoEntity(assignment.getUser()));
        ae.setTask(taskConverter.convertDTOtoEntity(assignment.getTask()));
        ae.setDuration(assignment.getDuration());
        return ae;
    }

    public Assignment convertEntityDTO(AssignmentEntity assignmentEntity){
        Assignment assignment = new Assignment();
        assignment.setId(assignmentEntity.getId());
        assignment.setUser(userConverter.convertEntityDTO(assignmentEntity.getUser()));
        assignment.setTask(taskConverter.convertEntityDTO(assignmentEntity.getTask()));
        assignment.setDuration(assignmentEntity.getDuration());
        return assignment;
    }
}
