package com.bhargavms.dotloader_sample;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by bhargav on 5/29/17.
 */

public class DotLoaderApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }
}
