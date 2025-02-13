package com.project.usermanagement.services.impl;

import com.project.usermanagement.converters.DependencyConverter;
import com.project.usermanagement.converters.UserConverter;
import com.project.usermanagement.dtos.Dependency;
import com.project.usermanagement.dtos.User;
import com.project.usermanagement.entities.DependencyEntity;
import com.project.usermanagement.entities.UserEntity;
import com.project.usermanagement.exceptions.BusinessException;
import com.project.usermanagement.exceptions.ErrorModel;
import com.project.usermanagement.repositories.DependencyRepository;
import com.project.usermanagement.repositories.UserRepository;
import com.project.usermanagement.services.DependencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DependencyServiceImpl implements DependencyService {

    @Autowired
    private DependencyRepository dependencyRepository;

    @Autowired
    private DependencyConverter dependencyConverter;

    @Override
    public Dependency saveDependency(Dependency dependency) {
        DependencyEntity de = dependencyConverter.convertDTOtoEntity(dependency);
        de = dependencyRepository.save(de);
        dependency = dependencyConverter.convertEntityDTO(de);
        return dependency;
    }

    @Override
    public List<Dependency> getAllDependency() {
        Iterable<DependencyEntity> dependencies = dependencyRepository.findAll();
        List<Dependency> dependencyList = new ArrayList<>();
        for (DependencyEntity de : dependencies){
            Dependency dependency = dependencyConverter.convertEntityDTO(de);
            dependencyList.add(dependency);
        }
        return dependencyList;
    }

    @Override
    public Dependency updateDependency(Dependency dependency, Integer id) throws BusinessException {
        Optional<DependencyEntity> optEn = dependencyRepository.findById(id);
        Dependency dependencyDto = null;
        if (optEn.isPresent()){
            DependencyEntity de = optEn.get();
            de.setDependency(dependency.getDependency());
            dependencyDto = dependencyConverter.convertEntityDTO(de);
            dependencyRepository.save(de);
        } else {
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("NOT_FOUND");
            errorModel.setMessage("DEPENDENCY NOT FOUND");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        }

        return dependencyDto;
    }

    @Override
    public void deleteDependency(Integer id) {
        dependencyRepository.deleteById(id);
    }
}
