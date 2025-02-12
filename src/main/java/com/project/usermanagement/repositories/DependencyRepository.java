package com.project.usermanagement.repositories;

import com.project.usermanagement.entities.DependencyEntity;
import com.project.usermanagement.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DependencyRepository extends CrudRepository<DependencyEntity, Integer> {
}
