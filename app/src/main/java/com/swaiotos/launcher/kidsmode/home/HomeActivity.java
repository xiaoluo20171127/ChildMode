package com.swaiotos.launcher.kidsmode.home;

import android.os.Bundle;
import android.view.View;

import com.swaiotos.launcher.kidsmode.R;
import com.swaiotos.launcher.kidsmode.common.base.BaseActivity;
import com.swaiotos.launcher.kidsmode.common.view.IParentModeCallBack;
import com.swaiotos.launcher.kidsmode.common.view.ParentModeDialog;
import com.swaiotos.launcher.kidsmode.home.presenter.HomePagePresenter;
import com.swaiotos.launcher.kidsmode.home.view.HomePageView;
import com.swaiotos.launcher.kidsmode.settings.parent.service.FilterEventAction;
import com.swaiotos.launcher.kidsmode.settings.parent.service.TimeScheduler;


/**
 * @ClassName: HomeActivity
 * @Author: zhangjianfei
 * @CreateDate: 2020-01-07 15:50
 * @Description: 儿童模式主页
 * @branch release/v1.0
 */
public class HomeActivity extends BaseActivity {
    private static final String TAG = "HomeActivity";
    HomePageView mHomePageView;
    private HomePagePresenter mPresenter;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new HomePagePresenter(mHomePageView,this);
        mPresenter.downloadData();
    }

    @Override
    public View setLayoutView() {
        mHomePageView = new HomePageView(HomeActivity.this);
        return mHomePageView;
    }

    @Override
    protected void onResume () {
        super.onResume();
        mPresenter.checkTime();
        mHomePageView.onResume();

        if (TimeScheduler.isReadyToStart(getApplicationContext())) {
            TimeScheduler.getInstance().startSchedule(getApplicationContext());
        }
    }

    @Override
    public void onBackPressed() {
        ParentModeDialog dialog = new ParentModeDialog(this);
        dialog.initView(R.drawable.dialog_exit_child);
        dialog.setCallBack(new IParentModeCallBack() {
            @Override
            public void rightAnswer() {
                FilterEventAction.unsubscribe(getApplicationContext());
                HomeActivity.this.finish();
            }

            @Override
            public void wrongAnswer() {

            }
        });
        dialog.show();
    }


    @Override
    protected void onStop() {
        super.onStop();
        mHomePageView.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHomePageView.destroy();
    }
}
