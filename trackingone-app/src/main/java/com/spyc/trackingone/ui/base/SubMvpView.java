package com.spyc.trackingone.ui.base;

/**
 * Created by Jorge Namitle on 18/03/2018.
 */

public interface SubMvpView extends MvpViewContract {
    void onCreate();

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

    void attachParentMvpView(MvpViewContract mvpView);
}
