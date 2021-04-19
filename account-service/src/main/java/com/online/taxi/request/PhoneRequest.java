package com.online.taxi.request;

import lombok.Data;

import java.util.List;

import com.online.taxi.dto.phone.PhoneInfoView;

/**
 * 手机申请
 *
 * @author dongjb
 * @date 2021/04/14
 **/
@Data
public class PhoneRequest {

    private Integer idType;

    private List<PhoneInfoView> infoList;

}
