package com.swaiotos.launcher.kidsmode.settings.parent.service;

import android.content.Context;

import com.swaiotos.common.log.Logger;
import com.swaiotos.launcher.kidsmode.settings.parent.ParentSettingsUtil;

/**
 * @ClassName: KidsTimeRecorder
 * @Author: zhangjianfei
 * @CreateDate: 2020-02-26 21:51
 * @Description: 儿童模式的计时类
 */
public class KidsTimeRecorder extends Recorder {

    private static final String TAG = KidsTimeRecorder.class.getName();

    public KidsTimeRecorder (int recordId, int recordTimeUnit) {

        super(recordId, recordTimeUnit);
    }

    @Override
    public void record (Context context) {

        if (null == context) {
            Logger.e(TAG, "calling record context is null");
            return;
        }

        if (ParentSettingsUtil.isNowInProhibitPeriod(context)) {
            //禁止使用时间段内，不记入使用时间
            Logger.i(TAG, "in prohibit period not record as used time");
        } else {
            Logger.i(TAG, "do record time, ms: " + getRecordTimeUnit());
            ParentSettingsUtil.addUsedTime(context, getRecordTimeUnit() / MILLI_SECOND_PER_MIN);
        }

        if (onResultCallback != null) {
            if (ParentSettingsUtil.isLimitTimeLeft(context)) {
                //可用时间未用完
                onResultCallback.onContinue();
            } else {
                //可用时间用完了
                onResultCallback.onCompleted();
            }
        }
    }
}
