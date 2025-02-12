package com.project.usermanagement.services;

import com.project.usermanagement.dtos.Assignment;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AssignmentService {

    Assignment saveAssignment(Assignment assignment);

    List<Assignment> getAllAssignment();

    Assignment updateAssignment(Assignment assignment, Integer id);

    void deleteAssignment(Integer id);
}
