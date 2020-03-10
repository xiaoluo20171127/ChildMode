package com.swaiotos.launcher.kidsmode.settings.parent.presenter;

import android.content.Context;

import com.swaiotos.common.config.ConfigFactory;
import com.swaiotos.common.log.Logger;
import com.swaiotos.launcher.kidsmode.settings.parent.model.ParentSettingsConfig;
import com.swaiotos.launcher.kidsmode.settings.parent.service.TimeScheduler;
import com.swaiotos.launcher.kidsmode.settings.parent.view.ParentSettingsActivity;

import java.lang.ref.WeakReference;

/**
 * @ClassName: ParentSettingsPresenter
 * @Author: zhangjianfei
 * @CreateDate: 2020-02-05 16:53
 * @Description: 家长设置Presenter
 */
public class ParentSettingsPresenter {

    private static final String TAG = ParentSettingsPresenter.class.getName();

    private WeakReference<ParentSettingsActivity> mActivity;

    public ParentSettingsPresenter (ParentSettingsActivity activity) {

        this.mActivity = new WeakReference<>(activity);
    }

    public void updateOpenState (boolean isOpen) {

        if (null == mActivity.get()) {
            return;
        }

        String config = isOpen ? ParentSettingsConfig.VALUE_TRUE : ParentSettingsConfig.VALUE_FALSE;
        ConfigFactory.get(mActivity.get().getApplicationContext(), ParentSettingsConfig.CONFIG_NAME_SP)
                     .put(ParentSettingsConfig.KEY_SETTINGS_STATE_IS_OPEN, config);
        mActivity.get().updateTimeControlSwitchUi(isOpen);
    }

    public void startTimeRecording (Context context) {
        if (null == context) {
            Logger.e(TAG, "calling startTimeRecording, context is null");
            return;
        }
        if (TimeScheduler.isReadyToStart(context)) {
            TimeScheduler.getInstance().startSchedule(context);
        }
    }

    public void stopTimeRecording () {

        if (TimeScheduler.isScheduling()) {
            TimeScheduler.getInstance().stopSchedule();
        }

    }
}
