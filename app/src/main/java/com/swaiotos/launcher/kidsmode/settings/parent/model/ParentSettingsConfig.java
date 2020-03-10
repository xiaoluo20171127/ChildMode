package com.swaiotos.launcher.kidsmode.settings.parent.model;

/**
 * @ClassName: ParentSettingsConfig
 * @Author: zhangjianfei
 * @CreateDate: 2020-02-05 17:53
 * @Description: 家长设置中的配置信息
 */
public class ParentSettingsConfig {
    public static final String CONFIG_NAME_SP = "launcher_kids_mode_parent_settings";

    /**是否开启了家长设置的开关*/
    public static final String KEY_SETTINGS_STATE_IS_OPEN = "key_settings_state_is_open";
    public static final String VALUE_TRUE = "true";
    public static final String VALUE_FALSE = "false";

    /**全天使用时长*/
    public static final String KEY_TIME_LIMIT = "key_time_limit";
    public static final String VALUE_TIME_LIMIT_NO_LIMIT = "-1";
    public static final String TEXT_TIME_LIMIT_NO_LIMIT = "无限制";
    /**今日剩余可用时长*/
    public static final String KEY_TIME_USED_TODAY = "key_time_used_today";
    public static final String DEFAULT_VALUE_TIME_USED_TODAY = "0";

    /**记录时间的日期*/
    public static final String KEY_DATE_RECORD_TIME = "key_date_record_time";
    /**默认日期值*/
    public static final String DEFAULT_VALUE_DATE_RECORD_TIME = "";

    /**禁止使用时间*/
    public static final String DEFAULT_HOUR = "00";
    public static final String DEFAULT_MIN = "00";
    /**禁止使用时间 -- 开始的小时*/
    public static final String KEY_PROHIBIT_PERIOD_END_MIN = "key_prohibit_period_end_min";
    /**禁止使用时间 -- 开始的分钟*/
    public static final String KEY_PROHIBIT_PERIOD_START_HOUR = "key_prohibit_period_is_open";
    /**禁止使用时间 -- 结束的小时*/
    public static final String KEY_PROHIBIT_PERIOD_START_MIN = "key_prohibit_period_start_min";
    /**禁止使用时间 -- 结束的分钟*/
    public static final String KEY_PROHIBIT_PERIOD_END_HOUR = "key_prohibit_period_end_hour";

    /**全天累计使用时长限制 - 文字描述*/
    public static final String [] TIME_LIMIT_STRS = {"无限制", "30分钟", "1小时", "2小时", "3小时", "4小时", "5小时", "6小时"};
    /**全天累计使用时长限制 - 分钟数*/
    public static final int [] TIME_LIMIT_VALUES = {-1, 30, 60, 120, 180, 240, 300, 360};
}
