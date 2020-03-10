package com.swaiotos.launcher.kidsmode.settings.parent;

import android.content.Context;
import android.text.TextUtils;

import com.swaiotos.common.config.ConfigFactory;
import com.swaiotos.common.log.Logger;
import com.swaiotos.launcher.kidsmode.settings.parent.model.ParentSettingsConfig;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @ClassName: ParentSettingsUtil
 * @Author: zhangjianfei
 * @CreateDate: 2020-02-20 21:19
 * @Description: 家长设置的一些工具类
 */
public class ParentSettingsUtil {

    private static final String TAG = ParentSettingsUtil.class.getName();

    /**
     * 时间控制的开关是否开启
     * 开启 - 则可能设置了每天使用时长 或者 禁止使用时间
     * 未开启 - 所有时间都可使用
     *
     * @param context
     * @return
     */
    public static boolean isTimeControlSwitchOpen (Context context) {

        if (context == null) {
            Logger.d(TAG, "calling isTimeControlSwitchOpen, context is null");
            return false;
        }

        return TextUtils.equals(ParentSettingsConfig.VALUE_TRUE,
                                ConfigFactory.get(context, ParentSettingsConfig.CONFIG_NAME_SP)
                                             .get(ParentSettingsConfig.KEY_SETTINGS_STATE_IS_OPEN,
                                                  ParentSettingsConfig.VALUE_FALSE));
    }

    /**
     * 单签是否处于禁止使用时间段
     *
     * @param context
     * @return true: 当前处于禁止使用时间段
     * false: 当前不处于禁止使用时间段
     */
    public static boolean isNowInProhibitPeriod (Context context) {

        if (context == null) {
            Logger.d(TAG, "calling isNowInProhibitPeriod, context is null");
            return true;
        }

        if (!isTimeControlSwitchOpen(context)) {
            //设置关闭，则可用
            return false;
        }

        int startHour = Integer.parseInt(ConfigFactory.get(context,
                                                           ParentSettingsConfig.CONFIG_NAME_SP)
                                                      .get(ParentSettingsConfig.KEY_PROHIBIT_PERIOD_START_HOUR,
                                                           ParentSettingsConfig.DEFAULT_HOUR));
        int startMin = Integer.parseInt(ConfigFactory.get(context,
                                                          ParentSettingsConfig.CONFIG_NAME_SP)
                                                     .get(ParentSettingsConfig.KEY_PROHIBIT_PERIOD_START_MIN,
                                                          ParentSettingsConfig.DEFAULT_MIN));
        int endHour = Integer.parseInt(ConfigFactory.get(context,
                                                         ParentSettingsConfig.CONFIG_NAME_SP)
                                                    .get(ParentSettingsConfig.KEY_PROHIBIT_PERIOD_END_HOUR,
                                                         ParentSettingsConfig.DEFAULT_HOUR));
        int endMin = Integer.parseInt(ConfigFactory.get(context,
                                                        ParentSettingsConfig.CONFIG_NAME_SP)
                                                   .get(ParentSettingsConfig.KEY_PROHIBIT_PERIOD_END_MIN,
                                                        ParentSettingsConfig.DEFAULT_MIN));

        if (startHour == endHour && startMin == endMin) {
            //未设置禁止使用时间段
            return false;
        }

        Calendar startCalendar = new GregorianCalendar();
        startCalendar.set(Calendar.HOUR_OF_DAY, startHour);
        startCalendar.set(Calendar.MINUTE, startMin);

        Calendar endCalendar = new GregorianCalendar();
        endCalendar.set(Calendar.HOUR_OF_DAY, endHour);
        endCalendar.set(Calendar.MINUTE, endMin);

        if (startCalendar.after(endCalendar)) {
            //说明开始时间的数值比结束时间大，则范围是 开始时间 ~ 次日的结束时间
            endCalendar.add(Calendar.DAY_OF_YEAR, 1);
        }

        Calendar calendar = new GregorianCalendar();

        if (calendar.after(startCalendar) && calendar.before(endCalendar)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 返回禁止使用的时间区间
     * @param context
     * @return
     */
    public static String getProhibitPeriodStr (Context context) {

        String startHour = ConfigFactory.get(context, ParentSettingsConfig.CONFIG_NAME_SP).get(
                ParentSettingsConfig.KEY_PROHIBIT_PERIOD_START_HOUR,
                ParentSettingsConfig.DEFAULT_HOUR);
        String startMin = ConfigFactory.get(context, ParentSettingsConfig.CONFIG_NAME_SP).get(
                ParentSettingsConfig.KEY_PROHIBIT_PERIOD_START_MIN,
                ParentSettingsConfig.DEFAULT_MIN);
        String endHour = ConfigFactory.get(context, ParentSettingsConfig.CONFIG_NAME_SP).get(
                ParentSettingsConfig.KEY_PROHIBIT_PERIOD_END_HOUR,
                ParentSettingsConfig.DEFAULT_HOUR);
        String endMin = ConfigFactory.get(context, ParentSettingsConfig.CONFIG_NAME_SP).get(
                ParentSettingsConfig.KEY_PROHIBIT_PERIOD_END_MIN,
                ParentSettingsConfig.DEFAULT_MIN);

        return startHour + ":" + startMin + " - " + endHour + ":" + endMin;
    }

    /**
     * 是否还有时长剩余
     *
     * @param context
     * @return true: 还有剩余
     * false: 没有剩余了
     */
    public static boolean isLimitTimeLeft (Context context) {

        if (context == null) {
            Logger.d(TAG, "calling isLimitTimeLeft, context is null");
            return false;
        }

        if (!isTimeControlSwitchOpen(context)) {
            //设置关闭，则可用
            return true;
        }

        String limitTime = ConfigFactory.get(context, ParentSettingsConfig.CONFIG_NAME_SP).get(
                ParentSettingsConfig.KEY_TIME_LIMIT,
                ParentSettingsConfig.VALUE_TIME_LIMIT_NO_LIMIT);

        if (TextUtils.equals(limitTime, ParentSettingsConfig.VALUE_TIME_LIMIT_NO_LIMIT)) {
            //未设置时间限制
            return true;
        }

        int usedTimeMin = Integer.parseInt(ConfigFactory.get(context,
                                                             ParentSettingsConfig.CONFIG_NAME_SP)
                                                        .get(ParentSettingsConfig.KEY_TIME_USED_TODAY,
                                                             ParentSettingsConfig.DEFAULT_VALUE_TIME_USED_TODAY));
        return usedTimeMin < Integer.parseInt(limitTime);
    }

    /**
     * 增加已使用的时间
     * @param context
     * @param min
     */
    public static boolean addUsedTime(Context context, int min) {
        if (context == null) {
            Logger.d(TAG, "calling isLimitTimeLeft, context is null");
            return false;
        }

        int usedTimeMin = Integer.parseInt(ConfigFactory.get(context,
                                                             ParentSettingsConfig.CONFIG_NAME_SP)
                                                        .get(ParentSettingsConfig.KEY_TIME_USED_TODAY,
                                                             ParentSettingsConfig.DEFAULT_VALUE_TIME_USED_TODAY));
        int newTime = usedTimeMin + min;
        ConfigFactory.get(context, ParentSettingsConfig.CONFIG_NAME_SP).put(ParentSettingsConfig.KEY_TIME_USED_TODAY, "" + newTime);
        Logger.i(TAG, "record new time :" + newTime + " min");
        return true;
    }

    /**
     * 获取已设置的时长限制数据
     *
     * @return
     */
    public static String getTimeLimitValue (Context context) {

        if (context == null) {
            Logger.d(TAG, "calling getTimeLimitValue, context is null");
            return ParentSettingsConfig.TEXT_TIME_LIMIT_NO_LIMIT;
        }

        int timeLimitValue = Integer.parseInt(ConfigFactory.get(context,
                                                                ParentSettingsConfig.CONFIG_NAME_SP)
                                                           .get(ParentSettingsConfig.KEY_TIME_LIMIT,
                                                                ParentSettingsConfig.VALUE_TIME_LIMIT_NO_LIMIT));

        for (int i = 0; i < ParentSettingsConfig.TIME_LIMIT_VALUES.length; i++) {
            if (timeLimitValue == ParentSettingsConfig.TIME_LIMIT_VALUES[i]) {
                return ParentSettingsConfig.TIME_LIMIT_STRS[i];
            }
        }

        return ParentSettingsConfig.TEXT_TIME_LIMIT_NO_LIMIT;
    }

    /**
     * 检查 (如果条件允许)且重置记录的时间
     * 条件: 缓存中记录的时间，不是今天
     *
     * @param context
     * @return  true 时间已重置
     *          false 时间未重置
     */
    public static boolean checkAndResetUsedTime (Context context) {

        if (context == null) {
            Logger.d(TAG, "calling getTimeLimitValue, context is null");
            return false;
        }

        Calendar calendar  = Calendar.getInstance();
        String today = "" + calendar.get(Calendar.DAY_OF_YEAR);

        String recordDay = ConfigFactory.get(context, ParentSettingsConfig.CONFIG_NAME_SP).get(
                ParentSettingsConfig.KEY_DATE_RECORD_TIME, ParentSettingsConfig.DEFAULT_VALUE_DATE_RECORD_TIME);

        if (!TextUtils.equals(today, recordDay)) {
            //记录的日期不是今天，重置
            ConfigFactory.get(context, ParentSettingsConfig.CONFIG_NAME_SP).put(ParentSettingsConfig.KEY_DATE_RECORD_TIME, today);
            ConfigFactory.get(context, ParentSettingsConfig.CONFIG_NAME_SP).put(ParentSettingsConfig.KEY_TIME_USED_TODAY, ParentSettingsConfig.DEFAULT_VALUE_TIME_USED_TODAY);
            Logger.i(TAG, "reset record time: cause date changed");
            return true;
        } else {
            return false;
        }
    }
}
