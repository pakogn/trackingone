package com.spyc.trackingone.ui.embarqueStatus;

import com.spyc.trackingone.data.DataManager;
import com.spyc.trackingone.ui.base.BasePresenter;
import com.spyc.trackingone.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class EmbarqueStatusPresenter<V extends EmbarqueStatusContract> extends BasePresenter<V>
        implements EmbarqueStatusMvpPresenter<V> {

    @Inject
    public EmbarqueStatusPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
