package com.swaiotos.launcher.kidsmode.settings.parent.service;

import android.content.Context;

/**
 * @ClassName: Recorder
 * @Author: zhangjianfei
 * @CreateDate: 2020-02-26 21:36
 * @Description: 时间记录的操作者
 */
public abstract class Recorder {

    protected OnResultCallback onResultCallback;

    //记录时间的单位，每次记录一分钟
    public static final int MILLI_SECOND_PER_MIN = 60 * 1000;
    public static final int TIME_RECORDING_UNIT = 60 * 1000;
    public static final int TIME_RECORDING_ID = 0x1001;

    public static final int MILLI_SECOND_PER_MIN_TEST = 2 * 1000;
    public static final int TIME_RECORDING_UNIT_TEST = 2 * 1000;

    private final int recordId;
    private final int recordTimeUnit;

    public int getRecordId () {

        return recordId;
    }

    public int getRecordTimeUnit () {

        return recordTimeUnit;
    }

    public Recorder (int recordId, int recordTimeUnit) {

        this.recordId = recordId;
        this.recordTimeUnit = recordTimeUnit;
    }

    /**
     * 每次记录 recordTimeUnit 单位的时间
     * @param context
     */
    public abstract void record (Context context);

    public void setOnResultCallback (OnResultCallback callback) {
        this.onResultCallback = callback;
    }

    public interface OnResultCallback {

        //结束前30秒提醒用户
        int VALUE_EXECUTE_DELAY_ON_COMPLETE = 30 * 1000;
        int ID_EXECUTE_DELAY_ON_COMPLETE = 0x2001;

        /**
         * 任务结束
         */
        void onCompleted ();

        /**
         * 继续执行
         */
        void onContinue ();
    }
}
