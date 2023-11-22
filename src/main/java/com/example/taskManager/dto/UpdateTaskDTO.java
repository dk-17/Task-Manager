package com.example.taskManager.dto;

import lombok.Data;

@Data
public class UpdateTaskDTO {
    private int id;
    private Boolean completed;
    private String description;
}
