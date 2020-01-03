package com.spyc.trackingone.ui.embarqueStatus;

import com.androidnetworking.error.ANError;
import com.spyc.trackingone.data.DataManager;
import com.spyc.trackingone.ui.base.BasePresenter;
import com.spyc.trackingone.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class EmbarqueStatusPresenter<V extends EmbarqueStatusContract> extends BasePresenter<V>
        implements EmbarqueStatusMvpPresenter<V> {

    @Inject
    public EmbarqueStatusPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void InRamp(String id) {
        getCompositeDisposable().add(getDataManager()
            .postInRamp(id)
            .subscribeOn(getSchedulerProvider().io())
            .observeOn(getSchedulerProvider().ui())
            .subscribe(new Consumer() {
                           @Override
                           public void accept(Object o) throws Exception {

                               if (!isViewAttached()) {
                                   return;
                               }

                               getMvpView().showMessage("¡Cambio de status exitoso!");
                               getMvpView().hideLoading();
                               getMvpView().closetView();
                           }
                       }, new Consumer<Throwable>() {
                           @Override
                           public void accept(Throwable throwable) throws Exception {
                               if (!isViewAttached()) {
                                   return;
                               }

                               getMvpView().showMessage("¡Cambio de status exitoso!");
                               getMvpView().hideLoading();
                               getMvpView().closetView();
                               if (throwable instanceof ANError) {
                                   //ANError anError = (ANError) throwable;
                                   //handleApiError(anError);
                               }
                           }
                       }
            )
        );
    }

    @Override
    public void fromRamp(String id) {
        getCompositeDisposable().add(getDataManager()
                .postFromRamp(id)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer() {
                               @Override
                               public void accept(Object o) throws Exception {

                                   if (!isViewAttached()) {
                                       return;
                                   }

                                   getMvpView().showMessage("¡Cambio de status exitoso!");
                                   getMvpView().hideLoading();
                                   getMvpView().closetView();
                               }
                           }, new Consumer<Throwable>() {
                               @Override
                               public void accept(Throwable throwable) throws Exception {
                                   if (!isViewAttached()) {
                                       return;
                                   }

                                   getMvpView().showMessage("¡Cambio de status exitoso!");
                                   getMvpView().hideLoading();
                                   getMvpView().closetView();
                                   if (throwable instanceof ANError) {
                                       //ANError anError = (ANError) throwable;
                                       //handleApiError(anError);
                                   }
                               }
                           }
                )
        );
    }

    @Override
    public void inParkingSpace(String id) {
        getCompositeDisposable().add(getDataManager()
                .postInParkingSpace(id)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer() {
                               @Override
                               public void accept(Object o) throws Exception {

                                   if (!isViewAttached()) {
                                       return;
                                   }

                                   getMvpView().showMessage("¡Cambio de status exitoso!");
                                   getMvpView().hideLoading();
                                   getMvpView().closetView();
                               }
                           }, new Consumer<Throwable>() {
                               @Override
                               public void accept(Throwable throwable) throws Exception {
                                   if (!isViewAttached()) {
                                       return;
                                   }

                                   getMvpView().showMessage("¡Cambio de status exitoso!");
                                   getMvpView().hideLoading();
                                   getMvpView().closetView();
                                   if (throwable instanceof ANError) {
                                       //ANError anError = (ANError) throwable;
                                       //handleApiError(anError);
                                   }
                               }
                           }
                )
        );
    }

    @Override
    public void fromParkingSpace(String id) {
        getCompositeDisposable().add(getDataManager()
                .postFromParkingSpace(id)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer(){
                               @Override
                               public void accept(Object msg) throws Exception {

                                   if (!isViewAttached()) {
                                       return;
                                   }

                                   getMvpView().showMessage("¡Cambio de status exitoso!");
                                   getMvpView().hideLoading();
                                   getMvpView().closetView();
                               }
                           }, new Consumer<Throwable>() {
                               @Override
                               public void accept(Throwable throwable) throws Exception {
                                   if (!isViewAttached()) {
                                       return;
                                   }

                                   getMvpView().showMessage("¡Cambio de status exitoso!");
                                   getMvpView().hideLoading();
                                   getMvpView().closetView();
                                   if (throwable instanceof ANError) {
                                       //ANError anError = (ANError) throwable;
                                       //handleApiError(anError);
                                   }
                               }
                           }
                )
        );
    }

    @Override
    public void showMessage(String msg) {
        getMvpView().showMessage(msg);
    }


}
