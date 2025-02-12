package com.project.usermanagement.converters;

import com.project.usermanagement.dtos.Dependency;
import com.project.usermanagement.entities.DependencyEntity;
import org.springframework.stereotype.Component;

@Component
public class DependencyConverter {

    public DependencyEntity convertDTOtoEntity(Dependency dependency){
        DependencyEntity de = new DependencyEntity();
        de.setDependency(dependency.getDependency());
        return de;
    }

    public Dependency convertEntityDTO(DependencyEntity dependencyEntity){
        Dependency dependency = new Dependency();
        dependency.setId(dependencyEntity.getId());
        dependency.setDependency(dependencyEntity.getDependency());
        return dependency;
    }
}
