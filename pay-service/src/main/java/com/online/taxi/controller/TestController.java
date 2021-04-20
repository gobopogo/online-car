package com.online.taxi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付测试
 *
 * @author dongjb
 * @date 2021/04/19
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {

        return "pay success";
    }
}