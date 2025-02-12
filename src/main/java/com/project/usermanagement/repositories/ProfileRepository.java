package com.project.usermanagement.repositories;

import com.project.usermanagement.entities.DependencyEntity;
import com.project.usermanagement.entities.ProfileEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<ProfileEntity, Integer> {
}
