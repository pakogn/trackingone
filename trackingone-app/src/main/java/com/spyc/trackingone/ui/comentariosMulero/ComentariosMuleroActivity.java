package com.spyc.trackingone.ui.comentariosMulero;

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

public class ComentariosMuleroActivity extends BaseActivity implements ComentariosMuleroContract {

    @Inject
    ComentariosMuleroMvpPresenter<ComentariosMuleroContract> comentariosMuleroPresenter;

    @BindView(R.id.et_comentarios)
    EditText mComentariosEditText;

    SharedPreferences sharedPreferences;
    String  accessToken;


    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, ComentariosMuleroActivity.class);
        return intent;
    }

    @Override
    public void onDeviceConnected(AidlDeviceService serviceManager) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentarios_mulero);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        comentariosMuleroPresenter.onAttach(ComentariosMuleroActivity.this);
    }

    @OnClick(R.id.btn_comentarios_mulero)
    void onServerComentariosMuleroClick(View v) {
        sharedPreferences = this.getSharedPreferences("mindorks_pref", Context.MODE_PRIVATE);
        accessToken = sharedPreferences.getString("PREF_KEY_ACCESS_TOKEN", null);
        comentariosMuleroPresenter.onComentariosMuleroClick(mComentariosEditText.getText().toString());
    }

    @Override
    public void openMainActivity() {
        Intent intent = EmbarquesActivity.getStartIntent(ComentariosMuleroActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void abrirPerfilMulero() {
        Intent intent = EmbarquesMuleroActivity.getStartIntent(ComentariosMuleroActivity.this);
        startActivity(intent);
        finish();
    }


    @Override
    protected void onDestroy() {
        comentariosMuleroPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {

    }

}
