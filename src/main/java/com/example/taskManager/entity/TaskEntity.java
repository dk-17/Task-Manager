package com.example.taskManager.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TaskEntity {
    private int id;
    private String title;
    private String description;
    private Date deadLine;
    private Boolean completed;
    //private List<NotesEntity> notes;
}
