package com.spyc.trackingone;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

import com.androidnetworking.interceptors.HttpLoggingInterceptor;
import com.spyc.trackingone.data.DataManager;
import com.spyc.trackingone.di.component.ApplicationComponent;
import com.spyc.trackingone.di.component.DaggerApplicationComponent;
import com.spyc.trackingone.di.module.ApplicationModule;
import com.spyc.trackingone.utils.AppLogger;

import javax.inject.Inject;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by JorgeNami on 17/03/2018.
 */

public class MvpApp extends Application{

    @Inject
    DataManager mDataManager;

    @Inject
    CalligraphyConfig mCalligraphyConfig;

    private ApplicationComponent mApplicationComponent;

    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);

        AppLogger.init();

        AndroidNetworking.initialize(getApplicationContext());
        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY);
        }

        CalligraphyConfig.initDefault(mCalligraphyConfig);
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
