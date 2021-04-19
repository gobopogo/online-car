package com.online.taxi.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 *
 * @author dongjb
 * @date 2021/04/15
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class TestController {

    @RequestMapping("/test")
    public String test() {
        return "map success";
    }
}
