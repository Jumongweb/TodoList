package com.jumong.todolist.validation;

import com.jumong.todolist.exception.TodoException;
import org.springframework.util.ObjectUtils;

public class TodoValidation {

    public static void validateObjectInstance(Object instance, String message) {
        if (ObjectUtils.isEmpty(instance)) {
            throw new TodoException(message);
        }
    }

    public static void validateId(Long taskId, String message) {
        if (taskId == null) {
            throw new TodoException(message);
        }
    }
}
