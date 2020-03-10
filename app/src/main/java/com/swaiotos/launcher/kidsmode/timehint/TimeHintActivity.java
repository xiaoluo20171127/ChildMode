package com.swaiotos.launcher.kidsmode.timehint;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;


import com.swaiotos.launcher.kidsmode.R;
import com.swaiotos.launcher.kidsmode.common.base.BaseActivity;
import com.swaiotos.launcher.kidsmode.common.view.IParentModeCallBack;
import com.swaiotos.launcher.kidsmode.common.view.ParentModeDialog;
import com.swaiotos.launcher.kidsmode.settings.parent.ParentSettingsUtil;
import com.swaiotos.launcher.kidsmode.settings.parent.view.ParentSettingsActivity;

import java.util.List;

/**
 * @ Created on: 2020/2/19
 * @Author: LEGION XiaoLuo
 * @ Description:
 */
public class TimeHintActivity extends BaseActivity {
    private TimeHintView mHintView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        exitParentMode(mHintView);
        enterParentSet(mHintView);
    }


    @Override
    public View setLayoutView() {
        return checkMode();
    }

    private void enterParentSet(TimeHintView hintView) {
        hintView.mParentSetView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ParentModeDialog dialog = new ParentModeDialog(TimeHintActivity.this);
                dialog.initView(R.drawable.dialog_parent_set);
                dialog.setCallBack(new IParentModeCallBack() {
                    @Override
                    public void rightAnswer() {
                        dialog.dismiss();
                        startActivity(new Intent(TimeHintActivity.this, ParentSettingsActivity.class));
                    }

                    @Override
                    public void wrongAnswer() {

                    }
                });
                dialog.show();
            }
        });
    }

    private void exitParentMode(TimeHintView hintView) {
        hintView.mExitParentModeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ParentModeDialog dialog = new ParentModeDialog(TimeHintActivity.this);
                dialog.initView(R.drawable.dialog_exit_child);
                dialog.setCallBack(new IParentModeCallBack() {
                    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void rightAnswer() {
                        dialog.dismiss();
                        exitProcess();
                    }

                    @Override
                    public void wrongAnswer() {

                    }
                });
                dialog.show();
            }
        });
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void exitProcess() {
        ActivityManager activityManager = (ActivityManager) getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.AppTask> appTaskList = activityManager.getAppTasks();
        for (ActivityManager.AppTask appTask : appTaskList) {
            appTask.finishAndRemoveTask();
        }
        System.exit(0);
    }

    /**
     * 检查当前是时间用完了还是禁止时间
     */
    private View checkMode() {

        int type = -1;
        String forbidTime = "default";

        if (!ParentSettingsUtil.isLimitTimeLeft(this)) {
            type = TimeHintView.TIME_OUT;
        } else if (ParentSettingsUtil.isNowInProhibitPeriod(this)) {
            type = TimeHintView.FORBID_TIME;
            forbidTime = ParentSettingsUtil.getProhibitPeriodStr(this);
        }
        mHintView = new TimeHintView(this, type, forbidTime);
        return mHintView;
    }
}
