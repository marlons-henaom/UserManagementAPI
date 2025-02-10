package com.project.UserManagament.repositories;

import com.project.UserManagament.Entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
}
