package com.online.taxi.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.dto.map.Dispatch;
import com.online.taxi.dto.map.Route;
import com.online.taxi.dto.map.request.DistanceRequest;
import com.online.taxi.dto.map.request.OrderRequest;
import com.online.taxi.dto.phone.BoundPhoneDto;
import com.online.taxi.dto.push.PushLoopBatchRequest;
import com.online.taxi.dto.push.PushRequest;
import com.online.taxi.dto.sms.SmsRequest;
import com.online.taxi.entity.Order;
import com.online.taxi.request.DispatchRequest;
import com.online.taxi.request.SmsSendRequest;
import com.online.taxi.request.SmsTemplateDto;
import com.online.taxi.util.DateUtils;
import com.online.taxi.util.RestTemplateHepler;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 二方包服务
 *
 * @author dongjb
 * @date 2021/04/25
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class HttpService {
    @NonNull
    private final RestTemplate restTemplate;
    @NonNull
    private final ConfigService configService;

    public void sendSms(String phone, String smsCode, Map<String, Object> templateMap) {
        String url = configService.messageServiceUrl() + "/sms/send";
        SmsSendRequest request = new SmsSendRequest();
        String[] receivers = new String[1];
        receivers[0] = phone;
        request.setReceivers(receivers);
        List<SmsTemplateDto> list = new ArrayList<>();
        SmsTemplateDto dto = new SmsTemplateDto();
        dto.setId(smsCode);
        dto.setTemplateMap(templateMap);
        list.add(dto);
        request.setData(list);

        restTemplate.postForObject(url, request, ResponseResult.class);
    }

    public void sendSms(String phone, String smsCode, String... content) {
        String url = configService.messageServiceUrl() + "/sms/hx_send";
        SmsRequest request = new SmsRequest();
        request.setPhones(new String[]{phone});
        request.setTemplateId(smsCode);
        request.setContent(content);

        restTemplate.postForObject(url, request, ResponseResult.class);
    }

    public void updateAmapOrder(OrderRequest orderRequest) {
        String url = configService.mapServiceUrl() + "/order";
        restTemplate.postForObject(url, orderRequest, ResponseResult.class);
    }

    public ResponseResult<Dispatch> dispatch(DispatchRequest dispatchRequest) {
        String url = configService.mapServiceUrl() + "/vehicleDispatch";
        ResponseResult<Dispatch> response = restTemplate.postForObject(url, dispatchRequest, ResponseResult.class);
        try {
            Dispatch o = RestTemplateHepler.parse(response, Dispatch.class);
            return ResponseResult.success(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public double calDistance(DistanceRequest distanceRequest) {
        String url = configService.mapServiceUrl() + "/distance?";
        Map<String, Object> map = new HashMap<>(16);
        map.put("originLongitude", distanceRequest.getOriginLongitude());
        map.put("originLatitude", distanceRequest.getOriginLatitude());
        map.put("destinationLongitude", distanceRequest.getDestinationLongitude());
        map.put("destinationLatitude", distanceRequest.getDestinationLatitude());
        String param = map.keySet().stream().map(k -> k + "={" + k + "}").collect(Collectors.joining("&"));
        url = url + param;
        double distance = Integer.MAX_VALUE;
        ResponseResult<?> response = restTemplate.getForObject(url, ResponseResult.class, map);
        if (response != null && response.getData() != null) {
            try {
                log.info(response.toString());
                Route o = RestTemplateHepler.parse(response, Route.class);
                distance = o.getDistance();
            } catch (Exception e) {
                log.error("distance error " + e.getMessage());
            }
        }
        return distance;
    }

    public void unbind(String subId, String secretNo) {
        String url = configService.fileServiceUrl() + "phone/unbind?";
        Map<String, Object> map = new HashMap<>(16);
        map.put("subsId", subId);
        map.put("secretNo", secretNo);
        String param = map.keySet().stream().map(k -> k + "={" + k + "}").collect(Collectors.joining("&"));
        url = url + param;
        log.info("unbind url " + url);
        ResponseResult<?> response = restTemplate.getForObject(url, ResponseResult.class, map);
        log.info("unbind response " + response);
    }

    public BoundPhoneDto bind(String phone1, String phone2, long expireTime) {
        String url = configService.fileServiceUrl() + "/phone/bind?";
        Map<String, Object> map = new HashMap<>(16);
        map.put("driverPhone", phone1);
        map.put("passengerPhone", phone2);
        map.put("expiration", DateUtils.formatDate(new Date(expireTime), DateUtils.DEFAULT_TIME_FORMAT));
        String param = map.keySet().stream().map(k -> k + "={" + k + "}").collect(Collectors.joining("&"));
        url = url + param;
        log.info("bind " + url);
        ResponseResult<?> response = restTemplate.getForObject(url, ResponseResult.class, map);
        if (response != null && response.getData() != null) {
            log.info("bind result " + response);
            try {
                return RestTemplateHepler.parse(response, BoundPhoneDto.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public boolean updateOrder(Order order) {
        String url = configService.orderServiceUrl() + "/order/updateOrder";
        ResponseResult<?> response = restTemplate.postForObject(url, order, ResponseResult.class);
        return response != null && response.getCode() == 0;
    }

    public ResponseResult<?> pushMsg(PushRequest pushRequest) {
        String url = configService.messageServiceUrl() + "/push/message";
        return restTemplate.postForObject(url, pushRequest, ResponseResult.class);
    }

    public ResponseResult<?> loopMessage(PushLoopBatchRequest request) {
        String url = configService.messageServiceUrl() + "/loop/message";
        return restTemplate.postForObject(url, request, ResponseResult.class);
    }

    public void loopMessageBatch(PushLoopBatchRequest request) {
        String url = configService.messageServiceUrl() + "/loop/batch/message";
        restTemplate.postForObject(url, request, ResponseResult.class);
    }

}

