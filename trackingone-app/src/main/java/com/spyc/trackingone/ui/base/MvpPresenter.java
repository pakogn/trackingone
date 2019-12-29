package com.spyc.trackingone.ui.base;

import com.androidnetworking.error.ANError;

/**
 * Created by Jorge Namitle on 18/03/2018.
 */

public interface MvpPresenter<V extends MvpViewContract> {

    void onAttach(V mvpView);

    void onDetach();

    void handleApiError(ANError error);

    void setUserAsLoggedOut();
}
