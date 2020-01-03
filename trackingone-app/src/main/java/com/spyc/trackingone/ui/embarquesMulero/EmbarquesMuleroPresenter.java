package com.spyc.trackingone.ui.embarquesMulero;

import android.util.Log;

import com.androidnetworking.error.ANError;
import com.spyc.trackingone.data.DataManager;
import com.spyc.trackingone.data.network.model.FilaEmbarqueResponse;
import com.spyc.trackingone.ui.base.BasePresenter;
import com.spyc.trackingone.utils.rx.SchedulerProvider;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class EmbarquesMuleroPresenter<V extends EmbarquesMuleroContract> extends BasePresenter<V>
        implements EmbarquesMuleroMvpPrensenter<V>  {

    @Inject
    public EmbarquesMuleroPresenter(
            DataManager dataManager,
            SchedulerProvider schedulerProvider,
            CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }


    @Override
    public void cargandoTabla() {
        String id = getDataManager().getCurrentUserId().toString();
        Log.e("ID USER","-"+id);
        getMvpView().showLoading();
        getCompositeDisposable().add((Disposable) getDataManager()
                .getEmbarqueApiCall(id)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<List<FilaEmbarqueResponse>>() {
                    @Override
                    public void accept(List<FilaEmbarqueResponse> filaEmbarqueResponses) throws Exception {
                        if (filaEmbarqueResponses != null && filaEmbarqueResponses.size() != 0) {
                            Log.e("FILA:", "--"+filaEmbarqueResponses);
                            getMvpView().actualizaEmbarques(filaEmbarqueResponses);

                        }
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

    @Override
    public void onDrawerOptionLogoutClick() {
        getMvpView().showLoading();
        getDataManager().setUserAsLoggedOut();
        getMvpView().hideLoading();
        getMvpView().openLoginActivity();
    }

    @Override
    public void onNavMenuCreated() {
        if(!isViewAttached()){
            return;
        }

        final String currentUserName = getDataManager().getCurrentUserName();
        if(currentUserName != null && !currentUserName.isEmpty()){
            getMvpView().updateUserName(currentUserName);
        }

        final String currentUserEmail = getDataManager().getCurrentUserEmail();
        if(currentUserEmail != null && !currentUserEmail.isEmpty()){
            getMvpView().updateUserEmail(currentUserEmail);
        }

        final Long currentAuth = getDataManager().getCurrentAuht();
        if(currentAuth != null) {
            getMvpView().updateAuth(currentAuth);
        }
    }
}
