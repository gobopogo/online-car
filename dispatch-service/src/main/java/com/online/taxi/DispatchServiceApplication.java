package com.online.taxi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 派单主程序
 *
 * @author dongjb
 * @date 2021/04/15
 */
@SpringBootApplication
@EnableAsync
@EnableScheduling
public class DispatchServiceApplication {

    public static void main(String... args) {
        SpringApplication.run(DispatchServiceApplication.class, args);
    }

}
