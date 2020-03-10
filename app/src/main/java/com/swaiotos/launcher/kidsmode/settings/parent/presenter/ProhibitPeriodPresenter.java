package com.swaiotos.launcher.kidsmode.settings.parent.presenter;

import android.text.TextUtils;

import com.swaiotos.common.config.ConfigFactory;
import com.swaiotos.common.log.Logger;
import com.swaiotos.launcher.kidsmode.settings.parent.model.ParentSettingsConfig;
import com.swaiotos.launcher.kidsmode.settings.parent.view.ProhibitPeriodActivity;

import java.lang.ref.WeakReference;

import static com.swaiotos.launcher.kidsmode.settings.parent.model.ParentSettingsConfig.DEFAULT_HOUR;
import static com.swaiotos.launcher.kidsmode.settings.parent.model.ParentSettingsConfig.DEFAULT_MIN;

/**
 * @ClassName: ProhibitPeriodPresenter
 * @Author: zhangjianfei
 * @CreateDate: 2020-02-05 16:56
 * @Description: 禁止使用时间Presenter
 */
public class ProhibitPeriodPresenter {

    private WeakReference<ProhibitPeriodActivity> mActivity;

    private static final int TEN = 10;
    private static final String TAG = ProhibitPeriodPresenter.class.getName();

    public ProhibitPeriodPresenter (ProhibitPeriodActivity activity) {

        this.mActivity = new WeakReference<>(activity);
    }

    /**
     * 开始时间的小时数 自增1
     *
     * @param text
     */
    public void increaseStartHour (CharSequence text) {

        if (null == mActivity.get()) {
            Logger.e(TAG, "calling increaseStartHour, activity is null");
            return;
        }

        try {
            int currentHour = parseIntFromString(text.toString());
            int newHour = increaseHourAndGet(currentHour);
            String newHourStr = getStringWithPreZero(newHour);
            mActivity.get().updateStartHourUi(newHourStr);

        } catch (NumberFormatException | NullPointerException e) {
            Logger.d(TAG, "Exception: " + e.toString());
            e.printStackTrace();
            mActivity.get().updateStartHourUi(DEFAULT_HOUR);
        }
    }

    /**
     * 开始时间的小时数 自减1
     *
     * @param text
     */
    public void decreaseStartHour (CharSequence text) {

        if (null == mActivity.get()) {
            Logger.e(TAG, "calling decreaseStartHour, activity is null");
            return;
        }

        try {
            int currentHour = parseIntFromString(text.toString());
            int newHour = decreaseHourAndGet(currentHour);
            String newHourStr = getStringWithPreZero(newHour);
            mActivity.get().updateStartHourUi(newHourStr);

        } catch (NumberFormatException | NullPointerException e) {
            Logger.d(TAG, "Exception: " + e.toString());
            e.printStackTrace();
            mActivity.get().updateStartHourUi(DEFAULT_HOUR);
        }
    }

    /**
     * 开始时间的分钟数 自增1
     *
     * @param text
     */
    public void increaseStartMin (CharSequence text) {

        if (null == mActivity.get()) {
            Logger.e(TAG, "calling increaseStartMin, activity is null");
            return;
        }

        try {
            int currentMin = parseIntFromString(text.toString());
            int newMin = increaseMinAndGet(currentMin);
            String newMinStr = getStringWithPreZero(newMin);
            mActivity.get().updateStartMinUi(newMinStr);

        } catch (NumberFormatException | NullPointerException e) {
            Logger.d(TAG, "Exception: " + e.toString());
            e.printStackTrace();
            mActivity.get().updateStartMinUi(DEFAULT_MIN);
        }
    }

    /**
     * 开始时间的分钟数 自减1
     *
     * @param text
     */
    public void decreaseStartMin (CharSequence text) {

        if (null == mActivity.get()) {
            Logger.e(TAG, "calling decreaseStartMin, activity is null");
            return;
        }

        try {
            int currentMin = parseIntFromString(text.toString());
            int newMin = decreaseMinAndGet(currentMin);
            String newMinStr = getStringWithPreZero(newMin);
            mActivity.get().updateStartMinUi(newMinStr);

        } catch (NumberFormatException | NullPointerException e) {
            Logger.d(TAG, "Exception: " + e.toString());
            e.printStackTrace();
            mActivity.get().updateStartMinUi(DEFAULT_MIN);
        }
    }

    /**
     * 结束时间的小时数 自增1
     *
     * @param text
     */
    public void increaseEndHour (CharSequence text) {

        if (null == mActivity.get()) {
            Logger.e(TAG, "calling increaseEndHour, activity is null");
            return;
        }

        try {
            int currentHour = parseIntFromString(text.toString());
            int newHour = increaseHourAndGet(currentHour);
            String newHourStr = getStringWithPreZero(newHour);
            mActivity.get().updateEndHourUi(newHourStr);

        } catch (NumberFormatException | NullPointerException e) {
            Logger.d(TAG, "Exception: " + e.toString());
            e.printStackTrace();
            mActivity.get().updateEndHourUi(DEFAULT_HOUR);
        }
    }

    /**
     * 结束时间的小时数 自减1
     *
     * @param text
     */
    public void decreaseEndHour (CharSequence text) {

        if (null == mActivity.get()) {
            Logger.e(TAG, "calling decreaseEndHour, activity is null");
            return;
        }

        try {
            int currentHour = parseIntFromString(text.toString());
            int newHour = decreaseHourAndGet(currentHour);
            String newHourStr = getStringWithPreZero(newHour);
            mActivity.get().updateEndHourUi(newHourStr);

        } catch (NumberFormatException | NullPointerException e) {
            Logger.d(TAG, "Exception: " + e.toString());
            e.printStackTrace();
            mActivity.get().updateEndHourUi(DEFAULT_HOUR);
        }
    }

    /**
     * 结束时间的分钟数 自增1
     *
     * @param text
     */
    public void increaseEndMin (CharSequence text) {

        if (null == mActivity.get()) {
            Logger.e(TAG, "calling increaseEndMin, activity is null");
            return;
        }

        try {
            int currentMin = parseIntFromString(text.toString());
            int newMin = increaseMinAndGet(currentMin);
            String newMinStr = getStringWithPreZero(newMin);
            mActivity.get().updateEndMinUi(newMinStr);

        } catch (NumberFormatException | NullPointerException e) {
            Logger.d(TAG, "Exception: " + e.toString());
            e.printStackTrace();
            mActivity.get().updateEndMinUi(DEFAULT_MIN);
        }
    }

    /**
     * 结束时间的分钟数 自减1
     *
     * @param text
     */
    public void decreaseEndMin (CharSequence text) {

        if (null == mActivity.get()) {
            Logger.e(TAG, "calling decreaseEndMin, activity is null");
            return;
        }

        try {
            int currentMin = parseIntFromString(text.toString());
            int newMin = decreaseMinAndGet(currentMin);
            String newMinStr = getStringWithPreZero(newMin);
            mActivity.get().updateEndMinUi(newMinStr);

        } catch (NumberFormatException | NullPointerException e) {
            Logger.d(TAG, "Exception: " + e.toString());
            e.printStackTrace();
            mActivity.get().updateEndMinUi(DEFAULT_MIN);
        }
    }

    public String getCachedStartHour () {

        if (null == mActivity.get()) {
            Logger.e(TAG, "calling getCachedStartHour, activity is null");
            return DEFAULT_HOUR;
        }

        return ConfigFactory.get(mActivity.get().getApplicationContext(),
                                 ParentSettingsConfig.CONFIG_NAME_SP)
                            .get(ParentSettingsConfig.KEY_PROHIBIT_PERIOD_START_HOUR, DEFAULT_HOUR);
    }

    public String getCachedStartMin () {

        if (null == mActivity.get()) {
            Logger.e(TAG, "calling getCachedStartMin, activity is null");
            return DEFAULT_MIN;
        }

        return ConfigFactory.get(mActivity.get().getApplicationContext(),
                                 ParentSettingsConfig.CONFIG_NAME_SP)
                            .get(ParentSettingsConfig.KEY_PROHIBIT_PERIOD_START_MIN, DEFAULT_MIN);
    }


    public String getCachedEndHour () {

        if (null == mActivity.get()) {
            Logger.e(TAG, "calling getCachedEndHour, activity is null");
            return DEFAULT_HOUR;
        }

        return ConfigFactory.get(mActivity.get().getApplicationContext(),
                                 ParentSettingsConfig.CONFIG_NAME_SP)
                            .get(ParentSettingsConfig.KEY_PROHIBIT_PERIOD_END_HOUR, DEFAULT_HOUR);
    }


    public String getCachedEndMin () {

        if (null == mActivity.get()) {
            Logger.e(TAG, "calling getCachedEndMin, activity is null");
            return DEFAULT_MIN;
        }

        return ConfigFactory.get(mActivity.get().getApplicationContext(),
                                 ParentSettingsConfig.CONFIG_NAME_SP)
                            .get(ParentSettingsConfig.KEY_PROHIBIT_PERIOD_END_MIN, DEFAULT_MIN);
    }


    /**
     * 不限制时间使用段
     */
    public void setNoTimeLimit () {

        resetTime();
        if (mActivity.get() != null) {
            mActivity.get().finish();
        }
    }

    public void resetTime () {

        if (null == mActivity.get()) {
            Logger.e(TAG, "calling resetTime, activity is null");
            return;
        }

        mActivity.get().updateStartHourUi(DEFAULT_HOUR);
        mActivity.get().updateStartMinUi(DEFAULT_MIN);
        mActivity.get().updateEndHourUi(DEFAULT_HOUR);
        mActivity.get().updateEndMinUi(DEFAULT_MIN);
    }

    public boolean cacheProhibitPeriod (String startHour, String startMin, String endHour, String endMin) {

        if (null == mActivity.get()) {
            Logger.e(TAG, "calling cacheProhibitPeriod, activity is null");
            return false;
        }

        ConfigFactory.get(mActivity.get().getApplicationContext(), ParentSettingsConfig.CONFIG_NAME_SP)
                     .put(ParentSettingsConfig.KEY_PROHIBIT_PERIOD_START_HOUR, startHour);
        ConfigFactory.get(mActivity.get().getApplicationContext(), ParentSettingsConfig.CONFIG_NAME_SP)
                     .put(ParentSettingsConfig.KEY_PROHIBIT_PERIOD_START_MIN, startMin);
        ConfigFactory.get(mActivity.get().getApplicationContext(), ParentSettingsConfig.CONFIG_NAME_SP)
                     .put(ParentSettingsConfig.KEY_PROHIBIT_PERIOD_END_HOUR, endHour);
        ConfigFactory.get(mActivity.get().getApplicationContext(), ParentSettingsConfig.CONFIG_NAME_SP)
                     .put(ParentSettingsConfig.KEY_PROHIBIT_PERIOD_END_MIN, endMin);
        return true;
    }

    /**
     * 返回设置的toast提示, 如：
     * 禁止使用时间为: "禁止使用"
     * @param startHour
     * @param startMin
     * @param endHour
     * @param endMin
     * @return
     */
    public String getToastMessage (String startHour, String startMin, String endHour, String endMin) {
        int startH;
        int startM;
        int endH;
        int endM;

        try {
            startH = parseIntFromString(startHour);
            startM = parseIntFromString(startMin);
            endH = parseIntFromString(endHour);
            endM = parseIntFromString(endMin);
        } catch (NumberFormatException e) {
            return "数据异常";
        }

        //未设置时间
        if (startH == endH && startM == endM) {
            return "未设置禁止使用时间";
        }

        StringBuilder builder = new StringBuilder();

        //开始时间 小于 结束时间
        if (startH < endH || (startH == endH && startM < endM) ) {
            builder.append("儿童模式的禁止使用时间为:\n");
            builder.append("每日");
            builder.append(startH);
            builder.append("时");
            builder.append(startM);
            builder.append("分");
            builder.append(" 到 ");
            builder.append(endH);
            builder.append("时");
            builder.append(endM);
            builder.append("分");
            return builder.toString();
        }

        //开始时间 大于 结束时间
        builder.append("儿童模式的禁止使用时间为:\n");
        builder.append("每日");
        builder.append(startH);
        builder.append("时");
        builder.append(startM);
        builder.append("分");
        builder.append(" 到次日 ");
        builder.append(endH);
        builder.append("时");
        builder.append(endM);
        builder.append("分");

        return builder.toString();
    }

    private static final int FIRST_HOUR = 0;
    private static final int LAST_HOUR = 23;
    private static final int FIRST_MIN = 0;
    private static final int LAST_MIN = 59;

    /**
     * 小时数自增1 并返回
     *
     * @param hour
     * @return
     */
    private int increaseHourAndGet (int hour) {

        if (hour == LAST_HOUR) {
            return FIRST_HOUR;
        }
        return ++hour;
    }

    /**
     * 小时数自减1 并返回
     *
     * @param hour
     * @return
     */
    private int decreaseHourAndGet (int hour) {

        if (hour == FIRST_HOUR) {
            return LAST_HOUR;
        }

        return --hour;
    }

    /**
     * 分钟数自增1 并返回
     *
     * @param min
     * @return
     */
    private int increaseMinAndGet (int min) {

        if (min == LAST_MIN) {
            return FIRST_MIN;
        }

        return ++min;
    }

    /**
     * 分钟数自减1 并返回
     *
     * @param min
     * @return
     */
    private int decreaseMinAndGet (int min) {

        if (min == FIRST_MIN) {
            return LAST_MIN;
        }
        return --min;
    }

    private int parseIntFromString (String number) throws NumberFormatException {

        if (TextUtils.isEmpty(number)) {
            throw new NumberFormatException("text is empty");
        }

        return Integer.parseInt(number);
    }

    /**
     * 如果小于10 添加前缀0返回: 0~9 ==> "00" ~ "09"
     * 如果大于10， 则返回对应的字符串类型数据 10 ==> "10"
     *
     * @param integer
     * @return
     */
    private String getStringWithPreZero (int integer) {

        if (integer < TEN) {
            return "0" + integer;
        }

        return "" + integer;
    }
}
