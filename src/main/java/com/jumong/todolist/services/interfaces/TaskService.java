package com.jumong.todolist.services.interfaces;

import com.jumong.todolist.dtos.request.CreateTaskRequest;
import com.jumong.todolist.dtos.response.TaskResponse;

import java.util.List;

public interface TaskService {
    List<TaskResponse> getAllTasks();

    TaskResponse createTask(CreateTaskRequest createTaskRequest);

    TaskResponse getTaskById(Long taskId);

    void deleteTask(Long id);
}
