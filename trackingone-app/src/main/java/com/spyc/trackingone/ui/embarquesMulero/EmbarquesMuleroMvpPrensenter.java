package com.spyc.trackingone.ui.embarquesMulero;

import com.spyc.trackingone.ui.base.MvpPresenter;

public interface EmbarquesMuleroMvpPrensenter<V extends EmbarquesMuleroContract> extends MvpPresenter<V> {

    void cargandoTabla();

    void onDrawerOptionLogoutClick();

    void onNavMenuCreated();

}

