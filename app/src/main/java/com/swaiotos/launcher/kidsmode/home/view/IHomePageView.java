package com.swaiotos.launcher.kidsmode.home.view;


import android.view.View;

/**
 * @ Created on: 2020/1/9
 * @Author: LEGION XiaoLuo
 * @ Description:
 */
public interface IHomePageView {
    View getView();

    void destroy();

    void onResume();

    void onStop();
}
