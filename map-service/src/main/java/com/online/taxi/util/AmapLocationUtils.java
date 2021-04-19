package com.online.taxi.util;

/**
 * 位置工具
 *
 * @author dongjb
 * @date 2021/04/15
 */
public class AmapLocationUtils {

    public static String getLongitude(String location) {
        String[] locationArray = location.split(",");
        return locationArray[0];
    }

    public static String getLatitude(String location) {
        String[] locationArray = location.split(",");
        return locationArray[1];
    }
}
