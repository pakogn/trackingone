package com.spyc.trackingone.ui.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.spyc.trackingone.ui.Embarques.EmbarquesActivity;
import com.spyc.trackingone.ui.base.BaseActivity;
import com.spyc.trackingone.ui.embarquesMulero.EmbarquesMuleroActivity;
import com.spyc.trackingone.ui.home.HomeActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.spyc.trackingone.R;
import com.topwise.cloudpos.aidl.AidlDeviceService;

public class LoginActivity extends BaseActivity implements LoginContract {

    @Inject
    LoginMvpPresenter<LoginContract> loginPresenter;

    @BindView(R.id.et_email)
    EditText mEmailEditText;

    @BindView(R.id.et_password)
    EditText mPasswordEditText;

    SharedPreferences sharedPreferences;
    String  accessToken;


    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        return intent;
    }

    @Override
    public void onDeviceConnected(AidlDeviceService serviceManager) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        loginPresenter.onAttach(LoginActivity.this);
    }

    @OnClick(R.id.btn_server_login)
    void onServerLoginClick(View v) {
        sharedPreferences = this.getSharedPreferences("mindorks_pref", Context.MODE_PRIVATE);
        accessToken = sharedPreferences.getString("PREF_KEY_ACCESS_TOKEN", null);
        loginPresenter.onServerLoginClick(mEmailEditText.getText().toString(), mPasswordEditText.getText().toString());
    }

    @Override
    public void openMainActivity() {
        Intent intent = EmbarquesActivity.getStartIntent(LoginActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void abrirPerfilMulero() {
        Intent intent = EmbarquesMuleroActivity.getStartIntent(LoginActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void abrirPerfilTrafico() {
        Intent intent = EmbarquesActivity.getStartIntent(LoginActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        loginPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {

    }

}
