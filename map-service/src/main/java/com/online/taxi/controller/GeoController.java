package com.online.taxi.controller;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.dto.map.request.GeoRequest;
import com.online.taxi.service.GeoService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 高德地图：逆地理位置
 *
 * @author dongjb
 * @date 2018/8/20
 */
@RestController
@RequestMapping("geo")
@RequiredArgsConstructor
public class GeoController {

    @NonNull
    private final GeoService geoService;

    @GetMapping("/cityCode")
    public ResponseResult dispatch(GeoRequest geoRequest) {
        return geoService.getCityCode(geoRequest);
    }
}
