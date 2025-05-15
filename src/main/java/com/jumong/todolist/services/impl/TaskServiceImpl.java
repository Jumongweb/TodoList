package com.jumong.todolist.services.impl;

import com.jumong.todolist.config.TaskMapper;
import com.jumong.todolist.dtos.request.CreateTaskRequest;
import com.jumong.todolist.dtos.response.TaskResponse;
import com.jumong.todolist.exception.TodoException;
import com.jumong.todolist.model.Task;
import com.jumong.todolist.model.TaskStatus;
import com.jumong.todolist.reposoitories.TaskRepository;
import com.jumong.todolist.services.interfaces.TaskService;
import com.jumong.todolist.validation.TodoValidation;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
@ToString
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public List<TaskResponse> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return taskMapper.toResponses(tasks);
    }

    public TaskResponse createTask(CreateTaskRequest createTaskRequest) {
        TodoValidation.validateObjectInstance(createTaskRequest, "Task request cannot be empty");
        Task newTask = taskMapper.toTask(createTaskRequest);
        newTask.setTaskStatus(TaskStatus.PENDING);
        newTask.validate();
        Task savedTask = taskRepository.save(newTask);
        return taskMapper.toResponse(savedTask);
    }

    @Override
    public TaskResponse getTaskById(Long taskId) {
        TodoValidation.validateId(taskId, "Task id cannot be empty");
        Task task = taskRepository.findById(taskId)
                .orElseThrow(()-> new TodoException("Task does not exist"));
        return taskMapper.toResponse(task);
    }

    public void deleteTask(Long taskId) {
        TodoValidation.validateId(taskId, "Task id cannot be empty");
        taskRepository.deleteById(taskId);
    }
}

