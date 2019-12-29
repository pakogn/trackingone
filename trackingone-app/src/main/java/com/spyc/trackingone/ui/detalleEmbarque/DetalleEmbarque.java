package com.spyc.trackingone.ui.detalleEmbarque;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.spyc.trackingone.R;
import com.spyc.trackingone.ui.base.BaseActivity;
import com.spyc.trackingone.ui.embarqueStatus.EmbarqueStatusActivity;
import com.topwise.cloudpos.aidl.AidlDeviceService;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetalleEmbarque extends BaseActivity implements DetalleEmbarqueContract {

    @Inject
    DetalleEmbarqueMvpPresenter<DetalleEmbarqueContract> detalleEmbarquePresenter;

    @BindView(R.id.toolbar)
    Toolbar vtoolbar;

    @BindView(R.id.toolbar_title)
    TextView toolbar_title;


    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, DetalleEmbarque.class);
        return intent;
    }

    @Override
    public void onDeviceConnected(AidlDeviceService serviceManager) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_embarque);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        detalleEmbarquePresenter.onAttach(this);

        setUp();
    }

    @Override
    protected void setUp() {
        setSupportActionBar(vtoolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            toolbar_title.setText(R.string.embarqueDetalle);
        }
    }

}
