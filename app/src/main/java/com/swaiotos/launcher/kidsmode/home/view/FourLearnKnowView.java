package com.swaiotos.launcher.kidsmode.home.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.media.Image;
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
public class FourLearnKnowView extends FrameLayout {
    int time = 2000;

    public FourLearnKnowView(@NonNull Context context, ArrayList<Animator> list) {
        super(context);
        initView(context, list);
    }

    private void initView(Context context, ArrayList<Animator> list) {
        setLayoutParams(new ViewGroup.LayoutParams(UiUtil.div(541), UiUtil.div(498)));
        ObjectAnimator layoutT = ObjectAnimator.ofFloat(this, "translationY", 0, -10, 0).setDuration(time);
        layoutT.setRepeatCount(ValueAnimator.INFINITE);
        list.add(layoutT);

        ImageView islandView = new ImageView(context);
        islandView.setBackgroundResource(R.drawable.home_learn_island);
        LayoutParams islandParams = new LayoutParams(UiUtil.div(541), UiUtil.div(498));
        addView(islandView, islandParams);

        ImageView leftGrassView = new ImageView(context);
        leftGrassView.setBackgroundResource(R.drawable.home_learn_grass_left);
        LayoutParams leftGrassParams = new LayoutParams(UiUtil.div(63), UiUtil.div(241));
        leftGrassParams.leftMargin = UiUtil.div(71);
        leftGrassParams.topMargin = UiUtil.div(38);
        addView(leftGrassView, leftGrassParams);
        PropertyValuesHolder leftGrassScaleX = PropertyValuesHolder.ofFloat("scaleX", 1, 1.05f, 1);
        PropertyValuesHolder leftGrassScaleY = PropertyValuesHolder.ofFloat("scaleY", 1, 1.05f, 1);
        ObjectAnimator leftGrassScale = ObjectAnimator.ofPropertyValuesHolder(leftGrassView, leftGrassScaleX, leftGrassScaleY).setDuration(time);
        leftGrassScale.setRepeatCount(ValueAnimator.INFINITE);
        list.add(leftGrassScale);

        ImageView rightGrassView = new ImageView(context);
        rightGrassView.setBackgroundResource(R.drawable.home_learn_grass_right);
        LayoutParams rightGrassParams = new LayoutParams(UiUtil.div(35), UiUtil.div(222));
        rightGrassParams.leftMargin = UiUtil.div(419);
        rightGrassParams.topMargin = UiUtil.div(37);
        addView(rightGrassView, rightGrassParams);
        PropertyValuesHolder rightGrassScaleX = PropertyValuesHolder.ofFloat("scaleX", 1, 1.05f, 1);
        PropertyValuesHolder rightGrassScaleY = PropertyValuesHolder.ofFloat("scaleY", 1, 1.05f, 1);
        ObjectAnimator rightGrassScale = ObjectAnimator.ofPropertyValuesHolder(rightGrassView, rightGrassScaleX, rightGrassScaleY).setDuration(time);
        rightGrassScale.setRepeatCount(ValueAnimator.INFINITE);
        list.add(rightGrassScale);

        ImageView shellView = new ImageView(context);
        shellView.setBackgroundResource(R.drawable.home_learn_shell);
        LayoutParams shellParams = new LayoutParams(UiUtil.div(540), UiUtil.div(500));
        addView(shellView, shellParams);

        ImageView leftEyeView = new ImageView(context);
        leftEyeView.setBackgroundResource(R.drawable.home_learn_eye);
        LayoutParams leftEyeParams = new LayoutParams(UiUtil.div(25), UiUtil.div(26));
        leftEyeParams.leftMargin = UiUtil.div(383);
        leftEyeParams.topMargin = UiUtil.div(207);
        addView(leftEyeView, leftEyeParams);
        ObjectAnimator leftEyeA = ObjectAnimator.ofFloat(leftEyeView, "alpha", 0, 0, 0, 0, 1, 1, 1, 1).setDuration(time);
        leftEyeA.setRepeatCount(ValueAnimator.INFINITE);
        list.add(leftEyeA);

        ImageView rightEyeView = new ImageView(context);
        rightEyeView.setBackgroundResource(R.drawable.home_learn_eye);
        LayoutParams rightEyeParams = new LayoutParams(UiUtil.div(25), UiUtil.div(26));
        rightEyeParams.leftMargin = UiUtil.div(413);
        rightEyeParams.topMargin = UiUtil.div(208);
        addView(rightEyeView, rightEyeParams);
        ObjectAnimator rightEyeA = ObjectAnimator.ofFloat(rightEyeView, "alpha", 0, 0,0, 0, 1, 1,1, 1).setDuration(time);
        rightEyeA.setRepeatCount(ValueAnimator.INFINITE);
        list.add(rightEyeA);

        ImageView stickView = new ImageView(context);
        stickView.setBackgroundResource(R.drawable.home_learn_stick);
        LayoutParams stickParams = new LayoutParams(UiUtil.div(39), UiUtil.div(81));
        stickParams.leftMargin = UiUtil.div(320);
        stickParams.topMargin = UiUtil.div(118);
        addView(stickView, stickParams);

        ImageView leftOneView = new ImageView(context);
        leftOneView.setBackgroundResource(R.drawable.home_learn_one);
        LayoutParams leftOneParams = new LayoutParams(UiUtil.div(21), UiUtil.div(32));
        leftOneParams.leftMargin = UiUtil.div(208);
        leftOneParams.topMargin = UiUtil.div(100);
        addView(leftOneView, leftOneParams);
        ObjectAnimator leftOneA = ObjectAnimator.ofFloat(leftOneView, "alpha", 0, 1, 1, 1, 1, 1).setDuration(time);
        leftOneA.setRepeatCount(ValueAnimator.INFINITE);
        list.add(leftOneA);

        ImageView addSymbolView = new ImageView(context);
        addSymbolView.setBackgroundResource(R.drawable.home_learn_add);
        LayoutParams addParams = new LayoutParams(UiUtil.div(35), UiUtil.div(30));
        addParams.leftMargin = UiUtil.div(222);
        addParams.topMargin = UiUtil.div(102);
        addView(addSymbolView, addParams);
        ObjectAnimator addA = ObjectAnimator.ofFloat(addSymbolView, "alpha", 0, 0, 1, 1, 1, 1).setDuration(time);
        addA.setRepeatCount(ValueAnimator.INFINITE);
        list.add(addA);

        ImageView rightOneView = new ImageView(context);
        rightOneView.setBackgroundResource(R.drawable.home_learn_one);
        LayoutParams rightOneParams = new LayoutParams(UiUtil.div(26), UiUtil.div(32));
        rightOneParams.leftMargin = UiUtil.div(250);
        rightOneParams.topMargin = UiUtil.div(100);
        addView(rightOneView, rightOneParams);
        ObjectAnimator rightOneA = ObjectAnimator.ofFloat(rightOneView, "alpha", 0, 0, 0, 1, 1, 1).setDuration(time);
        rightOneA.setRepeatCount(ValueAnimator.INFINITE);
        list.add(rightOneA);

        ImageView equalView = new ImageView(context);
        equalView.setBackgroundResource(R.drawable.home_learn_equal);
        LayoutParams equalParams = new LayoutParams(UiUtil.div(36), UiUtil.div(22));
        equalParams.leftMargin = UiUtil.div(269);
        equalParams.topMargin = UiUtil.div(106);
        addView(equalView, equalParams);
        ObjectAnimator equalA = ObjectAnimator.ofFloat(equalView, "alpha", 0, 0, 0, 0, 1, 1).setDuration(time);
        equalA.setRepeatCount(ValueAnimator.INFINITE);
        list.add(equalA);

        ImageView twoView = new ImageView(context);
        twoView.setBackgroundResource(R.drawable.home_learn_two);
        LayoutParams twoParams = new LayoutParams(UiUtil.div(31), UiUtil.div(33));
        twoParams.leftMargin = UiUtil.div(299);
        twoParams.topMargin = UiUtil.div(99);
        addView(twoView, twoParams);
        ObjectAnimator twoA = ObjectAnimator.ofFloat(twoView, "alpha", 0, 0, 0, 0, 0, 1).setDuration(time);
        twoA.setRepeatCount(ValueAnimator.INFINITE);
        list.add(twoA);

    }
}
