package com.online.taxi.schedule;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.online.taxi.context.TaskStore;
import com.online.taxi.task.ITask;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 派单定时任务
 *
 * @author dongjb
 * @date 2021/04/22
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class TaskSchedule {
    @NonNull
    private final TaskStore taskStore;
    @NonNull
    private final TaskManager taskManager;

    /**
     * 每5秒执行一次
     */
    @Scheduled(cron = "0/5 * *  * * ? ")
    public void schedule() {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.info(sdf.format(new Date()) + "*********任务每5秒执行一次进入测试");
        List<ITask> tasks = taskStore.getNeedRetryTask();
        tasks.forEach(taskManager::retry);
    }
}
