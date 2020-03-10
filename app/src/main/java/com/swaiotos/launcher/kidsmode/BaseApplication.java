package com.swaiotos.launcher.kidsmode;

import android.app.Application;
import android.content.Context;

import com.swaiotos.SwaiotOS;
import com.swaiotos.common.ui.UiUtil;
import com.swaiotos.ui.imageloader.ImageLoader;

/**
 * @ Created on: 2020/1/9
 * @Author: LEGION XiaoLuo
 * @ Description:
 */
public class BaseApplication extends Application {

    private static Context mContext = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        ImageLoader.getLoader().init(mContext);
        SwaiotOS.getOS().init(this);
        UiUtil.init(this);
    }

    public static Context getContext() {
        return mContext;
    }
}
