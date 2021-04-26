package com.online.taxi.context;

import lombok.Data;
import org.springframework.stereotype.Component;

import com.online.taxi.task.ITask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 任务存储
 *
 * @author dongjb
 * @date 2021/04/15
 */

@Component
@Data
public class TaskStore {
    private final ConcurrentHashMap<Integer, ITask> results = new ConcurrentHashMap<>();

    public void addTask(int taskId, ITask task) {
        results.put(taskId, task);
    }

    public List<ITask> getNeedRetryTask() {
        synchronized (results) {
            List<ITask> list = new ArrayList<>(results.values());
            results.clear();
            return list;
        }
    }
}
