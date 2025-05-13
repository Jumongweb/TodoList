package com.jumong.todolist.response;

import com.jumong.todolist.model.TaskStatus;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateTaskResponse {
    private Long id;
    private String title;
    private String description;
    private TaskStatus completed;
}
