package com.example.taskManager.controller;

import com.example.taskManager.dto.CreateNotesDTO;
import com.example.taskManager.dto.CreateNotesResponseDTO;
import com.example.taskManager.entity.NotesEntity;
import com.example.taskManager.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks/{taskId}/notes")
public class NotesController {

    @Autowired
    private NotesService notesService;

    @GetMapping("")
    public ResponseEntity<List<NotesEntity>> getNotes(@PathVariable("taskId") int taskId) {

        List<NotesEntity> notes = notesService.getNotesForTask(taskId);

        return ResponseEntity.ok(notes);

    }

    @PostMapping("")
    public ResponseEntity<CreateNotesResponseDTO> addNotesForTask(
            @PathVariable("taskId") int taskId,
            @RequestBody CreateNotesDTO notesDTO
            ) {
       NotesEntity note = notesService.addNoteForTask(taskId, notesDTO.getTitle(), notesDTO.getBody());
       return ResponseEntity.ok(new CreateNotesResponseDTO(taskId, note));
    }

}
