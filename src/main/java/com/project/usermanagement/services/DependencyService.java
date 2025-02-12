package com.project.usermanagement.services;

import com.project.usermanagement.dtos.Dependency;

import java.util.List;

public interface DependencyService {

    Dependency saveDependency(Dependency dependency);

    List<Dependency> getAllDependency();

    Dependency updateDependency(Dependency dependency, Integer id);

    void deleteDependency(Integer id);
}
