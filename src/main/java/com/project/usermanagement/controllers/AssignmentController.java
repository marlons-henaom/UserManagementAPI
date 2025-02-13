package com.project.usermanagement.controllers;

import com.project.usermanagement.dtos.Assignment;
import com.project.usermanagement.services.AssignmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @PostMapping
    public ResponseEntity<Assignment> saveAssignment(@Valid @RequestBody Assignment assignment){
        assignment = assignmentService.saveAssignment(assignment);
        return new ResponseEntity<>(assignment, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Assignment>> getAllAssignments(){
        List<Assignment> assignments = assignmentService.getAllAssignment();
        return new ResponseEntity<>(assignments, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Assignment> updateAssignment(@RequestBody Assignment assignment, @PathVariable Integer id){
        assignment = assignmentService.updateAssignment(assignment, id);
        return new ResponseEntity<>(assignment, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssignment(@PathVariable Integer id){
        assignmentService.deleteAssignment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
