package com.kelompok.worklist.application;

import android.app.Application;

import com.kelompok.worklist.customfont.TypefaceUtil;



public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/avenir.ttf");
    }
}
