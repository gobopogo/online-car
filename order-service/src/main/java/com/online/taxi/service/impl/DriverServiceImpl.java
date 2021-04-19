package com.online.taxi.service.impl;

import com.online.taxi.entity.DriverInfo;
import com.online.taxi.mapper.DriverInfoMapper;
import com.online.taxi.service.DriverService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 司机服务
 *
 * @author dongjb
 * @date 2021/04/16
 */
@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {

    @NonNull
    private final DriverInfoMapper driverInfoMapper;

    @Override
    public List<DriverInfo> selectDriverList() {
        return driverInfoMapper.selectDriverInfoList();
    }
}
