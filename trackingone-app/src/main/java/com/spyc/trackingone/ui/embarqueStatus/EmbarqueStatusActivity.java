package com.spyc.trackingone.ui.embarqueStatus;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.spyc.trackingone.R;
import com.spyc.trackingone.data.network.model.FilaEmbarqueResponse;
import com.spyc.trackingone.ui.base.BaseActivity;
import com.spyc.trackingone.ui.embarquesMulero.EmbarquesMuleroActivity;
import com.topwise.cloudpos.aidl.AidlDeviceService;
import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EmbarqueStatusActivity extends BaseActivity implements EmbarqueStatusContract {

    @Inject
    EmbarqueStatusMvpPresenter<EmbarqueStatusContract> embarqueStatusMvpPresenter;

    @BindView(R.id.toolbar)
    Toolbar vtoolbar;

    @BindView(R.id.toolbar_title)
    TextView toolbar_title;

    @BindView(R.id.origin)
    EditText origin;

    @BindView(R.id.destination)
    EditText destination;

    @BindView(R.id.container)
    EditText container;

    @BindView(R.id.btn_status)
    Button btn_status;

    private FilaEmbarqueResponse fEmbarqueJson;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, EmbarqueStatusActivity.class);
        return intent;
    }


    @Override
    public void onDeviceConnected(AidlDeviceService serviceManager) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_embarque_status);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        embarqueStatusMvpPresenter.onAttach(this);

        setUp();
    }

    @Override
    protected void setUp() {
        setSupportActionBar(vtoolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            toolbar_title.setText("Detalle x status");
        }

        Gson gson = new Gson();

        fEmbarqueJson = gson.fromJson(getIntent().getStringExtra("idMulero"), FilaEmbarqueResponse.class);
        Log.e("","LLEGA ="+getIntent().getStringExtra("idMulero"));

        origin.setText(fEmbarqueJson.getOrigin());
        destination.setText(fEmbarqueJson.getDestination());
        //container.setText(fEmbarqueJson.getContainer());

        this.setTextStatusButton();

    }

    void setTextStatusButton() {
        if( fEmbarqueJson.getMoved_from_parking_space_at() != null &&
            fEmbarqueJson.getIn_ramp_at() !=  null &&
            fEmbarqueJson.getMoved_from_ramp_at() != null &&
            fEmbarqueJson.getIn_parking_space_at() != null) {
            btn_status.setEnabled(false);
        }


        if(fEmbarqueJson.getMoved_from_parking_space_at() == null){
            btn_status.setText("Mover desde Cajón");
            return;
        }
        if(fEmbarqueJson.getIn_ramp_at() ==  null) {
            btn_status.setText("Dejar en Rampa");
            return;
        }
        if(fEmbarqueJson.getMoved_from_ramp_at() == null) {
            btn_status.setText("Mover desde Rampa");
            return;
        }
        if(fEmbarqueJson.getIn_parking_space_at() == null) {
            btn_status.setText("Dejar en Cajón");
            return;
        }
    }


    @OnClick(R.id.btn_status)
    public void abrirDetalleEmbarque() {
        int condition = container.getText().toString().compareToIgnoreCase( fEmbarqueJson.getContainer());
        Log.e("despues de comparteTo:", ""+condition);
        if(condition == 0){
            clickBtnStatus();
        } else {
            embarqueStatusMvpPresenter.showMessage("ERROR, la caja no coincide con la correcta");
        }

    }

    void clickBtnStatus() {
        if(fEmbarqueJson.getMoved_from_parking_space_at() == null){
            embarqueStatusMvpPresenter.fromParkingSpace(fEmbarqueJson.getId());
            return;
        }
        if(fEmbarqueJson.getIn_ramp_at() ==  null) {
            embarqueStatusMvpPresenter.InRamp(fEmbarqueJson.getId());
            return;
        }
        if(fEmbarqueJson.getMoved_from_ramp_at() == null) {
            embarqueStatusMvpPresenter.fromRamp(fEmbarqueJson.getId());
            return;
        }
        if(fEmbarqueJson.getIn_parking_space_at() == null) {
            embarqueStatusMvpPresenter.inParkingSpace(fEmbarqueJson.getId());
            return;
        }
    }

    @Override
    public void closetView() {
        Intent intent = EmbarquesMuleroActivity.getStartIntent(EmbarqueStatusActivity.this);
        startActivity(intent);
        finish();
    }
}
