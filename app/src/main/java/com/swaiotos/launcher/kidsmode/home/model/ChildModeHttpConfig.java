package com.swaiotos.launcher.kidsmode.home.model;

import android.util.Log;

import com.alibaba.fastjson.JSONObject;
import com.swaiotos.SwaiotOS;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: ChildModeHttpConfig
 * @Author: AwenZeng
 * @CreateDate: 2019/12/20 15:05
 * @Description: 应用Http配置
 */
public class ChildModeHttpConfig {

    public static final String APPSTORE_SERVER = "APPSTORE_SERVER";

    public static String getServerUrl() {
        return "http://tc.skysrt.com/";
    }

    public static String getSign(Map<String, String> map) {
        String sign = sign(map, "");
        Log.d("sign", "sign:" + sign);
        return sign;
    }

    public static Map<String, String> getBaseUrlParams() {
        Map<String, String> map = new HashMap<>();
        map.put("appkey", "");
        map.put("time", String.valueOf(System.currentTimeMillis() / 1000));
        map.put("uid", "");
        map.put("ak", "");
        map.put("vuid", "");
        return map;
    }

    private static String sign(Map<String, String> map, String secret) {
        List<String> keys = new ArrayList<String>(map.keySet());
        Collections.sort(keys);

        String temStr = "";
        for (String key : keys) {
            temStr += key + map.get(key);
        }
        Log.d("sign", " temStr:" + temStr);
        String mysign = "";
        try {
//            mysign = Md5.getMd5(temStr + secret);
        } catch (Exception e) {

        }
        Log.d("sign", " mysign:" + mysign);
        return mysign;
    }

    public static final HeaderLoader headLoader = new HeaderLoader();

    public static class HeaderLoader {
        private Map<String, String> headerMap = null;

        private Map<String, String> loadHeader() {
            try {
                headerMap = new HashMap<>();
                headerMap.put("Content-Type", "application/x-www-form-urlencoded");
                headerMap.put("cOpenId", SwaiotOS.getOS().getUserServiceManager().getOpenId());
                headerMap.put("MAC", SwaiotOS.getOS().getDeviceServiceManager().getMac());
                headerMap.put("cModel", SwaiotOS.getOS().getDeviceServiceManager().getModel());
                headerMap.put("cChip", SwaiotOS.getOS().getDeviceServiceManager().getChip());
                headerMap.put("cResolution", SwaiotOS.getOS().getDeviceServiceManager().getScreenSize());
                headerMap.put("cTcVersion", SwaiotOS.getOS().getDeviceServiceManager().getVersion());
                headerMap.put("aSdk", android.os.Build.VERSION.SDK);
                Log.e("OkHttp", JSONObject.toJSONString(headerMap));
            } catch (Exception e) {
            }
            return headerMap;
        }

        public synchronized Map<String, String> getHeader() {
            if (headerMap == null || headerMap.size() < 1) {
                return loadHeader();
            }
            return headerMap;
        }

        public synchronized void updateHeader() {
            headerMap = null;
            getHeader();
        }
    }

}
