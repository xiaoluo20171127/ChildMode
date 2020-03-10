package com.swaiotos.launcher.kidsmode.common.base;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.swaiotos.launcher.kidsmode.common.util.NavigationUtil;

/**
 * @ClassName: BaseActivity
 * @Author: zhangjianfei
 * @CreateDate: 2020-01-07 15:50
 * @Description: Activity基类
 */
public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NavigationUtil.hideNavigationBar(getWindow());
        setContentView(setLayoutView());
    }

    /**
     * 设置页面布局
     *
     * @return View 布局View
     */
    public abstract View setLayoutView();

}
