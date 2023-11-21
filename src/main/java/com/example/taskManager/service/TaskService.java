package com.example.taskManager.service;

import com.example.taskManager.dto.TaskDto;
import com.example.taskManager.entity.TaskEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TaskService {

    private int taskId = 1;

    private ArrayList<TaskEntity> tasks = new ArrayList<>();

    public TaskEntity addTask(String title, String description) {
        TaskEntity task = new TaskEntity();
        task.setId(taskId);
        task.setTitle(title);
        task.setDescription(description);
        task.setCompleted(false);

        tasks.add(task);
        taskId++;

        return task;
    }

    public ArrayList<TaskEntity> getTasks() {
        return tasks;
    }

    public TaskEntity getTaskById(int id) {
//        return tasks.stream().findAny()
//                .filter(taskEntity -> taskEntity.getId() == id).orElse(null);

        for(TaskEntity task : tasks) {
            if(task.getId() == id) {
                return task;
            }
        }

        return null;
    }
}
