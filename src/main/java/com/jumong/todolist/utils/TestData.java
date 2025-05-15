package com.jumong.todolist.utils;

import com.jumong.todolist.dtos.request.CreateTaskRequest;
import com.jumong.todolist.model.TaskStatus;

public class TestData {

    public static CreateTaskRequest getCreateTaskRequest(String title) {
        CreateTaskRequest createTaskRequest = new CreateTaskRequest();
        createTaskRequest.setTitle(title);
        createTaskRequest.setDescription("description");
        return createTaskRequest;
    }
}
