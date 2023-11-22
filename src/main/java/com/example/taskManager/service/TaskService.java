package com.example.taskManager.service;

import com.example.taskManager.entity.TaskEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

@Service
public class TaskService {

    private int taskId = 1;

    private SimpleDateFormat deadLineFormate = new SimpleDateFormat("yyyy-mm-dd");

    private ArrayList<TaskEntity> tasks = new ArrayList<>();

    public TaskEntity addTask(String title, String description, String deadLine) throws ParseException {
        TaskEntity task = new TaskEntity();
        task.setId(taskId);
        task.setTitle(title);
        task.setDescription(description);
        task.setDeadLine(deadLineFormate.parse(deadLine));
        task.setCompleted(false);

        tasks.add(task);
        taskId++;

        return task;
    }

    public ArrayList<TaskEntity> getTasks() {
        return tasks;
    }

    public TaskEntity getTaskById(int id) {
        return tasks.stream().findAny()
                .filter(taskEntity -> taskEntity.getId() == id).orElse(null);
/*
        for(TaskEntity task : tasks) {
            if(task.getId() == id) {
                return task;
            }
        }

        return null;

 */
    }

    public TaskEntity updateTask(int id, String description, boolean completed) {
        TaskEntity task = getTaskById(id);
        if (task == null) {
            return null;
        }

        if (task.getDescription() != null) {
            task.setDescription(description);
        }
        // not able to check for task.getCompleted() function??? because in taskEntity its type was boolean which is primitive, we cannot change primitive data type;
        task.setCompleted(completed);

        return task;
    }
}
