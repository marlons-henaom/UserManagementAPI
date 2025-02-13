package com.project.usermanagement.repositories;

import com.project.usermanagement.entities.UserProfileEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserProfileRepository extends CrudRepository<UserProfileEntity, Integer> {
}
