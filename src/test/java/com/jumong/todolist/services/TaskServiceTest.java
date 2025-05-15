package com.jumong.todolist.services;

import com.jumong.todolist.dtos.request.CreateTaskRequest;
import com.jumong.todolist.dtos.response.TaskResponse;
import com.jumong.todolist.exception.TodoException;
import com.jumong.todolist.services.interfaces.TaskService;
import com.jumong.todolist.utils.TestData;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class TaskServiceTest {

    @Autowired
    private TaskService taskService;

    private CreateTaskRequest createTaskRequest;

    @BeforeEach
    void setUp() {
        createTaskRequest = TestData.getCreateTaskRequest("title");
    }

    @Test
    void createTaskWithNullRequest() {
        assertThrows(TodoException.class, ()->taskService.createTask(null));
    }

    @Test
    void createTaskWithNullTitle(){
        createTaskRequest.setTitle(null);
        assertThrows(TodoException.class, ()->taskService.createTask(createTaskRequest));
    }

    @Test
    void createTaskWithNullDescription(){
        createTaskRequest.setDescription(null);
        assertThrows(TodoException.class, ()->taskService.createTask(createTaskRequest));
    }

    @Order(1)
    @Test
    void testCreateTask() {
        TaskResponse response = taskService.createTask(createTaskRequest);
        assertNotNull(response);
        assertThat(response.getTitle()).isEqualTo("title");
    }

    @Test
    void getTaskByNullId(){
        assertThrows(TodoException.class, ()->taskService.getTaskById(null));
    }

    @Test
    void getTaskByNonExistingId(){
        assertThrows(TodoException.class, ()->taskService.getTaskById(100000L));
    }

    @Order(2)
    @Test
    void getTaskById() {
        TaskResponse response = taskService.getTaskById(1L);
        assertNotNull(response);
    }

    @Order(3)
    @Test
    void createMoreThanOneTask() {
        createTaskRequest.setTitle("Title2");
        TaskResponse response = taskService.createTask(createTaskRequest);
        assertThat(response).isNotNull();
    }

    @Order(4)
    @Test
    void getAllTasks() {
        taskService.createTask(TestData.getCreateTaskRequest("Task1"));
        taskService.createTask(TestData.getCreateTaskRequest("Task2"));
        List<TaskResponse> taskResponses = taskService.getAllTasks();
        assertThat(taskResponses.size()).isEqualTo(2);
    }

    @Test
    void deleteTaskWithNullId() {
        assertThrows(TodoException.class, ()->taskService.deleteTask(null));
    }

    @Order(5)
    @Test
    void deleteTask() {
        taskService.deleteTask(1L);
        assertThrows(TodoException.class, ()-> taskService.getTaskById(1L));
    }


}