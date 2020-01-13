package com.spyc.trackingone.ui.Embarques;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.spyc.trackingone.R;
import com.spyc.trackingone.data.network.model.FilaEmbarqueResponse;
import com.spyc.trackingone.ui.base.BaseActivity;
import com.spyc.trackingone.ui.detalleEmbarque.DetalleEmbarque;
import com.spyc.trackingone.ui.embarqueStatus.EmbarqueStatusActivity;
import com.spyc.trackingone.ui.login.LoginActivity;
import com.topwise.cloudpos.aidl.AidlDeviceService;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EmbarquesActivity extends BaseActivity implements EmbarquesContract,
EmbarquesAdapter.Callback, SearchView.OnQueryTextListener{
    Boolean isScrolling=false;
    int currentItems,totalItems,scrollOutItems;
    int indexActualSize=0;
    //CoordinatorLayout coordinatorLayout;
    @Inject
    EmbarquesMvpPresenter<EmbarquesContract> embarquesMvpPresenter;

    @Inject
    EmbarquesAdapter embarquesAdapter;

    @Inject
    LinearLayoutManager eLayoutManager;

    @BindView(R.id.toolbar)
    Toolbar vtoolbar;

    @BindView(R.id.toolbar_title)
    TextView toolbar_title;
    @BindView(R.id.progress)
    ProgressBar progressBar;

    @BindView(R.id.fila_embarque_recycler)
    RecyclerView eRecyclerView;

    @BindView(R.id.drawer_view)
    DrawerLayout homeDrawer;

    private TextView nameTextView;
    private TextView emailTextView;
    private TextView authTextView;

    @BindView(R.id.navigation_view)
    NavigationView navigationView;

    private ActionBarDrawerToggle homeDrawerToggle;
    private  int TOTAL_DATA_SHOW=15;
   //private List<FilaEmbarqueResponse> newListEmbarques;
    private List<FilaEmbarqueResponse> newListEmbarquesActual= new ArrayList<>();
    private List<FilaEmbarqueResponse> newListEmbarquesTotal;
    private List<FilaEmbarqueResponse> newListEmbarquesTotalBackup;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, EmbarquesActivity.class);
        return intent;
    }

    @Override
    public void onDeviceConnected(AidlDeviceService serviceManager) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_embarques);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        embarquesMvpPresenter.onAttach(this);

       // newListEmbarques = embarquesAdapter.getData();

        setUp();
    }

    @Override
    protected void setUp() {
        setSupportActionBar(vtoolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            //toolbar_title.setText(R.string.embarques);
        }

        eLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        eRecyclerView.setLayoutManager(eLayoutManager);
        eRecyclerView.setItemAnimator(new DefaultItemAnimator());
        eRecyclerView.setAdapter(embarquesAdapter);

        eRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL ){
                    isScrolling=true;
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                currentItems=eLayoutManager.getChildCount();
                totalItems=eLayoutManager.getItemCount();
                scrollOutItems=eLayoutManager.findFirstVisibleItemPosition();
                if(isScrolling&&(currentItems+scrollOutItems==totalItems)&&(newListEmbarquesActual.size()<newListEmbarquesTotal.size())){
                    isScrolling=false;
                    fetchData();
                }
            }
        });
        embarquesMvpPresenter.cargandoTabla();

        homeDrawerToggle = new ActionBarDrawerToggle(
                this,
                homeDrawer,
                vtoolbar,
                R.string.open_drawer,
                R.string.close_drawer) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                hideKeyboard();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        homeDrawer.addDrawerListener(homeDrawerToggle);
        homeDrawerToggle.syncState();
        setupNavMenu();
        embarquesMvpPresenter.onNavMenuCreated();
    }

    /**
     * agrega los datos poco a poco
     */
    private void fetchData() {
        progressBar.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                addItems();
                eRecyclerView.getAdapter().notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);
            }
        }, 700);
    }

    void setupNavMenu() {
        View headerLayout = navigationView.getHeaderView(0);

        nameTextView = (TextView) headerLayout.findViewById(R.id.tv_name);
        emailTextView = (TextView) headerLayout.findViewById(R.id.tv_email);
        authTextView = (TextView) headerLayout.findViewById(R.id.tv_auth);

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        homeDrawer.closeDrawer(GravityCompat.START);
                        switch (item.getItemId()) {
                            case R.id.nav_item_logout:
                                embarquesMvpPresenter.onDrawerOptionLogoutClick();
                                return true;
                            case R.id.nav_item_embarques:
                                Intent intent = DetalleEmbarque.getStartIntent(EmbarquesActivity.this);
                                startActivity(intent);
                                finish();
                                return true;
                            default:
                                return false;
                        }
                    }
                });
    }

    @Override
    @OnClick(R.id.btn_rampa)
    public void filtrarPendientesEnRampa() {
        pendientesEnRampa();
    }

    @Override
    @OnClick(R.id.btn_cajon)
    public void filtrarPendientesEnCajon() {
        pendientesEnCajon();
    }

    @OnClick(R.id.btn_todos)
    public void filtrarTodos() {
        embarquesMvpPresenter.cargandoTabla();
    }
    @OnClick(R.id.btn_cajon)
    public void filtrarTodosCaja() {
        embarquesMvpPresenter.cargandoTablaPendientesCajon();
    }

    @OnClick(R.id.btn_rampa)
    public void filtrarTodosRampa() {
        embarquesMvpPresenter.cargandoTablaPendientesRampa();
    }

    @Override
    public void actualizaEmbarques(List<FilaEmbarqueResponse> embarquesList) {
        addDataInAdapter(embarquesList,false);
    }

    @Override
    public void actualizaEmbarquesPendientesCajon(List<FilaEmbarqueResponse> embarquesList) {
        addDataInAdapter(embarquesList,true);
    }

    @Override
    public void actualizaEmbarquesPendientesRampa(List<FilaEmbarqueResponse> embarquesList) {
        addDataInAdapter(embarquesList,true);
    }
    public  void addDataInAdapter(List<FilaEmbarqueResponse> embarquesList,boolean filter){
        indexActualSize=0;
        newListEmbarquesTotal=embarquesList;
          newListEmbarquesActual.clear();
        newListEmbarquesTotalBackup=embarquesList;
        embarquesAdapter.setAllData(embarquesList);
        addItems();
        //eRecyclerView.setAdapter(embarquesAdapter);
        embarquesAdapter.clearData();
        embarquesAdapter.addItems(newListEmbarquesActual);
        embarquesAdapter.notifyDataSetChanged();
    }

    public  void addItems(){
       if(newListEmbarquesTotal!=null){
           int count =0;
           for (int i =indexActualSize;i<newListEmbarquesTotal.size();i++){
               if(count<=TOTAL_DATA_SHOW){
                   count++;
                   indexActualSize=i;
                   embarquesAdapter.addItemsOne(newListEmbarquesTotal.get(i));
                   newListEmbarquesActual.add(newListEmbarquesTotal.get(i));
               }

           }
       }
       if(newListEmbarquesActual.size()==newListEmbarquesTotal.size()){
           Log.d("Se cargo toda la lista",""+newListEmbarquesActual.size());
       }
       Log.d("Total_Item actual:",""+newListEmbarquesActual.size());
    }

    public void pendientesEnCajon() {
        ArrayList<FilaEmbarqueResponse> filterList = new ArrayList<FilaEmbarqueResponse>();
        Log.e("TOTAL: ",""+embarquesAdapter.getItemCount());

        for(int i=0; i<embarquesAdapter.getItemCount(); i++){
            if( embarquesAdapter.getData().get(i).getRamp() == null){
                filterList.add(embarquesAdapter.getData().get(i));
            }
        }
        embarquesAdapter.getData().clear();
        Log.d("DESPUES: ",""+filterList.size());
        actualizaEmbarques(filterList);
    }

    public void pendientesEnRampa() {
        ArrayList<FilaEmbarqueResponse> filterList = new ArrayList<FilaEmbarqueResponse>();
        Log.e("TOTAL: ",""+embarquesAdapter.getItemCount());

        for(int i=0; i<embarquesAdapter.getItemCount(); i++){
            if( embarquesAdapter.getData().get(i).getRamp() != null && embarquesAdapter.getData().get(i).getInitial_parking_space() != null){
                filterList.add(embarquesAdapter.getData().get(i));
            }
        }
        embarquesAdapter.getData().clear();
        Log.d("DESPUES: ",""+filterList.size());
        actualizaEmbarques(filterList);
    }

    @Override
    public void updateUserName(String currentUserName) {
        nameTextView.setText(currentUserName);
    }

    @Override
    public void updateUserEmail(String currentUserEmail) {
        emailTextView.setText(currentUserEmail);
    }

    @Override
    public void updateAuth(Long currentAuth) {
        authTextView.setText("Rol: "+currentAuth);
    }


    @Override
    public void openLoginActivity() {
        startActivity(LoginActivity.getStartIntent(this));
        finish();
    }

    @Override
    public void closeNavigationDrawer() {
        if (homeDrawer != null) {
            homeDrawer.closeDrawer(Gravity.START);
        }
    }

    @Override
    public void lockDrawer() {
        if (homeDrawer != null)
            homeDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }

    @Override
    public void unlockDrawer() {
        if (homeDrawer != null)
            homeDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public boolean onQueryTextSubmit(String newText) {
        return false;
    }



    @Override
    public boolean onQueryTextChange(String newText) {
        final List<FilaEmbarqueResponse> filterModeList = filter(newListEmbarquesTotalBackup, newText);
        embarquesAdapter.setFilter(filterModeList);
        return true;
    }

    private List<FilaEmbarqueResponse> filter(List<FilaEmbarqueResponse> models, String query) {
        query = query.toLowerCase();

        final List<FilaEmbarqueResponse> filteredModelList = new ArrayList<>();
        for (FilaEmbarqueResponse model : models) {
            final String text = model.getLicense_plate().toLowerCase();
            final String text1 = model.getShipping_number().toLowerCase();
            final String text2 = model.getContainer().toLowerCase();
            final String text3 = model.getTruck_number().toLowerCase();
            if (text.contains(query) || text1.contains(query) || text2.contains(query) || text3.contains(query)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);

        final MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);

        MenuItemCompat.setOnActionExpandListener(item,
                new MenuItemCompat.OnActionExpandListener() {
                    @Override
                    public boolean onMenuItemActionCollapse(MenuItem item) {
                        // Do something when collapsed
                        embarquesAdapter.setFilter(newListEmbarquesActual);
                        return true; // Return true to collapse action view
                    }

                    @Override
                    public boolean onMenuItemActionExpand(MenuItem item) {
                        // Do something when expanded
                        return true; // Return true to expand action view
                    }
                });
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        // startStep1();
        if (homeDrawer != null)
            homeDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    }


    @Override
    public void onBlogEmptyViewRetryClick() {

    }
}
