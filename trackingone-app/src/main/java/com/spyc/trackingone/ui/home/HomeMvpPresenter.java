package com.spyc.trackingone.ui.home;

import com.spyc.trackingone.di.PerActivity;
import com.spyc.trackingone.ui.base.MvpPresenter;

/**
 * Created by Jorge Namitle on 21/03/2018.
 */

@PerActivity
public interface HomeMvpPresenter<V extends HomeContract> extends MvpPresenter <V> {

    void onDrawerOptionLogoutClick();

    void irEmbarques();

    void onNavMenuCreated();

}
