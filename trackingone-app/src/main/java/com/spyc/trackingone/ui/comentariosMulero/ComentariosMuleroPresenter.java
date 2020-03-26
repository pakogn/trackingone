package com.spyc.trackingone.ui.comentariosMulero;

import android.util.Log;

import com.androidnetworking.error.ANError;
import com.spyc.trackingone.R;
import com.spyc.trackingone.data.DataManager;
import com.spyc.trackingone.data.network.model.ComentariosMuleroRequest;
import com.spyc.trackingone.data.network.model.CurrentUserResponse;
import com.spyc.trackingone.ui.base.BasePresenter;
import com.spyc.trackingone.utils.CommonUtils;
import com.spyc.trackingone.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by Jorge Namitle on 21/03/2018.
 */

public class ComentariosMuleroPresenter<V extends ComentariosMuleroContract> extends BasePresenter<V>
        implements ComentariosMuleroMvpPresenter<V> {

    private static final String TAG = "ComentariosMuleroPresenter";
    public static final String USER_NAME = "";

    @Inject
    public ComentariosMuleroPresenter(DataManager dataManager,
                                      SchedulerProvider schedulerProvider,
                                      CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onComentariosMuleroClick(String comentarios) {
        //validate email and password
        if (comentarios == null || comentarios.isEmpty()) {
            getMvpView().onError("Debe ingresar comentarios");
            return;
        }

        getMvpView().showLoading();

        Long id = getDataManager().getCurrentActivityLogId();
        String comments = comentarios;

        getCompositeDisposable().add(getDataManager()
                .postComentariosMulero(new ComentariosMuleroRequest(id, comments))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer(){
                               @Override
                               public void accept(Object msg) throws Exception {
                                   if (!isViewAttached()) {
                                       return;
                                   }

                                   getMvpView().hideLoading();

                                   getMvpView().abrirPerfilMulero();
                               }
                           }, new Consumer<Throwable>() {
                               @Override
                               public void accept(Throwable throwable) throws Exception {
                                   if (!isViewAttached()) {
                                       return;
                                   }

                                   // es la vista del error
                                   getMvpView().abrirPerfilMulero();
                                   getMvpView().showMessage("Comentarios enviados.");

//                                   if (throwable instanceof ANError) {
//                                       ANError anError = (ANError) throwable;
//                                       handleApiError(anError);
//                                   }
                               }
                           }
                ));
    }
}
