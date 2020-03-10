package com.swaiotos.launcher.kidsmode.common.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import java.util.List;

/**
 * @ Created on: 2020/1/9
 * @Author: LEGION XiaoLuo
 * @ Description:
 */
public class PackageHelper {
    private static final String TAG = "PackageHelper";

    public static PackageHelper sPackageHelper;
    Context mContext;

    private PackageHelper(Context context) {
        mContext = context;
    }

    public static PackageHelper getInstance(Context context) {
        if (sPackageHelper == null) {
            sPackageHelper = new PackageHelper(context);
        }
        return sPackageHelper;
    }

    public static boolean isAppInstall(Context context, String packageName) {
        PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> packageInfos = packageManager.getInstalledPackages(0);
        Log.e(TAG,"size : "+ packageInfos.size());
        if (packageInfos.size() != 0) {
            for (PackageInfo p : packageInfos) {
                if (packageName.equals(p.packageName)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static long versionCode(Context context, String packageName) {
        PackageManager manager = context.getPackageManager();
        long code = 0;
        try {
            PackageInfo info = manager.getPackageInfo(packageName, 0);
            code = info.getLongVersionCode();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return code;
    }
}
