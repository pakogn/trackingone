package com.spyc.trackingone.ui.splash;

import com.spyc.trackingone.ui.base.MvpViewContract;

/**
 * Created by Jorge Namitle on 21/03/2018.
 */

public interface SplashContract extends MvpViewContract{

    void openLoginActivity();

    void openHomeActivity();

    void startSyncService();

}
