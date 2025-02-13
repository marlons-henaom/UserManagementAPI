package com.project.usermanagement.controllers;

import com.project.usermanagement.dtos.Dependency;
import com.project.usermanagement.services.DependencyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dependencies")
public class DependencyController {

    @Autowired
    private DependencyService dependencyService;

    @PostMapping
    public ResponseEntity<Dependency> saveDependency(@Valid @RequestBody Dependency dependency){
        dependency = dependencyService.saveDependency(dependency);
        return new ResponseEntity<>(dependency, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Dependency>> getAllDependencies(){
        List<Dependency> dependencies = dependencyService.getAllDependency();
        return new ResponseEntity<>(dependencies, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dependency> updateDependency(@RequestBody Dependency dependency, @PathVariable Integer id){
        dependency = dependencyService.updateDependency(dependency, id);
        return new ResponseEntity<>(dependency, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDependency(@PathVariable Integer id){
        dependencyService.deleteDependency(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
