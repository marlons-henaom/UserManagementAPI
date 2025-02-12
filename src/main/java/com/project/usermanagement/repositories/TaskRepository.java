package com.project.usermanagement.repositories;

import com.project.usermanagement.entities.TaskEntity;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<TaskEntity, Integer> {
}
