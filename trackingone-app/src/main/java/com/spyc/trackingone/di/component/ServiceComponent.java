package com.spyc.trackingone.di.component;

import com.spyc.trackingone.di.PerService;
import com.spyc.trackingone.di.module.ServiceModule;
import com.spyc.trackingone.service.SyncService;

import dagger.Component;

/**
 * Created by Jorge Namitle on 25/03/2018.
 */

@PerService
@Component(dependencies = ApplicationComponent.class, modules = ServiceModule.class)
public interface ServiceComponent {

    void inject(SyncService service);

}