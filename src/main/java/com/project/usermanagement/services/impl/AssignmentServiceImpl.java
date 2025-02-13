package com.project.usermanagement.services.impl;

import com.project.usermanagement.converters.AssignmentConverter;
import com.project.usermanagement.converters.TaskConverter;
import com.project.usermanagement.converters.UserConverter;
import com.project.usermanagement.dtos.Assignment;
import com.project.usermanagement.dtos.Assignment;
import com.project.usermanagement.entities.AssignmentEntity;
import com.project.usermanagement.exceptions.BusinessException;
import com.project.usermanagement.exceptions.ErrorModel;
import com.project.usermanagement.repositories.AssignmentRepository;
import com.project.usermanagement.services.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AssignmentServiceImpl implements AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private AssignmentConverter assignmentConverter;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private TaskConverter taskConverter;

    @Override
    public Assignment saveAssignment(Assignment assignment) {
        AssignmentEntity ae = assignmentConverter.convertDTOtoEntity(assignment);
        ae = assignmentRepository.save(ae);
        assignment = assignmentConverter.convertEntityDTO(ae);
        return assignment;
    }

    @Override
    public List<Assignment> getAllAssignment() {
        Iterable<AssignmentEntity> assignments = assignmentRepository.findAll();
        List<Assignment> assignmentList = new ArrayList<>();
        for (AssignmentEntity ae : assignments){
            Assignment assignment = assignmentConverter.convertEntityDTO(ae);
            assignmentList.add(assignment);
        }
        return assignmentList;
    }

    @Override
    public Assignment updateAssignment(Assignment assignment, Integer id) throws BusinessException {
        Optional<AssignmentEntity> optEn = assignmentRepository.findById(id);
        Assignment assignmentDto = null;
        if (optEn.isPresent()){
            AssignmentEntity ae = optEn.get();
            ae.setDuration(assignment.getDuration());
            ae.setTask(taskConverter.convertDTOtoEntity(assignment.getTask()));
            ae.setUser(userConverter.convertDTOtoEntity(assignment.getUser()));
            assignmentDto = assignmentConverter.convertEntityDTO(ae);
            assignmentRepository.save(ae);
        } else {
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("NOT_FOUND");
            errorModel.setMessage("ASSIGNMENT NOT FOUND");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        }

        return assignmentDto;
    }

    @Override
    public void deleteAssignment(Integer id) {
        assignmentRepository.deleteById(id);
    }

}
