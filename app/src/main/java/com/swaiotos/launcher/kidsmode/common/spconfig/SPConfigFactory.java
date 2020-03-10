package com.swaiotos.launcher.kidsmode.common.spconfig;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;

/**
 * Created by lu on 2017/10/23.
 */

public class SPConfigFactory {
    public static final SPConfig get(Context context, String name) {
        return new AppCoreDownloadSPConfigImpl(context, name);
    }

    private static class AppCoreDownloadSPConfigImpl implements SPConfig {
        private SharedPreferences sp;

        AppCoreDownloadSPConfigImpl(Context context, String name) {
            sp = context.getSharedPreferences(name, Context.MODE_PRIVATE | Context.MODE_MULTI_PROCESS);
        }

        @Override
        public void put(String key, String value) {
            try {
                SharedPreferences.Editor editor = sp.edit();
                editor.putString(key, value);
                editor.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public String get(String key, String defaultValue) {
            return sp.getString(key, defaultValue);
        }

        @Override
        public void remove(String key) {
            try {
                SharedPreferences.Editor editor = sp.edit();
                editor.remove(key);
                editor.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public Map<String, ?> getALL() {
            return sp.getAll();
        }

        @Override
        public void clear() {
            try {
                SharedPreferences.Editor editor = sp.edit();
                editor.clear();
                editor.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
