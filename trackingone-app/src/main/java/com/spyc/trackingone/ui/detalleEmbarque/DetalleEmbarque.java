package com.spyc.trackingone.ui.detalleEmbarque;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.spyc.trackingone.R;
import com.spyc.trackingone.data.network.model.CombosResponse;
import com.spyc.trackingone.data.network.model.EmbarquesAsigadosRequest;
import com.spyc.trackingone.data.network.model.EmbarquesAsigadosResponse;
import com.spyc.trackingone.data.network.model.FilaEmbarqueResponse;
import com.spyc.trackingone.ui.Embarques.EmbarquesActivity;
import com.spyc.trackingone.ui.base.BaseActivity;
import com.topwise.cloudpos.aidl.AidlDeviceService;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

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
    @BindView(R.id.mulero1)
    Spinner SpinnerMoluero1;
    @BindView(R.id.mulero2)
    Spinner SpinnerMoluero2;
    private SpinnerAdapter adapterSpinnerActividad2;
    private SpinnerAdapter adapterSpinnerActividad;
    private   RecyclerView recyclerView;
    private FilaEmbarqueResponse fEmbarqueJson;
    CombosResponse opcionSeleccionada1;
    CombosResponse opcionSeleccionada2;
    private  TableViewAdapter adapter;
    private List<FilaEmbarqueResponse> listaenbarque= new ArrayList<FilaEmbarqueResponse>();
     EditText edttcajon, edtcajonFin,edtRamp;
    RadioGroup radioGroup;
    RadioButton rbotn1;
    RadioButton rbotn2;
    RadioButton rbotn3;

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

        SpinnerMoluero1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 opcionSeleccionada1 = (CombosResponse)adapterView.getItemAtPosition(i);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        SpinnerMoluero2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 opcionSeleccionada2 = (CombosResponse)adapterView.getItemAtPosition(i);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });


       String datajson =  getIntent().getStringExtra("AllList");
        Type listType = new TypeToken<List<FilaEmbarqueResponse>>() {}.getType();
        listaenbarque = gson.fromJson(datajson, listType);
         recyclerView = findViewById(R.id.recyclerViewDeliveryProductList);
         adapter = new TableViewAdapter(listaenbarque);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
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
    }

    @Override
    public void showCombosView(List<CombosResponse> response) {
        Log.d("data",response.toString());
        adapterSpinnerActividad = new SpinnerAdapter(this, response);
        SpinnerMoluero1.setAdapter(adapterSpinnerActividad);
        SpinnerMoluero2.setAdapter(adapterSpinnerActividad);
    }
    @Override
    public void saveCorrect(EmbarquesAsigadosResponse res)
    {
        if(res!=null) {
            //alert, toad
            Toast toast1 =
                    Toast.makeText(getApplicationContext(),
                            res.getMessage()==null?"Error ":res.getMessage(), Toast.LENGTH_SHORT);

            toast1.show();
            //displayToast();
            Intent anterior = new  Intent (this, EmbarquesActivity.class);
            startActivity(anterior);
            finish ();

        }else{
            Toast.makeText(getApplicationContext(),"Error en parceo de datos",Toast.LENGTH_LONG);
        }
    }




    @OnClick (R.id.btnmedia2)
    public void EmbarquePrioridadAlta( )
    {
        ObntenerdatosNivel("1");
    }
    @OnClick (R.id.btnmedia)
    public  void EmbarquePrioridadMedia( )
    {
        ObntenerdatosNivel("2");
    }

    @OnClick (R.id.btnBaja)
    public  void EmbarquePrioridadBaja( )
    {
        ObntenerdatosNivel("3");
    }

    public  void  ObntenerdatosNivel( String nivel )
    {
        List<FilaEmbarqueResponse> TemlistaenbarqueAlta= new ArrayList<FilaEmbarqueResponse>();
        List<FilaEmbarqueResponse> listaenbarqueAlta= new ArrayList<FilaEmbarqueResponse>();
        for( int i=0;i< listaenbarque.size();i++)
        {
            String data= String.valueOf(listaenbarque.get(i).getShipping_priority()==null?"":listaenbarque.get(i).getShipping_priority());
            if(nivel.equals( data))
            {
                listaenbarqueAlta.add(listaenbarque.get(i));
            }
        }
        TemlistaenbarqueAlta = listaenbarqueAlta;
        adapter = new TableViewAdapter(TemlistaenbarqueAlta);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


    @OnClick (R.id.btnguardar)
    public void SaveDate( )
    {
        int shepp=0;
        edttcajon=(EditText) findViewById(R.id.edtxcajon_inicial);
        edtRamp = (EditText) findViewById(R.id.edtx_rampa);
        edtcajonFin=(EditText) findViewById(R.id.edtx_cajo_fin);
        rbotn1=(RadioButton) findViewById(R.id.rbuno);
        rbotn2=(RadioButton) findViewById(R.id.rbdos);
        rbotn3=(RadioButton) findViewById(R.id.rbtres);

       String cajonInicial= edttcajon.getText().toString();
        String cajonfianl= edtcajonFin.getText().toString();

        String ramp= edtRamp.getText().toString();

        if (cajonInicial.length()==0)
        {
            Toast.makeText(this,"Falta informacion Cajón Inicial ", Toast.LENGTH_LONG).show();
            return;
        }
        if (ramp.length()==0)
        {
            Toast.makeText(this,"Falta informacion de Ramp ", Toast.LENGTH_LONG).show();
            return;
        }
        if (cajonfianl.length()==0)
        {
            Toast.makeText(this,"Falta informacion Cajón Final ", Toast.LENGTH_LONG).show();
            return;
        }
        if ( rbotn1.isChecked()==false && rbotn2.isChecked() ==false&&rbotn3.isChecked() ==false)
        {
            Toast.makeText(this,"No se a seleccionado la prioridad", Toast.LENGTH_LONG).show();
            return;
        }
        if(rbotn1.isChecked())
        {
            shepp=1;
        }else if(rbotn2.isChecked())
        {
            shepp=2;
        }
        else if(rbotn3.isChecked())
        {
            shepp=3;
        }
        if ( opcionSeleccionada1==null||opcionSeleccionada2==null)
        {
            Toast.makeText(this,"No tiene datos los combos", Toast.LENGTH_LONG).show();
            return;
        }
        if ( opcionSeleccionada1.getId()==null||opcionSeleccionada2.getId()==null)
        {
            Toast.makeText(this,"Los combos tienen ID nulos", Toast.LENGTH_LONG).show();
            return;
        }
        EmbarquesAsigadosRequest request = new EmbarquesAsigadosRequest();
        request.setInitial_yard_mule_driver_id(opcionSeleccionada1.getId().intValue());

        request.setRamp(edtRamp.getText().toString());
        request.setInitial_parking_space(edttcajon.getText().toString());
        request.setFinal_yard_mule_driver_id(opcionSeleccionada2.getId().intValue());
        request.setFinal_parking_space(edtcajonFin.getText().toString());
        request.setShipping_priority(shepp);
        detalleEmbarquePresenter.postDetails(fEmbarqueJson.getId(),request);
    }


    public  void displayToast()    {
        Toast.makeText(DetalleEmbarque.this,"Guardado, Exitoso",Toast.LENGTH_SHORT);
    }

    @OnClick (R.id.btncancelar)
    public  void anterior_Nav(View view)
    {
        Intent anterior = new  Intent (this, EmbarquesActivity.class);
        startActivity(anterior);

    }

    @Override
    public void onBackPressed() {
        Intent anterior = new  Intent (this, EmbarquesActivity.class);
        startActivity(anterior);
        finish ();
    }

}
