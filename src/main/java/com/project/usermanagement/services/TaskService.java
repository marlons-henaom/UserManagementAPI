package com.project.usermanagement.services;

import com.project.usermanagement.dtos.Task;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface TaskService {

    Task saveTask(Task task);

    List<Task> getAllTask();

    Task updateTask(Task task, Integer id);

    void deleteTask(Integer id);
}
