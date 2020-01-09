package com.spyc.trackingone.ui.detalleEmbarque;

import android.util.Log;

import com.androidnetworking.error.ANError;
import com.spyc.trackingone.data.DataManager;
import com.spyc.trackingone.data.network.model.CombosResponse;
import com.spyc.trackingone.ui.base.BasePresenter;
import com.spyc.trackingone.utils.rx.SchedulerProvider;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class DetalleEmbarquePresenter<V extends DetalleEmbarqueContract> extends BasePresenter<V>
        implements DetalleEmbarqueMvpPresenter<V> {

    @Inject
    public DetalleEmbarquePresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void getCombos() {
        getMvpView().showLoading();
        getCompositeDisposable().add( getDataManager()
            .getCombos()
            .subscribeOn(getSchedulerProvider().io())
            .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<List<CombosResponse>>() {
                    @Override
                    public void accept(List<CombosResponse> combosResponse) throws Exception {

                        Log.e("llega: ", ""+combosResponse);
                        getMvpView().hideLoading();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();
                        // handle the error here
                        if (throwable instanceof ANError) {
                            ANError anError = (ANError) throwable;
                            handleApiError(anError);
                        }
                    }
                })
        );
    }
}
