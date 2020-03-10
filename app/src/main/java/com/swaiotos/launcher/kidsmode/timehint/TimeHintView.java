package com.swaiotos.launcher.kidsmode.timehint;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;


import com.swaiotos.common.ui.UiUtil;
import com.swaiotos.launcher.kidsmode.R;
import com.swaiotos.launcher.kidsmode.common.view.NumberView;

/**
 * @ Created on: 2020/2/19
 * @Author: LEGION XiaoLuo
 * @ Description:
 */
public class TimeHintView extends FrameLayout {
    public ImageView mExitParentModeView;
    public ImageView mParentSetView;
    public static final int TIME_OUT = 0;
    public static final int FORBID_TIME = 1;

    public TimeHintView(Context context, int type, String forbidTimeText) {
        super(context);
        initView(context, type, forbidTimeText);
    }

    private void initView(Context context, int type, String forbidTimeText) {
        ImageView bgView = new ImageView(context);
        LayoutParams bgParams = new LayoutParams(UiUtil.div(1920), UiUtil.div(1200));
        bgView.setImageResource(R.drawable.bg_parent_settings);
        addView(bgView, bgParams);

        ImageView whaleView = new ImageView(context);
        LayoutParams whaleParams = new LayoutParams(UiUtil.div(1350), UiUtil.div(892));
        whaleParams.leftMargin = UiUtil.div(306);
        whaleParams.topMargin = UiUtil.div(642);
        whaleView.setImageResource(R.drawable.hint_whale);
        addView(whaleView, whaleParams);

        mExitParentModeView = new ImageView(context);
        LayoutParams exitParams = new LayoutParams(UiUtil.div(468), UiUtil.div(236));
        exitParams.leftMargin = UiUtil.div(30);
        exitParams.topMargin = UiUtil.div(0);
        mExitParentModeView.setBackgroundResource(R.drawable.home_bg_exit);
        addView(mExitParentModeView, exitParams);

        mParentSetView = new ImageView(context);
        LayoutParams setParams = new LayoutParams(UiUtil.div(405), UiUtil.div(238));
        setParams.leftMargin = UiUtil.div(498);
        setParams.topMargin = UiUtil.div(0);
        mParentSetView.setBackgroundResource(R.drawable.home_bg_set);
        addView(mParentSetView, setParams);

        ImageView sandClock = new ImageView(context);
        LayoutParams clockParams = new LayoutParams(UiUtil.div(122), UiUtil.div(160));
        if (type == TIME_OUT) {
            clockParams.leftMargin = UiUtil.div(968);
            clockParams.topMargin = UiUtil.div(347);
            clockParams.width = UiUtil.div(122);
            clockParams.height = UiUtil.div(160);
            sandClock.setImageResource(R.drawable.hint_out_clock);
        } else {
            clockParams.leftMargin = UiUtil.div(933);
            clockParams.topMargin = UiUtil.div(290);
            clockParams.width = UiUtil.div(190);
            clockParams.height = UiUtil.div(200);
            sandClock.setImageResource(R.drawable.hint_forbid_clock);
        }
        addView(sandClock, clockParams);

        ImageView hintWord = new ImageView(context);
        LayoutParams wordParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, UiUtil.div(50));
        if (type == TIME_OUT) {
            wordParams.width = UiUtil.div(747);
            wordParams.leftMargin = UiUtil.div(641);
            wordParams.topMargin = UiUtil.div(555);
            hintWord.setImageResource(R.drawable.hint_timeout_word);
        } else {
            wordParams.width = UiUtil.div(747);
            wordParams.leftMargin = UiUtil.div(620);
            wordParams.topMargin = UiUtil.div(534);
            hintWord.setImageResource(R.drawable.hint_forbid_word);
        }
        addView(hintWord, wordParams);

        if (type == FORBID_TIME) {
            ImageView forbid = new ImageView(context);
            LayoutParams params = new LayoutParams(UiUtil.div(187), UiUtil.div(41));
            params.leftMargin = UiUtil.div(751);
            params.topMargin = UiUtil.div(598);
            forbid.setImageResource(R.drawable.hint_forbidtime_text);
            addView(forbid, params);

            NumberView textView = new NumberView(context);
            textView.setProperty(forbidTimeText,"#D07B2E",43);
            LayoutParams forbidTextParams = new LayoutParams(UiUtil.div(310), UiUtil.div(36));
            forbidTextParams.leftMargin = UiUtil.div(974);
            forbidTextParams.topMargin = UiUtil.div(600);
            addView(textView, forbidTextParams);
        }


    }

}
