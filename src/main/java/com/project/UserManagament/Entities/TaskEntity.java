package com.project.UserManagament.Entities;

import com.project.UserManagament.dto.Assignment;
import com.project.UserManagament.enums.Dependency;
import com.project.UserManagament.enums.Profile;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.List;

public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;

}
