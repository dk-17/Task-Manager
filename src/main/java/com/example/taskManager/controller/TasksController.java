package com.example.taskManager.controller;

import com.example.taskManager.dto.ErrorDTO;
import com.example.taskManager.dto.TaskDTO;
import com.example.taskManager.dto.UpdateTaskDTO;
import com.example.taskManager.entity.TaskEntity;
import com.example.taskManager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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
    public ResponseEntity<TaskEntity> addTask(@RequestBody TaskDTO taskDto) throws ParseException {

        TaskEntity task = taskService.addTask(taskDto.getTitle(), taskDto.getDescription(), taskDto.getDeadLine());

        return ResponseEntity.ok(task);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TaskEntity> updateTask(@PathVariable("id") int id, @RequestBody UpdateTaskDTO updateTaskDTO){
        TaskEntity task = taskService.updateTask(id, updateTaskDTO.getDescription(), updateTaskDTO.getCompleted());
        if(task == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(task);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleErrors(Exception e) {

        if (e instanceof ParseException) {
            return ResponseEntity.badRequest().body(new ErrorDTO("Invalid date format"));
        }

        e.printStackTrace(); // --> When an exception is caught in a catch block,
        // calling e.printStackTrace() will output information about the exception to the console.
        // It displays the exception's type, message, and the sequence of method calls (stack trace) that led to the exception being thrown.
        return ResponseEntity.internalServerError().body(new ErrorDTO("Internal server error"));
    }

}
