package com.online.taxi.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import com.online.taxi.entity.*;
import com.online.taxi.mapper.*;
import com.online.taxi.util.ServiceAddress;

import java.util.Calendar;
import java.util.List;

/**
 * 派单配置
 *
 * @author dongjb
 * @date 2021/04/15
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ConfigService {
    @NonNull
    private final CarDispatchDistributeSetMapper carDispatchDistributeSetMapper;
    @NonNull
    private final CarDispatchDirectRouteOrderRadiusSetMapper carDispatchDirectRouteOrderRadiusSetMapper;
    @NonNull
    private final CarDispatchDistributeIntervalSetMapper carDispatchDistributeIntervalSetMapper;
    @NonNull
    private final CarDispatchCapacitySetMapper carDispatchCapacitySetMapper;
    @NonNull
    private final CarDispatchTimeThresholdSetMapper carDispatchTimeThresholdSetMapper;
    @NonNull
    private final CarDispatchDistributeRadiusSetMapper carDispatchDistributeRadiusSetMapper;
    @NonNull
    private final CarDispatchSpecialPeriodSetMapper carDispatchSpecialPeriodSetMapper;
    @NonNull
    private final ServiceAddress serviceAddress;

    public String mapServiceUrl() {
        return serviceAddress.get("map");
    }

    public String messageServiceUrl() {
        return serviceAddress.get("message");
    }

    public String fileServiceUrl() {
        return serviceAddress.get("file");
    }

    public String orderServiceUrl() {
        return serviceAddress.get("order");
    }

    public Integer getGoHomeDistance(String cityCode, int serviceTypeId, int type) {
        CarDispatchDirectRouteOrderRadiusSet carDispatchDirectRouteOrderRadiusSet = carDispatchDirectRouteOrderRadiusSetMapper.getCarDispatchDirectRouteOrderRadiusSet(cityCode, serviceTypeId, type);
        if (carDispatchDirectRouteOrderRadiusSet != null) {
            return carDispatchDirectRouteOrderRadiusSet.getDirectRouteOrderRadius();
        }
        return null;
    }

    public CarDispatchCapacitySet getCarDispatchCapacitySet(String cityCode, int timeType) {
        return carDispatchCapacitySetMapper.getCarDispatchCapacitySet(cityCode, timeType);
    }

    public List<CarDispatchCapacitySet> getCarDispatchCapacitySetList(String cityCode) {
        return carDispatchCapacitySetMapper.getCarDispatchCapacitySetList(cityCode);
    }

    public CarDispatchDistributeRadiusSet getCarDispatchDistributeRadiusSet(String cityCode, int serviceTypeId) {
        return carDispatchDistributeRadiusSetMapper.getCarDispatchDistributeRadiusSet(cityCode, serviceTypeId);
    }

    public CarDispatchDirectRouteOrderRadiusSet getCarDispatchDirectRouteOrderRadiusSet(String cityCode, int serviceTypeId, int type) {
        return carDispatchDirectRouteOrderRadiusSetMapper.getCarDispatchDirectRouteOrderRadiusSet(cityCode, serviceTypeId, type);
    }

    public CarDispatchDistributeIntervalSet getCarDispatchDistributeIntervalSet(String cityCode, int serviceTypeId) {
        return carDispatchDistributeIntervalSetMapper.selectByCityCodeAndServiceType(cityCode, serviceTypeId);
    }

    public boolean isOpenForceSendOrder(String city) {
        CarDispatchDistributeSet carDispatchDistributeSet = carDispatchDistributeSetMapper.getOpenedByCityCode(city);
        return null != carDispatchDistributeSet;
    }

    public boolean isSpecial(String cityCode, int serviceCode, long time) {
        CarDispatchSpecialPeriodSet carDispatchSpecialPeriodSet = carDispatchSpecialPeriodSetMapper.getByCityCode(cityCode, serviceCode);
        if (carDispatchSpecialPeriodSet == null) {
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        JSONArray array = JSONArray.fromObject(carDispatchSpecialPeriodSet.getTimePeriod());
        for (int i = 0; i < array.size(); i++) {
            JSONObject o = array.getJSONObject(i);
            String start = o.getString("start");
            String end = o.getString("end");
            if (isInTimePeriod(hour, minute, start, end)) {
                return true;
            }
        }
        return false;
    }

    public boolean isInTimePeriod(int hour, int minute, String start, String end) {
        double t = Double.parseDouble(hour + "." + minute);
        double s = Double.parseDouble(start.replace(":", "."));
        double e = Double.parseDouble(end.replace(":", "."));
        return t >= s && t <= e;
    }

    public int getForceSendOrderTime(String cityCode, int type) {
        CarDispatchTimeThresholdSet carDispatchTimeThresholdSet = carDispatchTimeThresholdSetMapper.selectByCityAndServiceType(cityCode, type);
        return carDispatchTimeThresholdSet.getTimeThreshold();
    }

}
