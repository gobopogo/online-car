package com.online.taxi.controller;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.dto.SmsSendRequest;
import com.online.taxi.dto.sms.SmsRequest;
import com.online.taxi.service.HxSmsService;
import com.online.taxi.service.SmsService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 短信控制器
 *
 * @author dongjb
 * @date 2021/04/18
 */
@RestController
@RequestMapping("/sms")
@RequiredArgsConstructor
public class SmsController {

    @NonNull
    private final SmsService smsService;

    @NonNull
    private final HxSmsService hxSmsService;

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public ResponseResult<?> send(@RequestBody SmsSendRequest smsSendRequest) {
        smsService.sendSms(smsSendRequest);
        return ResponseResult.success("");
    }

    @PostMapping("/hx_send")
    public ResponseResult<?> hxSend(@RequestBody SmsRequest smsRequest) {
        return hxSmsService.sendSms(smsRequest);
    }
}
