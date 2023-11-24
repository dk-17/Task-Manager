package com.example.taskManager.dto;

import com.example.taskManager.entity.NotesEntity;
import com.example.taskManager.entity.TaskEntity;
import lombok.Data;

import java.util.List;

@Data
public class TaskResponseDTO {
    private TaskEntity task;
    private List<NotesEntity> notes;
}
