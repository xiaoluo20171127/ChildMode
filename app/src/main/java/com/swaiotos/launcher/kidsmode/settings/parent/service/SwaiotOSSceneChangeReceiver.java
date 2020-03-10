package com.swaiotos.launcher.kidsmode.settings.parent.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.swaiotos.common.log.Logger;
import com.swaiotos.service.controlpanel.PanelConstants;

/**
 * @ClassName: SwaiotOSSceneChangeReceiver
 * @Author: zhangjianfei
 * @CreateDate: 2020-02-26 21:36
 * @Description: 智慧屏场景切换广播的接收器
 */
public class SwaiotOSSceneChangeReceiver extends BroadcastReceiver {

    private static final String TAG = SwaiotOSSceneChangeReceiver.class.getName();

    @Override
    public void onReceive (Context context, Intent intent) {

        if (intent.getAction() == null) {
            Logger.e(TAG, "Cannot handle package broadcast with null action");
            return;
        }

        Logger.i(TAG, "receive broadcast: " + intent.getAction());

        if (TextUtils.equals(PanelConstants.ACTION_SCENE_CHANGED, intent.getAction())) {
            String sceneId = intent.getStringExtra(PanelConstants.KEY_SCENE_ID);
            String sceneName = intent.getStringExtra(PanelConstants.KEY_SCENE_NAME);

            if (TextUtils.equals(sceneId, PanelConstants.VALUE_SCENE_ID_KIDS_MODE)) {
                //场景切换为儿童模式, 注册过滤事件，禁止使用其他的功能
                FilterEventAction.subscribe(context);
            } else {
                //场景切换到了其他模式(已经不是儿童模式了)
                if (TimeScheduler.isScheduling()) {
                    TimeScheduler.getInstance().stopSchedule();
                }
            }
        }

    }
}
