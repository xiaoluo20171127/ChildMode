package com.swaiotos.launcher.kidsmode.settings.parent.service;

import android.content.Context;
import android.content.Intent;

import com.swaiotos.SwaiotOS;
import com.swaiotos.common.log.Logger;

import static com.swaiotos.service.controlpanel.PanelConstants.ACTION_SUBSCRIBE_TOUCH_FILTER;
import static com.swaiotos.service.controlpanel.PanelConstants.KEY_FILTER_CALLBACK_ACTION;
import static com.swaiotos.service.controlpanel.PanelConstants.KEY_PACKAGE;
import static com.swaiotos.service.controlpanel.PanelConstants.KEY_PANEL_INDEX;
import static com.swaiotos.service.controlpanel.PanelConstants.KEY_SUBSCRIBE;
import static com.swaiotos.service.controlpanel.PanelConstants.PANEL_INDEX_ALL;
import static com.swaiotos.service.controlpanel.PanelConstants.VALUE_SUBSCRIBE;
import static com.swaiotos.service.controlpanel.PanelConstants.VALUE_UNSUBSCRIBE;

/**
 * @ClassName: FilterEventAction
 * @Author: zhangjianfei
 * @CreateDate: 2020-03-04 15:21
 * @Description: 注册和注销过滤事件的方法类
 */
public class FilterEventAction {

    private static final String TAG = FilterEventAction.class.getName();

    public static final String ACTION_ON_TOUCH_FILTERED = "action_on_touch_filtered_in_kids_mode";

    /**
     * 注册过滤事件
     * @param context
     */
    public static void subscribe(Context context) {
        if (context == null) {
            Logger.e(TAG, "calling subscribe, context is null");
            return;
        }

        Intent intent = new Intent(ACTION_SUBSCRIBE_TOUCH_FILTER);
        intent.putExtra(KEY_PANEL_INDEX, PANEL_INDEX_ALL);
        intent.putExtra(KEY_PACKAGE, context.getPackageName());
        intent.putExtra(KEY_SUBSCRIBE, VALUE_SUBSCRIBE);
        intent.putExtra(KEY_FILTER_CALLBACK_ACTION, ACTION_ON_TOUCH_FILTERED);
        intent.setPackage(SwaiotOS.SWAIOTOS_UI);
        context.sendBroadcast(intent);
    }

    /**
     * 注销过滤事件
     * @param context
     */
    public static void unsubscribe(Context context) {
        if (context == null) {
            Logger.e(TAG, "calling subscribe, context is null");
            return;
        }

        Intent intent = new Intent(ACTION_SUBSCRIBE_TOUCH_FILTER);
        intent.putExtra(KEY_PANEL_INDEX, PANEL_INDEX_ALL);
        intent.putExtra(KEY_PACKAGE, context.getPackageName());
        intent.putExtra(KEY_SUBSCRIBE, VALUE_UNSUBSCRIBE);
        intent.putExtra(KEY_FILTER_CALLBACK_ACTION, ACTION_ON_TOUCH_FILTERED);
        intent.setPackage(SwaiotOS.SWAIOTOS_UI);
        context.sendBroadcast(intent);
    }
}
