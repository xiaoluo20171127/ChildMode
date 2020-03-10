package com.swaiotos.launcher.kidsmode.common.spconfig;

import java.util.Map;

/**
 * Created by lu on 2017/10/23.
 */

public interface SPConfig {
    void put(String key, String value);

    String get(String key, String defaultValue);

    void remove(String key);

    Map<String, ?> getALL();

    void clear();
}
