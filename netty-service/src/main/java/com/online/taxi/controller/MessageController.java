package com.online.taxi.controller;

import com.online.taxi.context.ServerContext;
import com.online.taxi.message.Message;
import com.online.taxi.proto.MessageProto;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * netty服务
 *
 * @author dongjb
 * @date 2021/04/26
 */
@RestController
@Slf4j
@RequiredArgsConstructor
public class MessageController {
    @NonNull
    private final ServerContext serverContext;

    @ResponseBody
    @RequestMapping(value = "/test", produces = "application/json; charset=utf-8")
    public String test(@RequestBody Message message) {
        MessageProto.RequestProto.Builder b = MessageProto.RequestProto.newBuilder();
        b.setCode(1);
        b.setMessage(message.getContent());
        serverContext.sendAll(b.build());
        return "1";
    }
}
