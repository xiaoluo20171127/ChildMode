package com.swaiotos.launcher.kidsmode.home.view;

import android.animation.Animator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
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
public class SecondListenSongView extends FrameLayout {
    int time = 2000;

    public SecondListenSongView(@NonNull Context context, ArrayList<Animator> list) {
        super(context);
        initView(context, list);
    }

    private void initView(Context context, ArrayList<Animator> list) {
        setLayoutParams(new ViewGroup.LayoutParams(UiUtil.div(607), UiUtil.div(627)));

        ImageView hornBack = new ImageView(context);
        LayoutParams hornBackParams = new LayoutParams(UiUtil.div(137), UiUtil.div(150));
        hornBackParams.leftMargin = UiUtil.div(128);
        hornBackParams.topMargin = UiUtil.div(19);
        hornBack.setBackgroundResource(R.drawable.home_listen_horn_back);
        addView(hornBack, hornBackParams);
        PropertyValuesHolder hornBackScaleX = PropertyValuesHolder.ofFloat("scaleX", 1, 1.08f, 1);
        PropertyValuesHolder hornBackScaleY = PropertyValuesHolder.ofFloat("scaleY", 1, 1.08f, 1);
        ObjectAnimator tvA = ObjectAnimator.ofPropertyValuesHolder(hornBack, hornBackScaleX, hornBackScaleY).setDuration(time);
        tvA.setRepeatCount(ValueAnimator.INFINITE);
        list.add(tvA);

        ImageView noteTopView = new ImageView(context);
        LayoutParams noteTopParams = new LayoutParams(UiUtil.div(78), UiUtil.div(63));
        noteTopParams.leftMargin = UiUtil.div(135);
        noteTopParams.topMargin = UiUtil.div(0);
        noteTopView.setBackgroundResource(R.drawable.home_listen_note_top);
        addView(noteTopView, noteTopParams);
        ObjectAnimator noteTopR = ObjectAnimator.ofFloat(noteTopView, "rotation", 0f, 34f, 0).setDuration(time);
        noteTopR.setRepeatCount(ValueAnimator.INFINITE);
        list.add(noteTopR);

        ImageView bgView = new ImageView(context);
        LayoutParams bgParams = new LayoutParams(UiUtil.div(607), UiUtil.div(627));
        addView(bgView, bgParams);
        bgView.setBackgroundResource(R.drawable.home_listen_bg);
        ObjectAnimator layoutT = ObjectAnimator.ofFloat(this, "translationY", 0, -10, 0).setDuration(time);
        layoutT.setRepeatCount(ValueAnimator.INFINITE);
        list.add(layoutT);


        ImageView noteLeftTwoView = new ImageView(context);
        LayoutParams noteLeftTwoParams = new LayoutParams(UiUtil.div(59), UiUtil.div(63));
        noteLeftTwoParams.topMargin = UiUtil.div(161);
        noteLeftTwoParams.leftMargin = UiUtil.div(25);
        noteLeftTwoView.setBackgroundResource(R.drawable.home_listen_note_left_two);
        addView(noteLeftTwoView, noteLeftTwoParams);
        ObjectAnimator noteLeftTwoR = ObjectAnimator.ofFloat(noteLeftTwoView, "rotation", 0f, -28f, 0).setDuration(time);
        noteLeftTwoR.setRepeatCount(ValueAnimator.INFINITE);
        list.add(noteLeftTwoR);

        ImageView hornBeforeView = new ImageView(context);
        LayoutParams hornBeforeParams = new LayoutParams(UiUtil.div(163), UiUtil.div(130));
        hornBeforeParams.leftMargin = UiUtil.div(49);
        hornBeforeParams.topMargin = UiUtil.div(302);
        hornBeforeView.setBackgroundResource(R.drawable.home_listen_horn_before);
        addView(hornBeforeView, hornBeforeParams);
        PropertyValuesHolder hornBeforeScaleX = PropertyValuesHolder.ofFloat("scaleX", 1, 1.08f, 1);
        PropertyValuesHolder hornBeforeScaleY = PropertyValuesHolder.ofFloat("scaleY", 1, 1.08f, 1);
        ObjectAnimator hornBeforeScale = ObjectAnimator.ofPropertyValuesHolder(hornBeforeView, hornBeforeScaleX, hornBeforeScaleY).setDuration(time);
        hornBeforeScale.setRepeatCount(ValueAnimator.INFINITE);
        list.add(hornBeforeScale);


        ImageView noteLeftOneView = new ImageView(context);
        LayoutParams noteLeftOneParams = new LayoutParams(UiUtil.div(43), UiUtil.div(63));
        noteLeftOneParams.leftMargin = UiUtil.div(87);
        noteLeftOneParams.topMargin = UiUtil.div(271);
        noteLeftOneView.setBackgroundResource(R.drawable.home_listen_note_left_one);
        addView(noteLeftOneView, noteLeftOneParams);
        ObjectAnimator noteLeftOneR = ObjectAnimator.ofFloat(noteLeftOneView, "rotation", 0f, 12f, 0).setDuration(time);
        noteLeftOneR.setRepeatCount(ValueAnimator.INFINITE);
        list.add(noteLeftOneR);

        ImageView grassView = new ImageView(context);
        LayoutParams grassParams = new LayoutParams(UiUtil.div(136), UiUtil.div(94));
        grassParams.leftMargin = UiUtil.div(108);
        grassParams.topMargin = UiUtil.div(354);
        grassView.setBackgroundResource(R.drawable.home_listen_grass);
        addView(grassView, grassParams);
//        PropertyValuesHolder grassScaleX = PropertyValuesHolder.ofFloat("scaleX", 1, 1.08f, 1);
//        PropertyValuesHolder grassScaleY = PropertyValuesHolder.ofFloat("scaleY", 1, 1.08f, 1);
//        ObjectAnimator grassScale = ObjectAnimator.ofPropertyValuesHolder(grassView, grassScaleX, grassScaleY).setDuration(time);
//        grassScale.setRepeatCount(ValueAnimator.INFINITE);
//        list.add(grassScale);

        ImageView starView = new ImageView(context);
        LayoutParams starParams = new LayoutParams(UiUtil.div(115), UiUtil.div(88));
        starParams.leftMargin = UiUtil.div(293);
        starParams.topMargin = UiUtil.div(439);
        starView.setBackgroundResource(R.drawable.home_listen_star);
        addView(starView, starParams);
        Keyframe s0 = Keyframe.ofFloat(0, 0);
        Keyframe s1 = Keyframe.ofFloat(0.1f, 0);
        Keyframe s2 = Keyframe.ofFloat(0.275f, 50);
        Keyframe s3 = Keyframe.ofFloat(0.45f, 100);
        Keyframe s4 = Keyframe.ofFloat(0.65f, 100);
        Keyframe s5 = Keyframe.ofFloat(0.825f, 50);
        Keyframe s6 = Keyframe.ofFloat(1f, 0);
        PropertyValuesHolder starXT = PropertyValuesHolder.ofKeyframe("translationX", s0, s1, s2, s3, s4, s5, s6);
        Keyframe s7 = Keyframe.ofFloat(0, 0);
        Keyframe s8 = Keyframe.ofFloat(0.1f, 0);
        Keyframe s9 = Keyframe.ofFloat(0.275f, -18);
        Keyframe s10 = Keyframe.ofFloat(0.45f, -36);
        Keyframe s11 = Keyframe.ofFloat(0.65f, -36);
        Keyframe s12 = Keyframe.ofFloat(0.825f, -18);
        Keyframe s13 = Keyframe.ofFloat(1f, 0);
        PropertyValuesHolder starYT = PropertyValuesHolder.ofKeyframe("translationY", s7, s8, s9, s10, s11, s12, s13);
        Keyframe s14 = Keyframe.ofFloat(0, 0);
        Keyframe s15 = Keyframe.ofFloat(0.1f, 0);
        Keyframe s16 = Keyframe.ofFloat(0.275f, 0);
        Keyframe s17 = Keyframe.ofFloat(0.45f, 10);
        Keyframe s18 = Keyframe.ofFloat(0.65f, 10);
        Keyframe s19 = Keyframe.ofFloat(0.825f, 0);
        Keyframe s20 = Keyframe.ofFloat(1f, 0);
        PropertyValuesHolder starR = PropertyValuesHolder.ofKeyframe("rotation", s14, s15, s16, s17, s18, s19, s20);
        ObjectAnimator starA = ObjectAnimator.ofPropertyValuesHolder(starView, starXT, starYT, starR).setDuration(6000);
        starA.setRepeatCount(ValueAnimator.INFINITE);
        list.add(starA);

        ImageView signView = new ImageView(context);
        LayoutParams signParams = new LayoutParams(UiUtil.div(369), UiUtil.div(162));
        signParams.leftMargin = UiUtil.div(223);
        signParams.topMargin = UiUtil.div(462);
        signView.setImageResource(R.drawable.home_listen_sign);
        addView(signView, signParams);

        ImageView noteRightView = new ImageView(context);
        LayoutParams noteRightParams = new LayoutParams(UiUtil.div(38), UiUtil.div(57));
        noteRightParams.leftMargin = UiUtil.div(494);
        noteRightParams.topMargin = UiUtil.div(164);
        noteRightView.setBackgroundResource(R.drawable.home_listen_note_left_one);
        addView(noteRightView, noteRightParams);
        ObjectAnimator noteRightR = ObjectAnimator.ofFloat(noteRightView, "rotation", 0f, 10f, 0).setDuration(time);
        noteRightR.setRepeatCount(ValueAnimator.INFINITE);
        list.add(noteRightR);

    }
}
