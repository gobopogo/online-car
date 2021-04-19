package com.online.taxi.dto.phone;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 手机信息
 *
 * @author dongjb
 * @date 2021/04/14
 **/
@Data
@Accessors(chain = true)
public class PhoneInfoView {
    private int id;

    private String phone;

    private String encrypt;

}
