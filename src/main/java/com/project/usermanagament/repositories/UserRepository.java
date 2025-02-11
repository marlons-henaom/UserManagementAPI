package com.project.usermanagament.repositories;

import com.project.usermanagament.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    Optional<UserEntity> findByEmailAndPassword(String email, String password);
    Optional<UserEntity> findByEmail(String email);
}
