package com.swaiotos.launcher.kidsmode.home.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.swaiotos.common.http.HttpApi;
import com.swaiotos.common.http.HttpResult;
import com.swaiotos.common.http.HttpSubscribe;
import com.swaiotos.common.http.HttpThrowable;
import com.swaiotos.common.log.Logger;
import com.swaiotos.common.system.intent.IntentStarter;
import com.swaiotos.launcher.kidsmode.R;
import com.swaiotos.launcher.kidsmode.common.spconfig.SPConfig;
import com.swaiotos.launcher.kidsmode.common.spconfig.SPConfigFactory;
import com.swaiotos.launcher.kidsmode.common.util.NetworkUtil;
import com.swaiotos.launcher.kidsmode.common.util.PackageHelper;
import com.swaiotos.launcher.kidsmode.common.view.IParentModeCallBack;
import com.swaiotos.launcher.kidsmode.common.view.ParentModeDialog;
import com.swaiotos.launcher.kidsmode.home.model.HomePageData;
import com.swaiotos.launcher.kidsmode.home.model.HomePageModel;
import com.swaiotos.launcher.kidsmode.home.view.HomePageView;
import com.swaiotos.launcher.kidsmode.settings.parent.ParentSettingsUtil;
import com.swaiotos.launcher.kidsmode.settings.parent.service.FilterEventAction;
import com.swaiotos.launcher.kidsmode.settings.parent.view.ParentSettingsActivity;
import com.swaiotos.launcher.kidsmode.timehint.TimeHintActivity;


/**
 * @ Created on: 2020/1/9
 * @Author: LEGION XiaoLuo
 * @ Description:
 */
public class HomePagePresenter implements IHomePagePresenter {
    private static final String TAG = "HomePagePresenter";
    private static final String SAVE_DATA = "homepage_data";
    private static final String SAVE_DATA_KEY = "homepage_data_key";
    private Context mContext;
    private HomePageView mView;
    private HomePageData mPageData;
    private SPConfig mDownloadSPConfig;

    public HomePagePresenter(HomePageView view, Context context) {
        this.mView = view;
        this.mContext = context;
        mDownloadSPConfig = SPConfigFactory.get(context, SAVE_DATA);
        initView();
        subscribeFilterEvent(context);
    }

    private void subscribeFilterEvent (Context context) {

        FilterEventAction.subscribe(context);
    }

    private void initView() {
        mView.mFirstSeeView.setId(R.id.mFirstRecommend);
        mView.mFirstSeeView.setOnClickListener(mOnClickListener);

        mView.mSecondListenView.setId(R.id.mSecondRecommend);
        mView.mSecondListenView.setOnClickListener(mOnClickListener);

        mView.mThreeTalkView.setId(R.id.mThreeRecommend);
        mView.mThreeTalkView.setOnClickListener(mOnClickListener);

        mView.mFourLearnView.setId(R.id.mFourRecommend);
        mView.mFourLearnView.setOnClickListener(mOnClickListener);

        intentToStore();

        intentToMyApp();

        exitChildMode();

        intentToParentSet();
    }

    private void intentToMyApp() {
        mView.mMyAppView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeIntentUtil.intentToMyApp(mContext);
            }
        });
    }

    private void intentToStore() {
        mView.mStoreView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeIntentUtil.intentToStore(mContext);
            }
        });
    }

    private void exitChildMode() {
        mView.mExitParentModeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParentModeDialog dialog = new ParentModeDialog(mContext);
                dialog.initView(R.drawable.dialog_exit_child);
                dialog.setCallBack(new IParentModeCallBack() {
                    @Override
                    public void rightAnswer() {
                        FilterEventAction.unsubscribe(mContext);
                        if (mContext instanceof Activity) {
                            ((Activity) mContext).finish();
                        } else {
                            System.exit(0);
                        }
                    }

                    @Override
                    public void wrongAnswer() {

                    }
                });
                dialog.show();
            }
        });
    }

    private void intentToParentSet() {
        mView.mParentSetView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ParentModeDialog dialog = new ParentModeDialog(mContext);
                dialog.initView(R.drawable.dialog_parent_set);
                dialog.setCallBack(new IParentModeCallBack() {
                    @Override
                    public void rightAnswer() {
                        dialog.dismiss();
                        mContext.startActivity(new Intent(mContext, ParentSettingsActivity.class));
                    }

                    @Override
                    public void wrongAnswer() {

                    }
                });
                dialog.show();
            }
        });
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.mFirstRecommend:
                    recommendEvent(0);
                    break;
                case R.id.mSecondRecommend:
                    recommendEvent(1);
                    break;
                case R.id.mThreeRecommend:
                    recommendEvent(2);
                    break;
                case R.id.mFourRecommend:
                    recommendEvent(3);
                    break;
                default:
                    break;
            }
        }
    };

    private void recommendEvent(int site) {
        if (mPageData == null) {
            Logger.e(TAG, "homeData is null");
            return;
        }
        HomePageData.SubRecommendsBean subRecommendsBean = mPageData.getSubRecommends().get(site);
        String onClickEvent = subRecommendsBean.getOnclickEvent();
        parseClickEvent(onClickEvent);
    }

    private void parseClickEvent(String onClickEvent) {
        try {
            JSONObject jsonObject = JSON.parseObject(onClickEvent);
            String packageName = jsonObject.get("packagename").toString();

            if (jsonObject.get("minVersion") != null) {
                String minVersion = jsonObject.get("minVersion").toString();
                int minIntVersion = Integer.parseInt(minVersion);
                if (minIntVersion > PackageHelper.versionCode(mContext, packageName)) {
                    //与应用商店更新
                    HomeIntentUtil.intentToAppDetail(mContext, packageName);
                    return;
                }
            }
            if (PackageHelper.isAppInstall(mContext, packageName)) {
                //action启动
                IntentStarter.startActionByJson(onClickEvent, mContext);
            } else {
                //与应用商店交互
                HomeIntentUtil.intentToAppDetail(mContext, packageName);
            }
        } catch (NullPointerException e) {
            Logger.e(TAG, e.getMessage());
        }
    }


    @Override
    public void downloadData() {
        if (NetworkUtil.isOnline(mContext)) {
            HttpApi.getInstance().request(HomePageModel.SERVICE.getHomePageData(), new HttpSubscribe<HttpResult<HomePageData>>() {
                @Override
                public void onSuccess(HttpResult<HomePageData> result) {
                    HomePageData homePageData = result.data;
                    String jsonLocal = getLocalData();
                    if (isLoadNewData(jsonLocal, homePageData.getTimestamp())) {
                        Log.e(TAG, "load new data");
                        saveData(homePageData);
                        showData(homePageData);
                    } else {
                        Log.e(TAG, "load old data");
                        HomePageData localData = JSON.parseObject(jsonLocal, HomePageData.class);
                        showData(localData);
                    }
                }

                @Override
                public void onError(HttpThrowable error) {
                    Log.e(TAG, error.getErrMsg());
                    loadLocalData("加载网络数据失败");
                }
            });
        } else {
            loadLocalData("当前网络连接不可用");
        }
    }

    private void loadLocalData(String hint) {
        String jsonLocal = getLocalData();
        if (jsonLocal != null) {
            HomePageData localData = JSON.parseObject(jsonLocal, HomePageData.class);
            showData(localData);
            Toast.makeText(mContext, hint, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(mContext, "本地数据为空", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showData(HomePageData homePageData) {
        mPageData = homePageData;
    }


    private String getLocalData() {
        return mDownloadSPConfig.get(SAVE_DATA_KEY, "");
    }

    private void saveData(HomePageData homePageData) {
        String json = JSON.toJSONString(homePageData);
        mDownloadSPConfig.put(SAVE_DATA_KEY, json);
    }

    private boolean isLoadNewData(String json, long newTime) {
        if ("".equals(json)) {
            return true;
        }
        JSONObject data = JSON.parseObject(json);
        long time = (long) data.get("timestamp");
        if (newTime > time) {
            Log.e(TAG, "newTime:" + newTime + "time : " + time);
            return true;
        }
        return false;
    }

    /**
     * 如果没有时间或者处于禁用时间段，跳转到提示界面
     */
    public void checkTime() {
        if (!ParentSettingsUtil.isLimitTimeLeft(mContext) || ParentSettingsUtil.isNowInProhibitPeriod(mContext)) {
            Intent intent = new Intent(mContext, TimeHintActivity.class);
            mContext.startActivity(intent);
        }
    }
}
