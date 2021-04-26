package com.online.taxi.controller;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.dto.map.request.DispatchRequest;
import com.online.taxi.service.DispatchService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 调度车辆
 *
 * @author dongjb
 * @date 2021/04/15
 */
@RestController
@Slf4j
@RequiredArgsConstructor
public class DispatchController {

    @NonNull
    private final DispatchService dispatchService;

    @PostMapping("/vehicleDispatch")
    public ResponseResult<?> dispatch(@RequestBody DispatchRequest dispatchRequest) {
        return dispatchService.dispatch(dispatchRequest);
    }
}
