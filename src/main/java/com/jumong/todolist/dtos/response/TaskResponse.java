package com.jumong.todolist.dtos.response;

import com.jumong.todolist.model.TaskStatus;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TaskResponse {
    private Long id;
    private String title;
    private String description;
    private TaskStatus taskStatus;
}
