package com.spyc.trackingone.di.component;

import com.spyc.trackingone.di.PerActivity;
import com.spyc.trackingone.di.module.ActivityModule;
import com.spyc.trackingone.ui.Embarques.EmbarquesActivity;
import com.spyc.trackingone.ui.comentariosMulero.ComentariosMuleroActivity;
import com.spyc.trackingone.ui.detalleEmbarque.DetalleEmbarque;
import com.spyc.trackingone.ui.embarqueStatus.EmbarqueStatusActivity;
import com.spyc.trackingone.ui.embarquesMulero.EmbarquesMuleroActivity;
import com.spyc.trackingone.ui.home.HomeActivity;
import com.spyc.trackingone.ui.login.LoginActivity;
import com.spyc.trackingone.ui.splash.SplashActivity;

import dagger.Component;

/**
 * Created by Jorge Namitle on 18/03/2018.
 */

@PerActivity
@Component (dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(HomeActivity activity);

    void inject(LoginActivity activity);

    void inject(SplashActivity activity);

    void inject(EmbarquesActivity Activity);

    void inject(DetalleEmbarque activity);

    void inject(EmbarqueStatusActivity activity);

    void inject(EmbarquesMuleroActivity activity);

    void inject(ComentariosMuleroActivity activity);
}
