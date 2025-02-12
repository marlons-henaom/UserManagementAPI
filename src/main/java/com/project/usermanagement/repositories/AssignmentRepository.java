package com.project.usermanagement.repositories;

import com.project.usermanagement.entities.AssignmentEntity;
import com.project.usermanagement.entities.DependencyEntity;
import org.springframework.data.repository.CrudRepository;

public interface AssignmentRepository extends CrudRepository<AssignmentEntity, Integer> {
}
