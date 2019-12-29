package com.spyc.trackingone.ui.Embarques;

import com.spyc.trackingone.di.PerActivity;
import com.spyc.trackingone.ui.base.MvpPresenter;

@PerActivity
public interface EmbarquesMvpPresenter<V extends EmbarquesContract> extends MvpPresenter<V> {

    void irDetalleEmbarque();

    void cargandoTabla();

    void onDrawerOptionLogoutClick();

    void onNavMenuCreated();
}
