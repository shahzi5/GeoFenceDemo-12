package com.rishabhbatta.geofencedemo;

import android.app.Application;

/**
 * Created by Rishabh Batta on 04-07-2017.
 */

public class App extends Application {

    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static App getInstance() {
        return instance;
    }
}
