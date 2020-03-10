package com.swaiotos.launcher.kidsmode.home.model;

import com.swaiotos.common.http.HttpResult;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @ Created on: 2020/1/9
 * @Author: LEGION XiaoLuo
 * @ Description:
 */
public interface IHomePageHttpMethod {
    /**
     * 获取主页数据
     * */
    @GET("wisdom/appstorev3/getChildModelRecommendInfo")
    Call<HttpResult<HomePageData>> getHomePageData();
}
