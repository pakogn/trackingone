package com.spyc.trackingone.ui.Embarques;

import com.spyc.trackingone.data.network.model.FilaEmbarqueResponse;
import com.spyc.trackingone.ui.base.MvpViewContract;

import java.util.List;

public interface EmbarquesContract extends MvpViewContract {

    void abrirDetalleEmbarque();

    void abrirEmbarqueStatus();

    void actualizaEmbarques(List<FilaEmbarqueResponse> embarquesList);

    void updateUserName(String currentUserName);

    void updateUserEmail(String currentUserEmail);

    void openLoginActivity();

    void closeNavigationDrawer();

    void lockDrawer();

    void unlockDrawer();
}
