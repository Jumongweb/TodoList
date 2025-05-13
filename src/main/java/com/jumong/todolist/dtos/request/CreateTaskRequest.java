package com.jumong.todolist.dtos.request;

import com.jumong.todolist.model.TaskStatus;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateTaskRequest {
    private Long id;
    private String title;
    private String description;
    private TaskStatus completed;
}
