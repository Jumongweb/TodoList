package com.jumong.todolist.dtos.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    private String message;
    private T data;
    private String statusCode;
    @JsonFormat(pattern = "yyyy-MM-dd HH`:mm:ss")
    private LocalDateTime timeStamp;

}
