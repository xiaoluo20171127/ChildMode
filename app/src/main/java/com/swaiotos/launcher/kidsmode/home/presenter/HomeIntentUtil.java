package com.swaiotos.launcher.kidsmode.home.presenter;

import android.content.Context;
import android.content.Intent;

/**
 * @ Created on: 2020/2/20
 * @Author: LEGION XiaoLuo
 * @ Description:
 */
public class HomeIntentUtil {

    static void intentToStore(Context context){
        Intent intent = new Intent("coocaa.intent.action.SWAIOT_HOME");
        intent.putExtra("clientModel","child");
        intent.setPackage("com.swaiotos.appstore");
        context.startActivity(intent);
    }

    static void intentToMyApp(Context context){
        Intent intent = new Intent("coocaa.intent.action.SWAIOT_MYAPP");
        intent.setPackage("com.swaiotos.appstore");
        context.startActivity(intent);
    }

    static void intentToAppDetail(Context context,String pkgName){
        Intent intent = new Intent("coocaa.intent.action.APP_DETAIL");
        intent.setPackage("com.swaiotos.appstore");
        intent.putExtra("pkgName", pkgName);
        context.startActivity(intent);
    }
}
