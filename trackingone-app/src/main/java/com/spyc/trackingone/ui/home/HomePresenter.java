package com.spyc.trackingone.ui.home;

import com.spyc.trackingone.data.DataManager;
import com.spyc.trackingone.ui.base.BasePresenter;
import com.spyc.trackingone.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Jorge Namitle on 21/03/2018.
 */

public class HomePresenter<V extends HomeContract> extends BasePresenter<V>
    implements HomeMvpPresenter<V>{

    private static final String TAG = "MainPresenter";

    @Inject
    public HomePresenter(DataManager dataManager,
                         SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onDrawerOptionLogoutClick() {
        getMvpView().showLoading();

        getDataManager().setUserAsLoggedOut();
        getMvpView().hideLoading();
        getMvpView().openLoginActivity();

    }

    @Override
    public void irEmbarques() {
        getMvpView().closeNavigationDrawer();
        getMvpView().abrirEmbarques();
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
    }

}
