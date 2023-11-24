package com.example.taskManager.service;

import com.example.taskManager.entity.NotesEntity;
import com.example.taskManager.entity.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class NotesService {

    @Autowired
    private TaskService taskService;

    private HashMap<Integer, TaskNotesHolder> taskNotes = new HashMap<>();

    class TaskNotesHolder {
        protected int noteId = 1;
        protected ArrayList<NotesEntity> notes = new ArrayList<>();
    }

    public List<NotesEntity> getNotesForTask(int taskId) {
        TaskEntity task = taskService.getTaskById(taskId);

        if(task == null) {
            return null;
        }

        if(taskNotes.get(taskId) == null) {
            taskNotes.put(taskId, new TaskNotesHolder());
        }

        return taskNotes.get(taskId).notes;

    }

    public NotesEntity addNoteForTask(int taskId, String title, String body) {
        TaskEntity task = taskService.getTaskById(taskId);
        if(task == null) {
            return null;
        }

        // why are we just creating taskNotesHolder and mapping if task id is null??
        if(taskNotes.get(taskId) == null) {
            taskNotes.put(taskId, new TaskNotesHolder()); // this will crete new node with id,
        }

        TaskNotesHolder taskNotesHolder = taskNotes.get(taskId);
        NotesEntity note = new NotesEntity();
        note.setId(taskNotesHolder.noteId); // note id will be used here.
        note.setTitle(title);
        note.setBody(body);
        taskNotesHolder.notes.add(note); // inside hashmap
        taskNotesHolder.noteId++; // inside hashmap

        return note;
    }
}
