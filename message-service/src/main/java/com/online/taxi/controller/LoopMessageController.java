package com.online.taxi.controller;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.dto.push.PushLoopBatchRequest;
import com.online.taxi.dto.push.PushLoopMessageDto;
import com.online.taxi.entity.PushLoopMessage;
import com.online.taxi.service.PushLoopService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 获取消息
 *
 * @author dongjb
 * @date 2021/04/19
 */
@RestController
@RequestMapping("/loop")
@RequiredArgsConstructor
public class LoopMessageController {

    @NonNull
    private final PushLoopService pushLoopService;

    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public ResponseResult<?> message(@RequestBody PushLoopMessage pushLoopMessage) {

        pushLoopService.insert(pushLoopMessage);
        return ResponseResult.success("");
    }

    @RequestMapping(value = "/message/{acceptIdentity}/{acceptId}", method = RequestMethod.GET)
    public ResponseResult<?> getMessage(@PathVariable("acceptIdentity") Integer acceptIdentity, @PathVariable("acceptId") String acceptId) {

        List<PushLoopMessageDto> list = pushLoopService.selectUnreadMessageListByIdentityAndAcceptId(acceptIdentity, acceptId);
        return ResponseResult.success(list);
    }

    @RequestMapping(value = "/batch/message", method = RequestMethod.POST)
    public ResponseResult<?> batcgMessage(@RequestBody PushLoopBatchRequest pushLoopBatchRequest) {

        pushLoopService.insertBatch(pushLoopBatchRequest);
        return ResponseResult.success("");
    }
}
