package com.spyc.trackingone.ui.detalleEmbarque;

import com.spyc.trackingone.data.network.model.EmbarquesAsigadosRequest;
import com.spyc.trackingone.di.PerActivity;
import com.spyc.trackingone.ui.base.MvpPresenter;

@PerActivity
public interface DetalleEmbarqueMvpPresenter<V extends DetalleEmbarqueContract> extends MvpPresenter<V> {

    void getCombos();
    void postDetails( Long id,  EmbarquesAsigadosRequest request);
}
