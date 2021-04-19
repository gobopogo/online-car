package com.online.taxi.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.taxi.service.DriverService;

/**
 * 司机控制器
 *
 * @author dongjb
 * @date 2021/04/15
 */
@RestController
@RequestMapping("driver")
@RequiredArgsConstructor
public class DriverController {
    @NonNull
    private final DriverService driverService;
}
