package com.online.taxi.service.impl;

import com.online.taxi.constant.AmapEnum;
import com.online.taxi.constant.AmapResultConfig;
import com.online.taxi.constant.AmapUrlConfig;
import com.online.taxi.constatnt.BusinessInterfaceStatus;
import com.online.taxi.dto.ResponseResult;
import com.online.taxi.dto.map.Dispatch;
import com.online.taxi.dto.map.Vehicle;
import com.online.taxi.dto.map.request.DispatchRequest;
import com.online.taxi.entity.AmapResult;
import com.online.taxi.service.DispatchService;
import com.online.taxi.util.AmapLocationUtils;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * 调度车辆服务
 *
 * @author dongjb
 * @date 2021/04/15
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class DispatchServiceImpl implements DispatchService {

    @Value("${amap.key}")
    private String amapKey;

    @NonNull
    private final RestTemplate restTemplate;

    @Override
    public ResponseResult dispatch(DispatchRequest dispatchRequest) {

        StringBuilder urlBuild = new StringBuilder();
        urlBuild.append(AmapUrlConfig.DISPATCH_URL);
        urlBuild.append("?key=").append(amapKey);
        urlBuild.append("&orderID=").append(dispatchRequest.getOrderId());
        urlBuild.append("&amapOID=");
        urlBuild.append("&customerDeviceID=").append(dispatchRequest.getCustomerDeviceId());
        urlBuild.append("&orderType=1");
        // + dispatchRequest.getVehicleType()
        urlBuild.append("&vehicleType=2");
        urlBuild.append("&orderCity=").append(dispatchRequest.getOrderCity());
        urlBuild.append("&orderTime=").append(dispatchRequest.getOrderTime() / 1000);
        urlBuild.append("&startTime=").append(dispatchRequest.getStartTime() / 1000);
        String startName = dispatchRequest.getStartName().replaceAll(" ", "");
        urlBuild.append("&startName=").append(startName);
        urlBuild.append("&start=").append(dispatchRequest.getStartLongitude()).append(",").append(dispatchRequest.getStartLatitude());
        String endName = dispatchRequest.getEndName().replaceAll(" ", "");
        urlBuild.append("&endName=").append(endName);
        urlBuild.append("&end=").append(dispatchRequest.getEndLongitude()).append(",").append(dispatchRequest.getEndLatitude());
        urlBuild.append("&radius=").append(dispatchRequest.getRadius());
        urlBuild.append("&maxCount=").append(dispatchRequest.getMaxCount());

        String url = urlBuild.toString();

        log.info("高德地图：调度车辆请求信息：" + url);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        log.info("高德地图：调度车辆返回信息：" + responseEntity.getBody());

        AmapResult<Dispatch> amapResult = parseResponseEntity(responseEntity);
        if (amapResult.getStatus() == AmapEnum.OK.getCode()) {

            return ResponseResult.success(amapResult.getData());
        } else {
            return ResponseResult.fail(BusinessInterfaceStatus.FAIL.getCode(), BusinessInterfaceStatus.FAIL.getValue());
        }
    }

    private AmapResult<Dispatch> parseResponseEntity(ResponseEntity<String> responseEntity) {
        AmapResult<Dispatch> response = new AmapResult<>();
        try {
            String body = responseEntity.getBody();
            JSONObject result = JSONObject.fromObject(body);

            if (result.has(AmapResultConfig.AMAP_DATA)) {
                response.setStatus(AmapEnum.OK.getCode());

                Dispatch dispatch = new Dispatch();
                JSONObject data = result.getJSONObject(AmapResultConfig.AMAP_DATA);
                int count;
                String orderId;
                if (data.has(AmapResultConfig.AMAP_COUNT)) {
                    count = data.getInt(AmapResultConfig.AMAP_COUNT);
                    dispatch.setCount(count);
                }
                if (data.has(AmapResultConfig.AMAP_ORDER_ID)) {
                    orderId = data.getString(AmapResultConfig.AMAP_ORDER_ID);
                    dispatch.setOrderId(orderId);
                }
                if (data.has(AmapResultConfig.AMAP_VEHICLES)) {
                    List<Vehicle> vehiclesObj = new ArrayList<>();
                    JSONArray vehicles = data.getJSONArray(AmapResultConfig.AMAP_VEHICLES);
                    for (int i = 0; i < vehicles.size(); i++) {
                        Vehicle vehicle = new Vehicle();
                        JSONObject vehicleJson = vehicles.getJSONObject(i);
                        if (vehicleJson.has(AmapResultConfig.AMAP_LOCATION)) {
                            String locationStr = vehicleJson.getString(AmapResultConfig.AMAP_LOCATION);
                            vehicle.setLongitude(AmapLocationUtils.getLongitude(locationStr));
                            vehicle.setLatitude(AmapLocationUtils.getLatitude(locationStr));
                        }
                        if (vehicleJson.has(AmapResultConfig.AMAP_DISTANCE)) {
                            vehicle.setDistance(vehicleJson.getString(AmapResultConfig.AMAP_DISTANCE));
                        }
                        if (vehicleJson.has(AmapResultConfig.AMAP_VEHICLE_ID)) {
                            String vehicleId = vehicleJson.getString(AmapResultConfig.AMAP_VEHICLE_ID);
                            vehicle.setVehicleId(vehicleId);
                        }
                        vehiclesObj.add(vehicle);
                    }
                    dispatch.setVehicles(vehiclesObj);
                }
                response.setData(dispatch);
            }
        } catch (Exception e) {
            response.setStatus(AmapEnum.EXCEPTION.getCode());
        }
        return response;
    }

}
