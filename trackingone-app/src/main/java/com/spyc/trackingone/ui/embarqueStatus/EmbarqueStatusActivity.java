package com.spyc.trackingone.ui.embarqueStatus;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.spyc.trackingone.R;
import com.spyc.trackingone.ui.base.BaseActivity;
import com.topwise.cloudpos.aidl.AidlDeviceService;
import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EmbarqueStatusActivity extends BaseActivity implements EmbarqueStatusContract {

    @Inject
    EmbarqueStatusMvpPresenter<EmbarqueStatusContract> embarqueStatusMvpPresenter;

    @BindView(R.id.toolbar)
    Toolbar vtoolbar;

    @BindView(R.id.toolbar_title)
    TextView toolbar_title;


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

    }
}
