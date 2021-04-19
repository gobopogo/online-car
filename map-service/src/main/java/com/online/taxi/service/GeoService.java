package com.online.taxi.service;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.dto.map.Geo;
import com.online.taxi.dto.map.request.GeoRequest;

/**
 * 逆地理位置服务
 *
 * @author dongjb
 * @date 2021/04/15
 */
public interface GeoService {

    ResponseResult<Geo> getCityCode(GeoRequest geoRequest);

}
