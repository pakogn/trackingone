package com.spyc.trackingone.ui.login;

import android.util.Log;

import com.androidnetworking.error.ANError;
import com.spyc.trackingone.R;
import com.spyc.trackingone.data.DataManager;
import com.spyc.trackingone.data.network.model.CurrentUserResponse;
import com.spyc.trackingone.data.network.model.LoginRequest;
import com.spyc.trackingone.data.network.model.LoginResponse;
import com.spyc.trackingone.ui.base.BasePresenter;
import com.spyc.trackingone.utils.CommonUtils;
import com.spyc.trackingone.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by Jorge Namitle on 21/03/2018.
 */

public class LoginPresenter<V extends LoginContract> extends BasePresenter<V>
        implements LoginMvpPresenter<V> {

    private static final String TAG = "ComentariosMuleroPresenter";
    public static final String USER_NAME = "";

    @Inject
    public LoginPresenter(DataManager dataManager,
                          SchedulerProvider schedulerProvider,
                          CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onServerLoginClick(String email, String password) {
        //validate email and password
        if (email == null || email.isEmpty()) {
            getMvpView().onError(R.string.empty_email);
            return;
        }
        /*if (!CommonUtils.isEmailValid(email)) {
            getMvpView().onError(R.string.invalid_email);
            return;
        }*/
        if (password == null || password.isEmpty()) {
            getMvpView().onError(R.string.empty_password);
            return;
        }
        getMvpView().showLoading();

        getCompositeDisposable().add(getDataManager()
                .doServerLoginApiCall(new LoginRequest.ServerLoginRequest(email, password))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<LoginResponse>() {
                    @Override
                    public void accept(LoginResponse response) throws Exception {
                        Log.e("TOKEN=ID-USER::::::","" + response.getId());
                        Log.e("AUTH-USER::::::","" + response.getAuth());
                        getDataManager().updateApiAccessInfo(
                                response.getId()
                        );

                        getDataManager().updateUserInfo(
                                response.getId(),
                                response.getAuth(),
                                DataManager.LoggedInMode.LOGGED_IN_MODE_SERVER,
                                response.getName(),
                                response.getUsername(),
                                response.getActivityLogId()
                        );


                        getMvpView().hideLoading();

                        Long idRol = response.getAuth();

                        if(response.getAuth() == null) {
                            idRol = (long) -1;
                        }

                        if(idRol == 7) {
                            getMvpView().abrirPerfilTrafico(); // primer perfil 7
                        }
                        else if(idRol == 8) {
                            getMvpView().abrirPerfilMulero(); // segundo perfil 8
                        } else {
                            getMvpView().showMessage("Ingresa un usuario valido");
                        }

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();

                        // handle the login error here
                        if (throwable instanceof ANError) {
                            ANError anError = (ANError) throwable;
                            handleApiError(anError);
                        }
                    }
                }));
    }
}
