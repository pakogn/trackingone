package com.spyc.trackingone.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.spyc.trackingone.data.network.model.FilaEmbarqueResponse;
import com.spyc.trackingone.di.ActivityContext;
import com.spyc.trackingone.di.PerActivity;
import com.spyc.trackingone.ui.Embarques.EmbarquesAdapter;
import com.spyc.trackingone.ui.Embarques.EmbarquesContract;
import com.spyc.trackingone.ui.Embarques.EmbarquesMvpPresenter;
import com.spyc.trackingone.ui.Embarques.EmbarquesPresenter;
import com.spyc.trackingone.ui.comentariosMulero.ComentariosMuleroContract;
import com.spyc.trackingone.ui.comentariosMulero.ComentariosMuleroMvpPresenter;
import com.spyc.trackingone.ui.comentariosMulero.ComentariosMuleroPresenter;
import com.spyc.trackingone.ui.detalleEmbarque.DetalleEmbarqueContract;
import com.spyc.trackingone.ui.detalleEmbarque.DetalleEmbarqueMvpPresenter;
import com.spyc.trackingone.ui.detalleEmbarque.DetalleEmbarquePresenter;
import com.spyc.trackingone.ui.embarqueStatus.EmbarqueStatusContract;
import com.spyc.trackingone.ui.embarqueStatus.EmbarqueStatusMvpPresenter;
import com.spyc.trackingone.ui.embarqueStatus.EmbarqueStatusPresenter;
import com.spyc.trackingone.ui.embarquesMulero.EmbarquesMuleroActivity;
import com.spyc.trackingone.ui.embarquesMulero.EmbarquesMuleroAdapter;
import com.spyc.trackingone.ui.embarquesMulero.EmbarquesMuleroContract;
import com.spyc.trackingone.ui.embarquesMulero.EmbarquesMuleroMvpPrensenter;
import com.spyc.trackingone.ui.embarquesMulero.EmbarquesMuleroPresenter;
import com.spyc.trackingone.ui.home.HomeContract;
import com.spyc.trackingone.ui.home.HomeMvpPresenter;
import com.spyc.trackingone.ui.home.HomePresenter;
import com.spyc.trackingone.ui.login.LoginContract;
import com.spyc.trackingone.ui.login.LoginMvpPresenter;
import com.spyc.trackingone.ui.login.LoginPresenter;
import com.spyc.trackingone.ui.splash.SplashContract;
import com.spyc.trackingone.ui.splash.SplashMvpPresenter;
import com.spyc.trackingone.ui.splash.SplashPresenter;
import com.spyc.trackingone.utils.rx.AppSchedulerProvider;
import com.spyc.trackingone.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Jorge Namitle on 17/03/2018.
 */

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashContract> provideSplashPresenter(
            SplashPresenter<SplashContract> presenter) {
        return presenter;
    }


    @Provides
    @PerActivity
    LoginMvpPresenter<LoginContract> provideLoginPresenter(
            LoginPresenter<LoginContract> presenter){
        return presenter;
    }

    @Provides
    @PerActivity
    HomeMvpPresenter<HomeContract> provideHomePresenter(
            HomePresenter<HomeContract> presenter) {
        return presenter;
    }


    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }


    @Provides
    EmbarquesMvpPresenter<EmbarquesContract> provideEmbarquesPresenter(
            EmbarquesPresenter<EmbarquesContract> presenter) {
        return presenter;
    }

    @Provides
    DetalleEmbarqueMvpPresenter<DetalleEmbarqueContract> provideDetalleEmbarquePresenter(
            DetalleEmbarquePresenter<DetalleEmbarqueContract> presenter) {
        return presenter;
    }

    @Provides
    EmbarquesAdapter provideEmbarquesAdapter(){
        return new EmbarquesAdapter(new ArrayList<FilaEmbarqueResponse>());
    }

    @Provides
    EmbarqueStatusMvpPresenter<EmbarqueStatusContract> provideEmbarqueStatusPresenter(
            EmbarqueStatusPresenter<EmbarqueStatusContract> presenter) {
        return presenter;
    }

    @Provides
    EmbarquesMuleroMvpPrensenter<EmbarquesMuleroContract> provideEmabarquesMuleroPresenter(
            EmbarquesMuleroPresenter<EmbarquesMuleroContract> presenter) {
        return presenter;
    }

    @Provides
    EmbarquesMuleroAdapter provideEmbarquesMuleroAdapter(){
        return new EmbarquesMuleroAdapter(new ArrayList<FilaEmbarqueResponse>());
    }

    @Provides
    ComentariosMuleroMvpPresenter<ComentariosMuleroContract> provideComentariosMuleroPresenter(
            ComentariosMuleroPresenter<ComentariosMuleroContract> presenter) {
        return presenter;
    }


}
