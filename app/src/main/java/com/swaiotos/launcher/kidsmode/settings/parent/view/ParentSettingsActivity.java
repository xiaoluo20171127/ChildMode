package com.swaiotos.launcher.kidsmode.settings.parent.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.swaiotos.launcher.kidsmode.R;
import com.swaiotos.launcher.kidsmode.common.base.BaseActivity;
import com.swaiotos.launcher.kidsmode.home.HomeActivity;
import com.swaiotos.launcher.kidsmode.settings.parent.ParentSettingsUtil;
import com.swaiotos.launcher.kidsmode.settings.parent.presenter.ParentSettingsPresenter;

/**
 * @ClassName: ParentSettingsActivity
 * @Author: zhangjianfei
 * @CreateDate: 2020-02-03 15:50
 * @Description: 家长设置Activity
 */
public class ParentSettingsActivity extends BaseActivity {

    private TextView tv_value_time_control_switch, tv_title_time_limit, tv_value_time_limit, tv_title_prohibit_period, tv_value_prohibit_period;

    private ParentSettingsPresenter mPresenter;

    @Override
    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_parent_settings);
        bindView();
        init();
    }

    @Override
    public View setLayoutView () {

//        return LayoutInflater.from(getApplicationContext())
//                             .inflate(R.layout.layout_activity_parent_settings, null);
        return new View(getApplicationContext());
    }

    private void init () {

        mPresenter = new ParentSettingsPresenter(this);
    }

    private void bindView () {

        tv_value_time_control_switch = findViewById(R.id.tv_value_time_control_switch);

        tv_title_time_limit = findViewById(R.id.tv_title_time_limit);
        tv_value_time_limit = findViewById(R.id.tv_value_time_limit);
        tv_title_prohibit_period = findViewById(R.id.tv_title_prohibit_period);
        tv_value_prohibit_period = findViewById(R.id.tv_value_prohibit_period);
    }


    @Override
    protected void onResume () {

        refreshUi();

        super.onResume();
    }

    private void refreshUi () {

        updateTimeControlSwitchUi(ParentSettingsUtil.isTimeControlSwitchOpen(getApplicationContext()));
        refreshTimeLimitUi(ParentSettingsUtil.getTimeLimitValue(getApplicationContext()));
        refreshProhibitPeriodUi(ParentSettingsUtil.getProhibitPeriodStr(getApplicationContext()));
    }

    /**
     * 更新禁止使用时间的UI
     *
     * @param prohibitPeriodValue
     */
    private void refreshProhibitPeriodUi (String prohibitPeriodValue) {

        tv_value_prohibit_period.setText(prohibitPeriodValue);
    }

    /**
     * 更新全天使用时长的UI
     *
     * @param timeLimitValue
     */
    private void refreshTimeLimitUi (String timeLimitValue) {

        tv_value_time_limit.setText(timeLimitValue);
    }

    /**
     * 更新开关的UI
     *
     * @param isOpen
     */
    public void updateTimeControlSwitchUi (boolean isOpen) {

        tv_value_time_control_switch.setEnabled(isOpen);
        if (isOpen) {
            tv_value_time_control_switch.setText("开启");

            tv_title_time_limit.setEnabled(true);
            tv_value_time_limit.setEnabled(true);
            tv_title_prohibit_period.setEnabled(true);
            tv_value_prohibit_period.setEnabled(true);

            mPresenter.startTimeRecording(getApplicationContext());

        } else {

            mPresenter.stopTimeRecording();
            tv_value_time_control_switch.setText("关闭");

            tv_title_time_limit.setEnabled(false);
            tv_value_time_limit.setEnabled(false);
            tv_title_prohibit_period.setEnabled(false);
            tv_value_prohibit_period.setEnabled(false);
        }
    }

    public void clickAction (View view) {

        switch (view.getId()) {
            case R.id.cl_prohibit_period:
                if (tv_value_prohibit_period.isEnabled()) {
                    startActivity(new Intent(this, ProhibitPeriodActivity.class));
                }
                break;
            case R.id.cl_time_limit:
                if (tv_value_time_limit.isEnabled()) {
                    startActivity(new Intent(this, TimeLimitActivity.class));
                }
                break;
            case R.id.cl_time_control:
                mPresenter.updateOpenState(!tv_value_time_control_switch.isEnabled());
                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressed () {
        finish();
        startActivity(new Intent(this, HomeActivity.class));
    }
}
