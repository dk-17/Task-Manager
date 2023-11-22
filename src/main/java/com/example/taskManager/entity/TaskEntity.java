package com.example.taskManager.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TaskEntity {
    private int id;
    private String title;
    private String description;
    private Date deadLine;
    private Boolean completed;

}
