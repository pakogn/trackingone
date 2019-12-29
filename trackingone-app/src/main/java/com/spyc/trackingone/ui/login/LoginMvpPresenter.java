package com.spyc.trackingone.ui.login;

import com.spyc.trackingone.ui.base.MvpPresenter;

/**
 * Created by Jorge Namitle on 21/03/2018.
 */

public interface LoginMvpPresenter<V extends LoginContract> extends MvpPresenter<V> {

    void onServerLoginClick(String email, String password);

}
