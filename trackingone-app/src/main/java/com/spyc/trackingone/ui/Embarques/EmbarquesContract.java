package com.spyc.trackingone.ui.Embarques;

import com.spyc.trackingone.data.network.model.FilaEmbarqueResponse;
import com.spyc.trackingone.ui.base.MvpViewContract;

import java.util.List;

public interface EmbarquesContract extends MvpViewContract {

    void filtrarPendientesEnRampa();

    void filtrarPendientesEnCajon();

    void actualizaEmbarques(List<FilaEmbarqueResponse> embarquesList);
    void actualizaEmbarquesPendientesCajon(List<FilaEmbarqueResponse> embarquesList);
    void actualizaEmbarquesPendientesRampa(List<FilaEmbarqueResponse> embarquesList);
    void updateUserName(String currentUserName);

    void updateUserEmail(String currentUserEmail);

    void updateAuth(Long currentAuth);

    void openLoginActivity();

    void closeNavigationDrawer();

    void lockDrawer();

    void unlockDrawer();
}
