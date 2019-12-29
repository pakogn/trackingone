package com.spyc.trackingone.ui.base;

import android.support.annotation.StringRes;

/**
 * Created by Jorge Namitle on 18/03/2018.
 */

public interface MvpViewContract {
    void showLoading();

    void hideLoading();

    void openActivityOnTokenExpire();

    void onError(@StringRes int resId);

    void onError(String message);

    void showMessage(String message);

    void showMessage(@StringRes int resId);

    boolean isNetworkConnected();

    void hideKeyboard();
}
