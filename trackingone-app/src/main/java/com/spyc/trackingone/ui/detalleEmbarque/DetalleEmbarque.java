package com.spyc.trackingone.ui.detalleEmbarque;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.spyc.trackingone.R;
import com.spyc.trackingone.data.network.model.FilaEmbarqueResponse;
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

    private FilaEmbarqueResponse fEmbarqueJson;

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

        Gson gson = new Gson();

        fEmbarqueJson = gson.fromJson(getIntent().getStringExtra("idMulero"), FilaEmbarqueResponse.class);
        Log.e("","LLEGA ="+getIntent().getStringExtra("idMulero"));
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

        detalleEmbarquePresenter.getCombos();

        MaterialSpinner spinner = (MaterialSpinner) findViewById(R.id.mulero1);
        spinner.setItems(
                "Veracruz",
                "Aguascalientes",
                "Baja California",
                "Baja California Sur",
                "Campeche",
                "Chihuahua",
                "Chiapas",
                "Coahuila",
                "Colima",
                "Durango",
                "Guanajuato",
                "Guerrero",
                "Hidalgo",
                "Jalisco",
                "México",
                "Michoacán",
                "Morelos",
                "Nayarit",
                "Nuevo León",
                "Oaxaca",
                "Puebla",
                "Querétaro",
                "Quintana Roo",
                "San Luis Potosí",
                "Sinaloa",
                "Sonora",
                "Tabasco",
                "Tamaulipas",
                "Tlaxcala",
                "Yucatán",
                "Zacatecas"
        );

        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                Snackbar.make(view, "Estado: " + item, Snackbar.LENGTH_LONG).show();
            }
        });
    }

}
