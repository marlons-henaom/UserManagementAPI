package com.project.usermanagement.converters;

import com.project.usermanagement.dtos.Task;
import com.project.usermanagement.entities.TaskEntity;
import org.springframework.stereotype.Component;

@Component
public class TaskConverter {

    public TaskEntity convertDTOtoEntity(Task task){
        TaskEntity te = new TaskEntity();
        te.setTask(task.getTask());
        return te;
    }

    public Task convertEntityDTO(TaskEntity taskEntity){
        Task task = new Task();
        task.setId(taskEntity.getId());
        task.setTask(taskEntity.getTask());
        return task;
    }
}
