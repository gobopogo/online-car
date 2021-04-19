package com.online.taxi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.time.Duration;

/**
 * 预估启动类
 *
 * @author dongjb
 * @date 2021/04/17
 */
@SpringBootApplication
@EnableAsync
@MapperScan("com.online.taxi.mapper")
public class ValuationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ValuationServiceApplication.class, args);
    }

}
