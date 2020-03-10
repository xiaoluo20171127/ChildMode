package com.swaiotos.launcher.kidsmode.settings.parent.presenter;

import android.text.TextUtils;

import com.swaiotos.common.config.ConfigFactory;
import com.swaiotos.common.log.Logger;
import com.swaiotos.launcher.kidsmode.settings.parent.model.ParentSettingsConfig;
import com.swaiotos.launcher.kidsmode.settings.parent.view.TimeLimitActivity;

import java.lang.ref.WeakReference;

/**
 * @ClassName: TimeLimitPresenter
 * @Author: zhangjianfei
 * @CreateDate: 2020-02-05 16:56
 * @Description: 全天使用时长Presenter
 */
public class TimeLimitPresenter {

    private static final String TAG = TimeLimitPresenter.class.getName();

    private WeakReference<TimeLimitActivity> mActivity;

    public TimeLimitPresenter (TimeLimitActivity activity) {

        this.mActivity = new WeakReference<>(activity);
    }

    /**
     * 恢复之前的设置
     * 即: 选中之前的设置项
     */
    public void restoreCache () {

        if (null == mActivity.get()) {
            Logger.e(TAG, "calling restoreCache(), activity is null");
            return;
        }

        String cache = ConfigFactory.get(mActivity.get().getApplicationContext(),
                                         ParentSettingsConfig.CONFIG_NAME_SP).get(
                ParentSettingsConfig.KEY_TIME_LIMIT,
                ParentSettingsConfig.VALUE_TIME_LIMIT_NO_LIMIT);
        if (TextUtils.equals(cache, ParentSettingsConfig.VALUE_TIME_LIMIT_NO_LIMIT)) {
            //无限制，do nothing
        } else {
            int value = Integer.parseInt(cache);
            int index = 0;
            for (int i = 0; i < ParentSettingsConfig.TIME_LIMIT_VALUES.length; i++) {
                if (ParentSettingsConfig.TIME_LIMIT_VALUES[i] == value) {
                    index = i;
                    break;
                }
            }
            mActivity.get().pickIndex(index);
        }
    }

    /**
     * 更新设置缓存
     *
     * @param newVal
     * @return
     */
    public boolean updateCache (String newVal) {

        if (null == mActivity.get()) {
            Logger.e(TAG, "calling updateCache(), activity is null");
            return false;
        }

        ConfigFactory.get(mActivity.get().getApplicationContext(), ParentSettingsConfig.CONFIG_NAME_SP)
                     .put(ParentSettingsConfig.KEY_TIME_LIMIT, newVal);
        return true;
    }
}