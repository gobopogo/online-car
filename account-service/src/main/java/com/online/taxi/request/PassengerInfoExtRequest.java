package com.online.taxi.request;

import lombok.Data;

/**
 * 乘客额外信息
 *
 * @author dongjb
 * @date 2021/04/14
 */
@Data
public class PassengerInfoExtRequest {

    private Integer id;

    private Integer isContact;

    private Integer isShare;

    private String sharingTime;
}
