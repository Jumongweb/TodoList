package com.jumong.todolist.config;

import com.jumong.todolist.dtos.request.CreateTaskRequest;
import com.jumong.todolist.dtos.response.TaskResponse;
import com.jumong.todolist.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskResponse toResponse(Task task);

    Task toTask(CreateTaskRequest createTaskRequest);

    List<TaskResponse> toResponses(List<Task> tasks);

}
