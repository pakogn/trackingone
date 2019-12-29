package com.spyc.trackingone.di.component;

/**
 * Created by JorgeNami on 17/03/2018.
 */

import com.spyc.trackingone.MvpApp;

import android.app.Application;
import android.content.Context;
import javax.inject.Singleton;

import dagger.Component;

import com.spyc.trackingone.data.DataManager;
import com.spyc.trackingone.di.ApplicationContext;
import com.spyc.trackingone.di.module.ApplicationModule;
import com.spyc.trackingone.service.SyncService;

@Singleton
@Component (modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MvpApp app);

    void inject(SyncService service);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();

}
