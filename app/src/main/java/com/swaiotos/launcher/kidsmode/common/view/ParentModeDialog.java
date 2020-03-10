package com.swaiotos.launcher.kidsmode.common.view;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.swaiotos.common.ui.UiUtil;
import com.swaiotos.launcher.kidsmode.common.util.NavigationUtil;

/**
 * @ Created on: 2020/1/13
 * @Author: LEGION XiaoLuo
 * @ Description:
 */
public class ParentModeDialog extends Dialog {
    private ParentModeView mModeView;
    private final Window mWindow;

    public ParentModeDialog(Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayoutId(context));
        mWindow = getWindow();
        WindowManager.LayoutParams wl = mWindow.getAttributes();
        wl.width = UiUtil.div(996);
        wl.height = UiUtil.div(596);
        wl.x = UiUtil.div(462);
        wl.y = UiUtil.div(320);
        mWindow.setGravity(Gravity.TOP|Gravity.START);
        mWindow.getDecorView().setPadding(0, 0, 0, 0);
        mWindow.setBackgroundDrawableResource(android.R.color.transparent);
        mWindow.setAttributes(wl);
    }

    public void initView(int resId) {
        mModeView.setTitleView(resId);
    }

    private View getLayoutId(Context context) {
        mModeView = new ParentModeView(context);
        return mModeView;
    }

    public void setCallBack(IParentModeCallBack callBack) {
        mModeView.setCallBack(callBack);
    }

    @Override
    public void show() {
        NavigationUtil.focusNotAle(mWindow);
        super.show();
        NavigationUtil.hideNavigationBar(mWindow);
        NavigationUtil.clearFocusNotAle(mWindow);
    }
}
