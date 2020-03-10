package com.swaiotos.launcher.kidsmode.home.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.swaiotos.common.ui.UiUtil;
import com.swaiotos.launcher.kidsmode.R;

import java.util.ArrayList;

/**
 * @ Created on: 2020/1/9
 * @Author: LEGION XiaoLuo
 * @ Description:
 */
public class HomePageView extends FrameLayout implements IHomePageView {
    Context mContext;
    public FrameLayout mBgView;
    public ImageView mExitParentModeView;
    public ImageView mParentSetView;
    public FrameLayout mFirstSeeView;
    public FrameLayout mSecondListenView;
    public FrameLayout mThreeTalkView;
    public FrameLayout mFourLearnView;
    public ImageView mStoreView;
    public ImageView mMyAppView;
    public ArrayList<Animator> mAnimatorList;
    private AnimatorSet mSet;

    public HomePageView(Context context) {
        super(context);
        mContext = context;
        mAnimatorList = new ArrayList<>();
        initView();
    }

    private void initView() {
        mBgView = new BgView(mContext, mAnimatorList);
        addView(mBgView);

        mExitParentModeView = new ImageView(mContext);
        LayoutParams exitParams = new LayoutParams(UiUtil.div(468), UiUtil.div(213));
        exitParams.leftMargin = UiUtil.div(30);
        exitParams.topMargin = UiUtil.div(0);
        mExitParentModeView.setBackgroundResource(R.drawable.home_bg_exit);
        addView(mExitParentModeView, exitParams);

        mParentSetView = new ImageView(mContext);
        LayoutParams setParams = new LayoutParams(UiUtil.div(406), UiUtil.div(213));
        setParams.leftMargin = UiUtil.div(498);
        setParams.topMargin = UiUtil.div(0);
        mParentSetView.setBackgroundResource(R.drawable.home_bg_set);
        addView(mParentSetView, setParams);

        mFirstSeeView = new FirstSeeAnimationView(mContext, mAnimatorList);
        LayoutParams seeParams = new LayoutParams(UiUtil.div(515), UiUtil.div(533));
        seeParams.leftMargin = UiUtil.div(147);
        seeParams.topMargin = UiUtil.div(290);
        addView(mFirstSeeView, seeParams);

        mThreeTalkView = new ThirdTellStory(mContext, mAnimatorList);
        LayoutParams talkParams = new LayoutParams(UiUtil.div(485), UiUtil.div(502));
        talkParams.leftMargin = UiUtil.div(898);
        talkParams.topMargin = UiUtil.div(225);
        addView(mThreeTalkView, talkParams);

        mSecondListenView = new SecondListenSongView(mContext, mAnimatorList);
        LayoutParams listenParams = new LayoutParams(UiUtil.div(607), UiUtil.div(627));
        listenParams.leftMargin = UiUtil.div(603);
        listenParams.topMargin = UiUtil.div(462);
        addView(mSecondListenView, listenParams);

        mFourLearnView = new FourLearnKnowView(mContext, mAnimatorList);
        LayoutParams learnParams = new LayoutParams(UiUtil.div(539), UiUtil.div(500));
        learnParams.leftMargin = UiUtil.div(1244);
        learnParams.topMargin = UiUtil.div(506);
        addView(mFourLearnView, learnParams);

        ImageView tabView = new ImageView(mContext);
        LayoutParams tabParams = new LayoutParams(UiUtil.div(509), UiUtil.div(156));
        tabParams.topMargin = UiUtil.div(1043);
        tabParams.leftMargin = UiUtil.div(1411);
        tabView.setBackgroundResource(R.drawable.home_bg_bottom_tab);
        addView(tabView, tabParams);

        mStoreView = new ImageView(mContext);
        LayoutParams storeParams = new LayoutParams(UiUtil.div(171), UiUtil.div(153));
        storeParams.leftMargin = UiUtil.div(1518);
        storeParams.topMargin = UiUtil.div(1043);
        mStoreView.setBackgroundResource(R.drawable.home_bg_store);
        addView(mStoreView, storeParams);

        mMyAppView = new ImageView(mContext);
        LayoutParams myAppParams = new LayoutParams(UiUtil.div(171), UiUtil.div(153));
        myAppParams.leftMargin = UiUtil.div(1721);
        myAppParams.topMargin = UiUtil.div(1043);
        mMyAppView.setBackgroundResource(R.drawable.home_bg_myapp);
        addView(mMyAppView, myAppParams);

        mSet = new AnimatorSet();
        mSet.playTogether(mAnimatorList);
        mSet.start();

    }

    @Override
    public View getView() {
        return this;
    }


    @Override
    public void destroy() {
        mSet.cancel();
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public void onResume() {
        if (mSet.isPaused()) {
            mSet.resume();
        }
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public void onStop() {
        if (mSet.isRunning()) {
            mSet.pause();
        }
    }
}
