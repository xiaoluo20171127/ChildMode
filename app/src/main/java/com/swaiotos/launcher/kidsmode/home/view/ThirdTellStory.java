package com.swaiotos.launcher.kidsmode.home.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
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
public class ThirdTellStory extends FrameLayout {
    int time = 2000;
    public ThirdTellStory(@NonNull Context context, ArrayList<Animator> list) {
        super(context);
        initView(context,list);
    }

    private void initView(Context context,ArrayList<Animator> list) {
        setLayoutParams(new ViewGroup.LayoutParams(UiUtil.div(487),UiUtil.div(487)));
        ObjectAnimator layoutT = ObjectAnimator.ofFloat(this,"translationY",0,10,0).setDuration(time);
        layoutT.setRepeatCount(ValueAnimator.INFINITE);
        list.add(layoutT);

        ImageView islandView = new ImageView(context);
        LayoutParams islandParams = new LayoutParams(UiUtil.div(486),UiUtil.div(261));
        islandParams.leftMargin = 0;
        islandParams.topMargin = UiUtil.div(204);
        islandView.setBackgroundResource(R.drawable.home_tell_island);
        addView(islandView,islandParams);

        ImageView flowerView = new ImageView(context);
        flowerView.setBackgroundResource(R.drawable.home_tell_flower);
        LayoutParams flowerParams = new LayoutParams(UiUtil.div(142),UiUtil.div(252));
        flowerParams.leftMargin = UiUtil.div(27);
        flowerParams.topMargin = UiUtil.div(4);
        addView(flowerView,flowerParams);
        PropertyValuesHolder flowerScaleX = PropertyValuesHolder.ofFloat("scaleX",1,1.05f,1);
        PropertyValuesHolder flowerScaleY = PropertyValuesHolder.ofFloat("scaleY",1,1.05f,1);
        ObjectAnimator grassScale = ObjectAnimator.ofPropertyValuesHolder(flowerView,flowerScaleX,flowerScaleY).setDuration(time);
        grassScale.setRepeatCount(ValueAnimator.INFINITE);
        list.add(grassScale);

        ImageView animalView = new ImageView(context);
        animalView.setBackgroundResource(R.drawable.home_tell_animal);
        LayoutParams animalParams = new LayoutParams(UiUtil.div(487),UiUtil.div(487));
        addView(animalView,animalParams);



        ImageView firstPageView = new ImageView(context);
        LayoutParams firstPageParams = new LayoutParams(UiUtil.div(85),UiUtil.div(60));
        firstPageParams.leftMargin = UiUtil.div(81);
        firstPageParams.topMargin = UiUtil.div(248);
        firstPageView.setBackgroundResource(R.drawable.home_tell_page_first);
        addView(firstPageView,firstPageParams);
        ObjectAnimator firstPageA = ObjectAnimator.ofFloat(firstPageView, "alpha", 0,0,0,0,1f,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0).setDuration(1500);
        firstPageA.setRepeatCount(ValueAnimator.INFINITE);
        list.add(firstPageA);


        ImageView secondPageView = new ImageView(context);
        LayoutParams secondPageParams = new LayoutParams(UiUtil.div(28),UiUtil.div(79));
        secondPageParams.leftMargin = UiUtil.div(151);
        secondPageParams.topMargin = UiUtil.div(226);
        addView(secondPageView,secondPageParams);
        secondPageView.setBackgroundResource(R.drawable.home_tell_page_second);
        secondPageView.setAlpha(0f);
        ObjectAnimator secondPageA = ObjectAnimator.ofFloat(secondPageView, "alpha", 0,0,0,0,0,0,0,0,1,1,1,1f,0,0,0,0,0,0,0,0).setDuration(1500);
        secondPageA.setRepeatCount(ValueAnimator.INFINITE);
        list.add(secondPageA);


        ImageView thirdPageView = new ImageView(context);
        LayoutParams thirdPageParams = new LayoutParams(UiUtil.div(88),UiUtil.div(52));
        thirdPageParams.leftMargin = UiUtil.div(178);
        thirdPageParams.topMargin = UiUtil.div(247);
        thirdPageView.setBackgroundResource(R.drawable.home_tell_page_third);
        addView(thirdPageView,thirdPageParams);
        thirdPageView.setAlpha(0f);
        ObjectAnimator thirdPageA = ObjectAnimator.ofFloat(thirdPageView, "alpha", 0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1f,0,0,0,0).setDuration(1500);
        thirdPageA.setRepeatCount(ValueAnimator.INFINITE);
        list.add(thirdPageA);

        ImageView bookView = new ImageView(context);
        LayoutParams bookParams = new LayoutParams(UiUtil.div(235),UiUtil.div(48));
        bookParams.leftMargin = UiUtil.div(52);
        bookParams.topMargin = UiUtil.div(269);
        bookView.setBackgroundResource(R.drawable.home_tell_book);
        addView(bookView,bookParams);


    }
}
