package com.spyc.trackingone.di.module;

import android.app.Service;

import dagger.Module;

/**
 * Created by Jorge Namitle on 25/03/2018.
 */

@Module
public class ServiceModule {

    private final Service mService;

    public ServiceModule(Service service) {
        mService = service;
    }
}
