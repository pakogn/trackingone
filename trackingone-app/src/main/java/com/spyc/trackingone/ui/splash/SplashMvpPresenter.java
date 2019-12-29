package com.spyc.trackingone.ui.splash;

import com.spyc.trackingone.di.PerActivity;
import com.spyc.trackingone.ui.base.MvpPresenter;

/**
 * Created by Jorge Namitle on 21/03/2018.
 */

@PerActivity
public interface SplashMvpPresenter<V extends  SplashContract> extends MvpPresenter<V> {
}
