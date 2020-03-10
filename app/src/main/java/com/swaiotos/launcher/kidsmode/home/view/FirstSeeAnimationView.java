package com.swaiotos.launcher.kidsmode.home.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.media.tv.TvView;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.swaiotos.common.ui.UiUtil;
import com.swaiotos.launcher.kidsmode.R;

import java.util.ArrayList;

/**
 * @ Created on: 2020/2/25
 * @Author: LEGION XiaoLuo
 * @ Description:
 */
public class FirstSeeAnimationView extends FrameLayout {
    int time = 2000;

    public FirstSeeAnimationView(@NonNull Context context, ArrayList<Animator> list) {
        super(context);
        initView(context, list);
    }

    private void initView(Context context, ArrayList<Animator> list) {
        setLayoutParams(new ViewGroup.LayoutParams(UiUtil.div(515), UiUtil.div(532)));
        setBackgroundResource(R.drawable.home_see_bg);
        ObjectAnimator layoutT = ObjectAnimator.ofFloat(this, "translationY", 0, 10, 0).setDuration(time);
        layoutT.setRepeatCount(ValueAnimator.INFINITE);

        ImageView tvView = new ImageView(context);
        LayoutParams tvParams = new LayoutParams(UiUtil.div(240), UiUtil.div(235));
        tvParams.topMargin = UiUtil.div(35);
        tvParams.leftMargin = UiUtil.div(161);
        tvView.setBackgroundResource(R.drawable.home_see_tv);
        addView(tvView, tvParams);
//        PropertyValuesHolder tvScaleX = PropertyValuesHolder.ofFloat("scaleX", 1, 1.05f, 1);
//        PropertyValuesHolder tvScaleY = PropertyValuesHolder.ofFloat("scaleY", 1, 1.05f, 1);
//        ObjectAnimator tvA = ObjectAnimator.ofPropertyValuesHolder(tvView, tvScaleX, tvScaleY).setDuration(time);
//        tvA.setRepeatCount(ValueAnimator.INFINITE);


        ImageView crabView = new ImageView(context);
        LayoutParams crabParams = new LayoutParams(UiUtil.div(253), UiUtil.div(171));
        crabParams.leftMargin = UiUtil.div(141);
        crabParams.topMargin = UiUtil.div(273);
        crabView.setBackgroundResource(R.drawable.home_see_crab);
        addView(crabView, crabParams);
        Keyframe k0 = Keyframe.ofFloat(0, 0);
        Keyframe k1 = Keyframe.ofFloat(0.1f,0);
        Keyframe k2 = Keyframe.ofFloat(0.45f, 80);
        Keyframe k3 = Keyframe.ofFloat(0.65f, 80);
        Keyframe k4 = Keyframe.ofFloat(1f, 0);
        PropertyValuesHolder p = PropertyValuesHolder.ofKeyframe("translationX", k0, k1, k2, k3,k4);
        ObjectAnimator cradA = ObjectAnimator.ofPropertyValuesHolder(crabView, p).setDuration(4000);
        cradA.setRepeatCount(ValueAnimator.INFINITE);


        list.add(layoutT);
     //   list.add(tvA);
        list.add(cradA);
    }
}
