package com.project.usermanagement.services.impl;

import com.project.usermanagement.converters.TaskConverter;
import com.project.usermanagement.dtos.Task;
import com.project.usermanagement.entities.TaskEntity;
import com.project.usermanagement.exceptions.BusinessException;
import com.project.usermanagement.exceptions.ErrorModel;
import com.project.usermanagement.repositories.TaskRepository;
import com.project.usermanagement.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskConverter taskConverter;

    @Override
    public Task saveTask(Task task) {
        TaskEntity te = taskConverter.convertDTOtoEntity(task);
        te = taskRepository.save(te);
        task = taskConverter.convertEntityDTO(te);
        return task;
    }

    @Override
    public List<Task> getAllTask() {
        Iterable<TaskEntity> tasks = taskRepository.findAll();
        List<Task> taskList = new ArrayList<>();
        for (TaskEntity te : tasks){
            Task task = taskConverter.convertEntityDTO(te);
            taskList.add(task);
        }
        return taskList;
    }

    @Override
    public Task updateTask(Task task, Integer id) throws BusinessException {
        Optional<TaskEntity> optEn = taskRepository.findById(id);
        Task taskDto = null;
        if (optEn.isPresent()){
            TaskEntity te = optEn.get();
            te.setTask(task.getTask());
            taskDto = taskConverter.convertEntityDTO(te);
            taskRepository.save(te);
        } else {
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("NOT_FOUND");
            errorModel.setMessage("TASK NOT FOUND");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        }

        return taskDto;
    }

    @Override
    public void deleteTask(Integer id) {
        taskRepository.deleteById(id);
    }
    
}
