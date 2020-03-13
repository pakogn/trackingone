package com.spyc.trackingone.ui.comentariosMulero;

import android.util.Log;

import com.androidnetworking.error.ANError;
import com.spyc.trackingone.R;
import com.spyc.trackingone.data.DataManager;
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

        if (!isViewAttached()) {
            return;
        }

        getMvpView().hideLoading();

        getMvpView().abrirPerfilMulero();

        return;

//        getCompositeDisposable().add(getDataManager()
//                .doServerComentariosMuleroApiCall(new ComentariosMuleroRequest.ServerComentariosMuleroRequest(email, password))
//                .subscribeOn(getSchedulerProvider().io())
//                .observeOn(getSchedulerProvider().ui())
//                .subscribe(new Consumer<ComentariosMuleroResponse>() {
//                    @Override
//                    public void accept(ComentariosMuleroResponse response) throws Exception {
//                        Log.e("TOKEN=ID-USER::::::","" + response.getId());
//                        Log.e("AUTH-USER::::::","" + response.getAuth());
//                        getDataManager().updateApiAccessInfo(
//                                response.getId()
//                        );
//
//                        getDataManager().updateUserInfo(
//                                response.getId(),
//                                response.getAuth(),
//                                DataManager.LoggedInMode.LOGGED_IN_MODE_SERVER,
//                                response.getName(),
//                                response.getUsername()
//                        );
//
//
//
//                        if (!isViewAttached()) {
//                            return;
//                        }
//
//                        getMvpView().hideLoading();
//
//                        if(response.getAuth() == 7) {
//                            getMvpView().abrirPerfilTrafico(); // primer perfil 7
//                        }
//                        if(response.getAuth() == 8) {
//                            getMvpView().abrirPerfilMulero(); // segundo perfil 8
//                        } else {
//                            getMvpView().showMessage("Ingresa un usuario valido");
//                        }
//
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable throwable) throws Exception {
//
//                        if (!isViewAttached()) {
//                            return;
//                        }
//
//                        getMvpView().hideLoading();
//
//                        // handle the login error here
//                        if (throwable instanceof ANError) {
//                            ANError anError = (ANError) throwable;
//                            handleApiError(anError);
//                        }
//                    }
//                }));
    }
}
