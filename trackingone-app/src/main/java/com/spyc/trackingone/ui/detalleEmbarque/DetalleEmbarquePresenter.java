package com.spyc.trackingone.ui.detalleEmbarque;

import com.spyc.trackingone.data.DataManager;
import com.spyc.trackingone.ui.base.BasePresenter;
import com.spyc.trackingone.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class DetalleEmbarquePresenter<V extends DetalleEmbarqueContract> extends BasePresenter<V>
        implements DetalleEmbarqueMvpPresenter<V> {

    @Inject
    public DetalleEmbarquePresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
