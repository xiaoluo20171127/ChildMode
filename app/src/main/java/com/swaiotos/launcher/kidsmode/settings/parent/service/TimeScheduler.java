package com.swaiotos.launcher.kidsmode.settings.parent.service;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.Toast;

import com.swaiotos.common.log.Logger;
import com.swaiotos.launcher.kidsmode.BaseApplication;
import com.swaiotos.launcher.kidsmode.settings.parent.ParentSettingsUtil;
import com.swaiotos.launcher.kidsmode.settings.parent.model.ParentSettingsConfig;
import com.swaiotos.launcher.kidsmode.timehint.TimeHintActivity;

import static com.swaiotos.launcher.kidsmode.settings.parent.service.Recorder.TIME_RECORDING_ID;
import static com.swaiotos.launcher.kidsmode.settings.parent.service.Recorder.TIME_RECORDING_UNIT;
import static com.swaiotos.launcher.kidsmode.settings.parent.service.Recorder.OnResultCallback.ID_EXECUTE_DELAY_ON_COMPLETE;

/**
 * @ClassName: TimeScheduler
 * @Author: zhangjianfei
 * @CreateDate: 2020-02-26 19:24
 * @Description: 计时相关调度类
 */
public class TimeScheduler extends HandlerThread {

    private static final String TAG = TimeScheduler.class.getName();

    private static boolean isScheduling = false;


    public static final String TIME_RECORDING_THREAD = "time_recording_thread";

    private static transient TimeScheduler scheduler;

    private Handler handler;
    private Recorder recorder;

    private TimeScheduler (String name) {

        super(name);
        start();

        handler = new Handler(getLooper()) {
            @Override
            public void handleMessage (@NonNull Message msg) {

                if (msg.what == recorder.getRecordId()) {
                    recorder.record(BaseApplication.getContext());
                } else if (msg.what == ID_EXECUTE_DELAY_ON_COMPLETE) {
                    startHintActivity(BaseApplication.getContext());
                }
            }
        };
        recorder = new KidsTimeRecorder(TIME_RECORDING_ID, TIME_RECORDING_UNIT);
        recorder.setOnResultCallback(new Recorder.OnResultCallback() {
            @Override
            public void onCompleted () {

                stopSchedule();

                String toast = "小朋友，今天的时间用完啦," + (VALUE_EXECUTE_DELAY_ON_COMPLETE / 1000) + "秒后就要退出了哦~";
                Toast.makeText(BaseApplication.getContext(), toast, Toast.LENGTH_LONG).show();

                handler.sendEmptyMessageDelayed(ID_EXECUTE_DELAY_ON_COMPLETE, VALUE_EXECUTE_DELAY_ON_COMPLETE);
            }

            @Override
            public void onContinue () {

                Logger.i(TAG, "continue record time ms:" + recorder.getRecordTimeUnit());
                handler.sendEmptyMessageDelayed(recorder.getRecordId(),
                                                recorder.getRecordTimeUnit());
            }
        });
    }

    private void startHintActivity (Context context) {
        Logger.i(TAG, "recording completed, start activity: " + TimeHintActivity.class);
        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setClassName(context.getPackageName(), TimeHintActivity.class.getName());
        context.startActivity(intent);
    }

    public static TimeScheduler getInstance () {

        if (scheduler == null) {
            synchronized (TimeScheduler.class) {
                if (scheduler == null) {
                    scheduler = new TimeScheduler(TIME_RECORDING_THREAD);
                }
            }
        }

        return scheduler;
    }

    /**
     * 开启任务
     * @param context
     */
    public void startSchedule (Context context) {
        if (null == context) {
            Logger.e(TAG, "calling startSchedule, context is null");
            return ;
        }

        if (isScheduling()) {
            return;
        }

        Logger.i(TAG, "start recording time");
        setIsScheduling(true);
        handler.sendEmptyMessageDelayed(recorder.getRecordId(), recorder.getRecordTimeUnit());
    }

    /**
     * 停止任务
     */
    public void stopSchedule () {

        if (isScheduling()) {
            Logger.i(TAG, "stop recording time");
            setIsScheduling(false);
            handler.removeMessages(recorder.getRecordId());
        }
    }


    private void setIsScheduling (boolean flag) {

        isScheduling = flag;
    }


    public static boolean isScheduling () {

        return isScheduling;
    }

    /**
     * 是否满足开始条件
     * @param context
     * @return
     */
    public static boolean isReadyToStart (Context context) {

        if (null == context) {
            Logger.e(TAG, "calling isReadyToStart, context is null");
            return false;
        }

        //检查开关是否开启
        if (!ParentSettingsUtil.isTimeControlSwitchOpen(context)) {
            return false;
        }

        //检查是否需要重置时间
        ParentSettingsUtil.checkAndResetUsedTime(context);

        //检查是否还有剩余时间
        if (ParentSettingsUtil.isLimitTimeLeft(context)) {
            if (TextUtils.equals(ParentSettingsConfig.TEXT_TIME_LIMIT_NO_LIMIT, ParentSettingsUtil.getTimeLimitValue(context))) {
                //如果用户设置了不限制，则不计算使用时间，这么做是基于这个假设：用户从“不限制” 改为 “x小时”，则应该从改变设置的时间点开始计时
                return false;
            }
            return true;

        } else {
            return false;
        }
    }
}
