package com.example.taskManager.controller;

import com.example.taskManager.dto.TaskDto;
import com.example.taskManager.entity.TaskEntity;
import com.example.taskManager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    @Autowired
    private TaskService taskService;

    @GetMapping("")
    public ResponseEntity<List<TaskEntity>> getTasks() {
        List<TaskEntity> tasks =  taskService.getTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskEntity> getTask(@PathVariable("id") int id) {
        TaskEntity task =  taskService.getTaskById(id);
        if (task == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);
    }

    @PostMapping ("")
    public ResponseEntity<TaskEntity> addTask(@RequestBody TaskDto taskDto) {

        TaskEntity task = taskService.addTask(taskDto.getTitle(), taskDto.getDescription());

        return ResponseEntity.ok(task);
    }

}
