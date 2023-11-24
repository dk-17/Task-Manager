package com.example.taskManager.dto;

import com.example.taskManager.entity.NotesEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateNotesResponseDTO {
    private int taskId;
    private NotesEntity notes;
}
