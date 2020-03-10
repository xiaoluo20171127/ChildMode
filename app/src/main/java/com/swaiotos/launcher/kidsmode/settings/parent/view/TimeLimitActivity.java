package com.swaiotos.launcher.kidsmode.settings.parent.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.swaiotos.launcher.kidsmode.R;
import com.swaiotos.launcher.kidsmode.common.base.BaseActivity;
import com.swaiotos.launcher.kidsmode.settings.parent.model.ParentSettingsConfig;
import com.swaiotos.launcher.kidsmode.settings.parent.presenter.TimeLimitPresenter;

import cn.carbswang.android.numberpickerview.library.NumberPickerView;

/**
 * @ClassName: TimeLimitActivity
 * @Author: zhangjianfei
 * @CreateDate: 2020-02-03 15:50
 * @Description: 全天使用时长Activity
 */
public class TimeLimitActivity extends BaseActivity {

    private NumberPickerView numberPicker;
    private TimeLimitPresenter mPresenter;

    @Override
    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        init();
        initUi();
    }

    @Override
    public View setLayoutView () {

        return LayoutInflater.from(getApplicationContext()).inflate(R.layout.activity_time_limit,
                                                                    null);
    }

    private void init () {

        mPresenter = new TimeLimitPresenter(this);
    }

    private void initUi () {

        findViews();
        initNumberPickerView();
    }

    private void initNumberPickerView () {

        numberPicker.setDisplayedValues(ParentSettingsConfig.TIME_LIMIT_STRS);
        numberPicker.setMaxValue(ParentSettingsConfig.TIME_LIMIT_VALUES.length - 1);
        numberPicker.setMinValue(0);

        numberPicker.setOnValueChangedListener(new NumberPickerView.OnValueChangeListener() {
            @Override
            public void onValueChange (NumberPickerView picker, int oldVal, int newVal) {

                if (mPresenter.updateCache("" + ParentSettingsConfig.TIME_LIMIT_VALUES[newVal])) {
                    Toast.makeText(getApplicationContext(),
                                   "设置修改为: " + ParentSettingsConfig.TIME_LIMIT_STRS[newVal],
                                   Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void pickIndex (int value) {

        numberPicker.setValue(value);
    }

    private void findViews () {

        numberPicker = findViewById(R.id.numberPicker);
    }

    @Override
    protected void onResume () {

        super.onResume();

        mPresenter.restoreCache();
    }

    @Override
    protected void onPause () {

        super.onPause();
    }
}
