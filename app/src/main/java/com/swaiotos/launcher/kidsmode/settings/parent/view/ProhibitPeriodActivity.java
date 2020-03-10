package com.swaiotos.launcher.kidsmode.settings.parent.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.swaiotos.launcher.kidsmode.R;
import com.swaiotos.launcher.kidsmode.common.base.BaseActivity;
import com.swaiotos.launcher.kidsmode.settings.parent.presenter.ProhibitPeriodPresenter;

/**
 * @ClassName: ProhibitPeriodActivity
 * @Author: zhangjianfei
 * @CreateDate: 2020-02-03 15:50
 * @Description: 禁止使用时间Activity
 */
public class ProhibitPeriodActivity extends BaseActivity {

    private ProhibitPeriodPresenter mPresenter;

    private TextView tv_start_hour, tv_start_min, tv_end_hour, tv_end_min;
    private ImageView iv_start_hour_up, iv_start_hour_down, iv_start_min_up, iv_start_min_down, iv_end_hour_up, iv_end_hour_down, iv_end_min_up, iv_end_min_down;

    @Override
    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prohibit_period);
        init();
        initUi();
    }

    @Override
    public View setLayoutView () {

        return new View(getApplicationContext());
    }

    private void initUi () {

        findViews();
    }

    private void init () {

        mPresenter = new ProhibitPeriodPresenter(this);
    }

    /**
     *
     * @param newStartHour
     */
    public void updateStartHourUi (String newStartHour) {

        tv_start_hour.setText(newStartHour);
    }

    public void updateStartMinUi (String newStartMin) {

        tv_start_min.setText(newStartMin);
    }

    public void updateEndHourUi (String newEndHour) {

        tv_end_hour.setText(newEndHour);
    }

    public void updateEndMinUi (String newEndMin) {

        tv_end_min.setText(newEndMin);
    }

    public void focusOnStartHourUi () {

        iv_start_hour_up.setVisibility(View.VISIBLE);
        iv_start_hour_down.setVisibility(View.VISIBLE);
        iv_start_min_up.setVisibility(View.GONE);
        iv_start_min_down.setVisibility(View.GONE);
        iv_end_hour_up.setVisibility(View.GONE);
        iv_end_hour_down.setVisibility(View.GONE);
        iv_end_min_up.setVisibility(View.GONE);
        iv_end_min_down.setVisibility(View.GONE);
    }

    public void focusOnStartMinUi () {

        iv_start_hour_up.setVisibility(View.GONE);
        iv_start_hour_down.setVisibility(View.GONE);
        iv_start_min_up.setVisibility(View.VISIBLE);
        iv_start_min_down.setVisibility(View.VISIBLE);
        iv_end_hour_up.setVisibility(View.GONE);
        iv_end_hour_down.setVisibility(View.GONE);
        iv_end_min_up.setVisibility(View.GONE);
        iv_end_min_down.setVisibility(View.GONE);
    }

    public void focusOnEndHourUi () {

        iv_start_hour_up.setVisibility(View.GONE);
        iv_start_hour_down.setVisibility(View.GONE);
        iv_start_min_up.setVisibility(View.GONE);
        iv_start_min_down.setVisibility(View.GONE);
        iv_end_hour_up.setVisibility(View.VISIBLE);
        iv_end_hour_down.setVisibility(View.VISIBLE);
        iv_end_min_up.setVisibility(View.GONE);
        iv_end_min_down.setVisibility(View.GONE);
    }

    public void focusOnEndMinUi () {

        iv_start_hour_up.setVisibility(View.GONE);
        iv_start_hour_down.setVisibility(View.GONE);
        iv_start_min_up.setVisibility(View.GONE);
        iv_start_min_down.setVisibility(View.GONE);
        iv_end_hour_up.setVisibility(View.GONE);
        iv_end_hour_down.setVisibility(View.GONE);
        iv_end_min_up.setVisibility(View.VISIBLE);
        iv_end_min_down.setVisibility(View.VISIBLE);
    }

    public void onViewClick (View view) {

        switch (view.getId()) {
            case R.id.iv_time_no_limit:
                mPresenter.setNoTimeLimit();
                break;
            case R.id.tv_start_hour:
                focusOnStartHourUi();
                break;
            case R.id.tv_start_min:
                focusOnStartMinUi();
                break;
            case R.id.tv_end_hour:
                focusOnEndHourUi();
                break;
            case R.id.tv_end_min:
                focusOnEndMinUi();
                break;

            case R.id.iv_start_hour_up:
                mPresenter.increaseStartHour(tv_start_hour.getText());
                break;
            case R.id.iv_start_hour_down:
                mPresenter.decreaseStartHour(tv_start_hour.getText());
                break;

            case R.id.iv_start_min_up:
                mPresenter.increaseStartMin(tv_start_min.getText());
                break;
            case R.id.iv_start_min_down:
                mPresenter.decreaseStartMin(tv_start_min.getText());
                break;

            case R.id.iv_end_hour_up:
                mPresenter.increaseEndHour(tv_end_hour.getText());
                break;
            case R.id.iv_end_hour_down:
                mPresenter.decreaseEndHour(tv_end_hour.getText());
                break;

            case R.id.iv_end_min_up:
                mPresenter.increaseEndMin(tv_end_min.getText());
                break;
            case R.id.iv_end_min_down:
                mPresenter.decreaseEndMin(tv_end_min.getText());
                break;

            default:
                break;
        }
    }

    private void findViews () {

        tv_start_hour = findViewById(R.id.tv_start_hour);
        tv_start_min = findViewById(R.id.tv_start_min);
        tv_end_hour = findViewById(R.id.tv_end_hour);
        tv_end_min = findViewById(R.id.tv_end_min);

        iv_start_hour_up = findViewById(R.id.iv_start_hour_up);
        iv_start_hour_down = findViewById(R.id.iv_start_hour_down);

        iv_start_min_up = findViewById(R.id.iv_start_min_up);
        iv_start_min_down = findViewById(R.id.iv_start_min_down);

        iv_end_hour_up = findViewById(R.id.iv_end_hour_up);
        iv_end_hour_down = findViewById(R.id.iv_end_hour_down);

        iv_end_min_up = findViewById(R.id.iv_end_min_up);
        iv_end_min_down = findViewById(R.id.iv_end_min_down);
    }

    @Override
    protected void onResume () {

        super.onResume();
        updateStartHourUi(mPresenter.getCachedStartHour());
        updateStartMinUi(mPresenter.getCachedStartMin());
        updateEndHourUi(mPresenter.getCachedEndHour());
        updateEndMinUi(mPresenter.getCachedEndMin());
        focusOnStartHourUi();
    }

    @Override
    protected void onPause () {

        super.onPause();
        try {
            String startHour = tv_start_hour.getText().toString();
            String startMin = tv_start_min.getText().toString();
            String endHour = tv_end_hour.getText().toString();
            String endMin = tv_end_min.getText().toString();

            //更新禁止使用时间的缓存
            if (mPresenter.cacheProhibitPeriod(startHour, startMin, endHour, endMin)) {
                Toast.makeText(getApplicationContext(), mPresenter.getToastMessage(startHour, startMin, endHour, endMin), Toast.LENGTH_SHORT).show();
            }
        } catch (NullPointerException e) {
            mPresenter.resetTime();
            Toast.makeText(getApplicationContext(), "数据异常", Toast.LENGTH_SHORT).show();
        }
    }
}
