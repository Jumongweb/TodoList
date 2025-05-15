package com.jumong.todolist.model;

import com.jumong.todolist.exception.TodoException;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;

    public void validate() {
        validateTitle();
        validateDescription();
    }

    public void validateTitle() {
        if (title == null || title.isBlank()) {
            throw new TodoException("Title cannot be empty");
        }
    }

    public void validateDescription() {
        if (description == null || description.isBlank()) {
            throw new TodoException("You need to enter a description");
        }
    }
}
