package com.online.taxi.dto.push;

import lombok.Data;

/**
 * 读取消息Dto
 *
 * @author dongjb
 * @date 2021/04/19
 */
@Data
public class PushLoopMessageDto {

    private Integer id;

    private Integer messageType;

    private String messageBody;

}
