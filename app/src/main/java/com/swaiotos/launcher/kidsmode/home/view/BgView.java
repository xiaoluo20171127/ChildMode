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
 * @ Created on: 2020/2/26
 * @Author: LEGION XiaoLuo
 * @ Description:
 */
public class BgView extends FrameLayout {
    int time_s = 1000;
    int time = 2000;

    public BgView(@NonNull Context context, ArrayList<Animator> list) {
        super(context);
        initView(context, list);
    }

    private void initView(Context context, ArrayList<Animator> list) {
        setLayoutParams(new ViewGroup.LayoutParams(UiUtil.div(1920), UiUtil.div(1200)));
        setBackgroundResource(R.drawable.home_bg_static);

        ImageView cloudView = new ImageView(context);
        cloudView.setImageResource(R.drawable.home_bg_cloud);
        LayoutParams cloudParams = new LayoutParams(UiUtil.div(1920), UiUtil.div(439));
        cloudParams.leftMargin = 0;
        cloudParams.topMargin = 0;
        addView(cloudView, cloudParams);
        ObjectAnimator cloudA = ObjectAnimator.ofFloat(cloudView, "translationX", 0, 12, 0).setDuration(time);
        cloudA.setRepeatCount(ValueAnimator.INFINITE);
        list.add(cloudA);

        ImageView leftBirdView = new ImageView(context);
        leftBirdView.setBackgroundResource(R.drawable.home_bg_bird_one);
        LayoutParams leftBirdParams = new LayoutParams(UiUtil.div(31), UiUtil.div(22));
        leftBirdParams.leftMargin = UiUtil.div(698);
        leftBirdParams.topMargin = UiUtil.div(275);
        addView(leftBirdView, leftBirdParams);
        PropertyValuesHolder leftBirdScaleX = PropertyValuesHolder.ofFloat("scaleX", 1, 0.8f, 1);
        PropertyValuesHolder leftBirdScaleY = PropertyValuesHolder.ofFloat("scaleY", 1, 0.8f, 1);
        ObjectAnimator leftBirdScale = ObjectAnimator.ofPropertyValuesHolder(leftBirdView, leftBirdScaleX, leftBirdScaleY).setDuration(time_s);
        leftBirdScale.setRepeatCount(ValueAnimator.INFINITE);
        list.add(leftBirdScale);

        ImageView middleBirdView = new ImageView(context);
        middleBirdView.setBackgroundResource(R.drawable.home_bg_bird_two);
        LayoutParams middleBirdParams = new LayoutParams(UiUtil.div(31), UiUtil.div(22));
        middleBirdParams.leftMargin = UiUtil.div(1264);
        middleBirdParams.topMargin = UiUtil.div(127);
        addView(middleBirdView, middleBirdParams);
        PropertyValuesHolder middleBirdScaleX = PropertyValuesHolder.ofFloat("scaleX", 1, 0.6f, 1);
        PropertyValuesHolder middleBirdScaleY = PropertyValuesHolder.ofFloat("scaleY", 1, 0.6f, 1);
        ObjectAnimator middleBirdScale = ObjectAnimator.ofPropertyValuesHolder(middleBirdView, middleBirdScaleX, middleBirdScaleY).setDuration(time_s);
        middleBirdScale.setRepeatCount(ValueAnimator.INFINITE);
        list.add(middleBirdScale);

        ImageView rightBirdView = new ImageView(context);
        rightBirdView.setBackgroundResource(R.drawable.home_bg_bird_three);
        LayoutParams rightBirdParams = new LayoutParams(UiUtil.div(26), UiUtil.div(16));
        rightBirdParams.leftMargin = UiUtil.div(1597);
        rightBirdParams.topMargin = UiUtil.div(250);
        addView(rightBirdView, rightBirdParams);
        PropertyValuesHolder rightBirdScaleX = PropertyValuesHolder.ofFloat("scaleX", 1, 0.6f, 1);
        PropertyValuesHolder rightBirdScaleY = PropertyValuesHolder.ofFloat("scaleY", 1, 0.6f, 1);
        ObjectAnimator rightBirdScale = ObjectAnimator.ofPropertyValuesHolder(rightBirdView, rightBirdScaleX, rightBirdScaleY).setDuration(time_s);
        rightBirdScale.setRepeatCount(ValueAnimator.INFINITE);
        list.add(rightBirdScale);

        ImageView firstFishView = new ImageView(context);
        LayoutParams firstFishParams = new LayoutParams(UiUtil.div(1920), UiUtil.div(478));
        firstFishParams.leftMargin = 0;
        firstFishParams.topMargin = UiUtil.div(720);
        firstFishView.setImageResource(R.drawable.home_bg_fish);
        addView(firstFishView, firstFishParams);
        Keyframe k0 = Keyframe.ofFloat(0, 0);
        Keyframe k1 = Keyframe.ofFloat(0.05f, 0);
        Keyframe k2 = Keyframe.ofFloat(0.13f, -500);
        Keyframe k3 = Keyframe.ofFloat(0.18f, -500);
        Keyframe k4 = Keyframe.ofFloat(0.26f, -1000);
        Keyframe k5 = Keyframe.ofFloat(0.31f, -1000);
        Keyframe k6 = Keyframe.ofFloat(0.39f, -1500);
        Keyframe k7 = Keyframe.ofFloat(0.44f, -1500);
        Keyframe k8 = Keyframe.ofFloat(0.52f, -2000);
        Keyframe k9 = Keyframe.ofFloat(0.53f, 2000);
        Keyframe k10 = Keyframe.ofFloat(0.61f, 1500);
        Keyframe k11 = Keyframe.ofFloat(0.66f, 1500);
        Keyframe k12 = Keyframe.ofFloat(0.74f, 1000);
        Keyframe k13 = Keyframe.ofFloat(0.79f, 1000);
        Keyframe k14 = Keyframe.ofFloat(0.87f, 500);
        Keyframe k15 = Keyframe.ofFloat(0.92f, 500);
        Keyframe k16 = Keyframe.ofFloat(1f, 0);

        Keyframe k17 = Keyframe.ofFloat(0, 1);
        Keyframe k18 = Keyframe.ofFloat(0.13f, 0.5f);
        Keyframe k19 = Keyframe.ofFloat(0.51f, 0.5f);
        Keyframe k20 = Keyframe.ofFloat(0.52f, 0f);
        Keyframe k21 = Keyframe.ofFloat(0.53f, 0f);
        Keyframe k22 = Keyframe.ofFloat(0.53f, 1f);
        Keyframe k23 = Keyframe.ofFloat(0.61f, 0.5f);

        PropertyValuesHolder firstX = PropertyValuesHolder.ofKeyframe("translationX", k0, k1, k2, k3, k4, k5, k6, k7, k8, k9, k10, k11, k12, k13, k14, k15, k16);
        PropertyValuesHolder firstA = PropertyValuesHolder.ofKeyframe("alpha", k17, k18, k19, k20, k21, k22, k23);
        ObjectAnimator firstFishA = ObjectAnimator.ofPropertyValuesHolder(firstFishView, firstA, firstX).setDuration(12000);
        firstFishA.setRepeatCount(ValueAnimator.INFINITE);
        list.add(firstFishA);


//        ImageView twoFishView = new ImageView(context);
//        twoFishView.setScaleType(ImageView.ScaleType.FIT_XY);
//        twoFishView.setImageResource(R.drawable.home_bg_fish);
//        LayoutParams twoFishParams = new LayoutParams(UiUtil.div(1920), UiUtil.div(308));
//        twoFishParams.leftMargin = UiUtil.div(1920);
//        twoFishParams.topMargin = UiUtil.div(720);
//        addView(twoFishView, twoFishParams);
//        ObjectAnimator twoFishX = ObjectAnimator.ofFloat(twoFishView, "translationX", 0, 0, 0, 0, 0, 0, 0, -500, -500, -500, -1000, -1000, -1000, -1500, -1500, -1500, -1920, -1920, -1920, -2500, -2500, -2500, -3000, -3000, -3000, -3500, -3500, -3500, -3840, -3840, 0).setDuration(12000);
//        twoFishX.setRepeatCount(ValueAnimator.INFINITE);
//        ObjectAnimator twoFishA = ObjectAnimator.ofFloat(twoFishView, "alpha", 1, 1, 1, 1, 1f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0f, 0f).setDuration(12000);
//        twoFishA.setRepeatCount(ValueAnimator.INFINITE);

        ImageView waterView = new ImageView(context);
        waterView.setImageResource(R.drawable.home_bg_water);
        LayoutParams waterParams = new LayoutParams(UiUtil.div(1920), UiUtil.div(547));
        waterParams.leftMargin = UiUtil.div(0);
        waterParams.topMargin = UiUtil.div(653);
        addView(waterView, waterParams);
        ObjectAnimator waterA = ObjectAnimator.ofFloat(waterView, "translationX", 0, 12, 0).setDuration(time);
        waterA.setRepeatCount(ValueAnimator.INFINITE);
        list.add(waterA);

        ImageView firstCircle = new ImageView(context);
        firstCircle.setImageResource(R.drawable.home_bg_circle_f);
        LayoutParams firstCircleParams = new LayoutParams(UiUtil.div(536), UiUtil.div(197));
        firstCircleParams.leftMargin = UiUtil.div(151);
        firstCircleParams.topMargin = UiUtil.div(634);
        addView(firstCircle, firstCircleParams);
        PropertyValuesHolder firstCircleScaleX = PropertyValuesHolder.ofFloat("scaleX", 1, 1.05f, 1);
        PropertyValuesHolder firstCircleScaleY = PropertyValuesHolder.ofFloat("scaleY", 1, 1.05f, 1);
        ObjectAnimator firstCircleScale = ObjectAnimator.ofPropertyValuesHolder(firstCircle, firstCircleScaleX, firstCircleScaleY).setDuration(time);
        firstCircleScale.setRepeatCount(ValueAnimator.INFINITE);
        list.add(firstCircleScale);

        ImageView twoCircleView = new ImageView(context);
        twoCircleView.setBackgroundResource(R.drawable.home_bg_circle_two);
        LayoutParams twoCircleParams = new LayoutParams(UiUtil.div(605), UiUtil.div(189));
        twoCircleParams.leftMargin = UiUtil.div(605);
        twoCircleParams.topMargin = UiUtil.div(869);
        addView(twoCircleView, twoCircleParams);
        PropertyValuesHolder twoCircleScaleX = PropertyValuesHolder.ofFloat("scaleX", 1.07f, 1f, 1.07f);
        PropertyValuesHolder twoCircleScaleY = PropertyValuesHolder.ofFloat("scaleY", 1.07f, 1f, 1.07f);
        ObjectAnimator twoCircleScale = ObjectAnimator.ofPropertyValuesHolder(twoCircleView, twoCircleScaleX, twoCircleScaleY).setDuration(time);
        twoCircleScale.setRepeatCount(ValueAnimator.INFINITE);
        list.add(twoCircleScale);

        ImageView threeCircleView = new ImageView(context);
        threeCircleView.setBackgroundResource(R.drawable.home_bg_circle_three);
        LayoutParams threeCircleParams = new LayoutParams(UiUtil.div(403), UiUtil.div(147));
        threeCircleParams.leftMargin = UiUtil.div(937);
        threeCircleParams.topMargin = UiUtil.div(580);
        addView(threeCircleView, threeCircleParams);
        PropertyValuesHolder threeCircleScaleX = PropertyValuesHolder.ofFloat("scaleX", 1, 1.02f, 1);
        PropertyValuesHolder threeCircleScaleY = PropertyValuesHolder.ofFloat("scaleY", 1, 1.02f, 1);
        ObjectAnimator threeCircleScale = ObjectAnimator.ofPropertyValuesHolder(threeCircleView, threeCircleScaleX, threeCircleScaleY).setDuration(time);
        threeCircleScale.setRepeatCount(ValueAnimator.INFINITE);
        list.add(threeCircleScale);

        ImageView fourCircleView = new ImageView(context);
        fourCircleView.setBackgroundResource(R.drawable.home_bg_circle_four);
        LayoutParams fourCircleParams = new LayoutParams(UiUtil.div(515), UiUtil.div(204));
        fourCircleParams.leftMargin = UiUtil.div(1245);
        fourCircleParams.topMargin = UiUtil.div(800);
        addView(fourCircleView, fourCircleParams);
        PropertyValuesHolder fourCircleScaleX = PropertyValuesHolder.ofFloat("scaleX", 1.05f, 1f, 1.05f);
        PropertyValuesHolder fourCircleScaleY = PropertyValuesHolder.ofFloat("scaleY", 1.05f, 1f, 1.05f);
        ObjectAnimator fourCircleScale = ObjectAnimator.ofPropertyValuesHolder(fourCircleView, fourCircleScaleX, fourCircleScaleY).setDuration(time);
        fourCircleScale.setRepeatCount(ValueAnimator.INFINITE);
        list.add(fourCircleScale);

    }
}
