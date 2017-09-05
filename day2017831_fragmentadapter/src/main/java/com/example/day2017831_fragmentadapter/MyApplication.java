package com.example.day2017831_fragmentadapter;

import android.app.Application;
import android.content.Context;

/**
 * Created by zte on 2017/9/1.
 */

public class MyApplication extends Application {
    private static Context context;

    public static Context getContext(){
        return context;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
}
