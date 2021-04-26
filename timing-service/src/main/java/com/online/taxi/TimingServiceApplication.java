package com.online.taxi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 定时任务主程序
 *
 * @author dongjb
 * @date 2021/04/20
 */
@SpringBootApplication
@EnableAsync
@EnableScheduling
@MapperScan("com.online.taxi.mapper")
public class TimingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimingServiceApplication.class, args);
    }
}
