package com.spyc.trackingone.ui.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.spyc.trackingone.ui.Embarques.EmbarquesActivity;
import com.spyc.trackingone.ui.base.BaseActivity;
import com.spyc.trackingone.ui.embarquesMulero.EmbarquesMuleroActivity;
import com.spyc.trackingone.ui.home.HomeActivity;
import com.spyc.trackingone.ui.login.LoginActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import com.spyc.trackingone.R;
import com.topwise.cloudpos.aidl.AidlDeviceService;

public class SplashActivity extends BaseActivity implements SplashContract {

    @Inject
    SplashMvpPresenter<SplashContract> splashPresenter;

    public static Intent getStartIntent(Context context){
        Intent intent = new Intent(context, SplashActivity.class);
        return intent;
    }

    @Override
    public void onDeviceConnected(AidlDeviceService serviceManager) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        splashPresenter.onAttach(SplashActivity.this);
    }


    @Override
    public void openLoginActivity() {
        Intent intent = LoginActivity.getStartIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void openEmbarquesTrafico() {
        Intent intent = EmbarquesActivity.getStartIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void startSyncService() {
        //SyncService.start(this);
    }

    @Override
    public void openEmbarquesMulero() {
        Intent intent = EmbarquesMuleroActivity.getStartIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        splashPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {

    }

}
