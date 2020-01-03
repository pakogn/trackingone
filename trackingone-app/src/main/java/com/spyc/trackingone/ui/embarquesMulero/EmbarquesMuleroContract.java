package com.spyc.trackingone.ui.embarquesMulero;

import com.spyc.trackingone.data.network.model.FilaEmbarqueResponse;
import com.spyc.trackingone.ui.base.MvpViewContract;

import java.util.List;

public interface EmbarquesMuleroContract extends MvpViewContract {

    void actualizaEmbarques(List<FilaEmbarqueResponse> embarquesList);

    void updateUserName(String currentUserName);

    void updateUserEmail(String currentUserEmail);

    void updateAuth(Long currentAuth);

    void openLoginActivity();

    void closeNavigationDrawer();

    void lockDrawer();

    void unlockDrawer();
}
