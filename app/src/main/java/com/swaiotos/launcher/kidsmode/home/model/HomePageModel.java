package com.swaiotos.launcher.kidsmode.home.model;

import com.swaiotos.common.http.HttpManager;
import com.swaiotos.common.http.HttpResult;

import java.util.Map;

import retrofit2.Call;

/**
 * @ Created on: 2020/1/9
 * @Author: LEGION XiaoLuo
 * @ Description:
 */
public class HomePageModel extends HttpManager<IHomePageHttpMethod> {

    public static final HomePageModel SERVICE = new HomePageModel();

    @Override
    protected Class<IHomePageHttpMethod> getServiceClass() {
        return IHomePageHttpMethod.class;
    }

    @Override
    protected Map<String, String> getHeaders() {
        return ChildModeHttpConfig.headLoader.getHeader();
    }

    @Override
    protected String getBaseUrl() {
        return ChildModeHttpConfig.getServerUrl();
    }

    public Call<HttpResult<HomePageData>> getHomePageData(){
        return getHttpService().getHomePageData();
    }

}
