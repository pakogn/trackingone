package com.spyc.trackingone.ui.embarquesMulero;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import android.widget.TextView;

import com.spyc.trackingone.R;
import com.spyc.trackingone.data.network.model.FilaEmbarqueResponse;
import com.spyc.trackingone.ui.Embarques.EmbarquesAdapter;
import com.spyc.trackingone.ui.Embarques.EmbarquesContract;
import com.spyc.trackingone.ui.Embarques.EmbarquesMvpPresenter;
import com.spyc.trackingone.ui.base.BaseActivity;
import com.spyc.trackingone.ui.login.LoginActivity;
import com.topwise.cloudpos.aidl.AidlDeviceService;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EmbarquesMuleroActivity extends BaseActivity implements EmbarquesMuleroContract,
        EmbarquesMuleroAdapter.Callback, SearchView.OnQueryTextListener {

    @Inject
    EmbarquesMuleroMvpPrensenter<EmbarquesMuleroContract> embarquesMuleroMvpPresenter;

    @Inject
    EmbarquesMuleroAdapter embarquesMuleroAdapter;

    @Inject
    LinearLayoutManager eLayoutManager;

    @BindView(R.id.toolbar)
    Toolbar vtoolbar;

    @BindView(R.id.toolbar_title)
    TextView toolbar_title;

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

    private List<FilaEmbarqueResponse> newListEmbarques;

    @Override
    public void onDeviceConnected(AidlDeviceService serviceManager) {

    }

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, EmbarquesMuleroActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_embarques_mulero);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        embarquesMuleroMvpPresenter.onAttach(this);

        newListEmbarques = embarquesMuleroAdapter.getData();

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
        eRecyclerView.setAdapter(embarquesMuleroAdapter);

        embarquesMuleroMvpPresenter.cargandoTabla();

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
        embarquesMuleroMvpPresenter.onNavMenuCreated();
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
                                embarquesMuleroMvpPresenter.onDrawerOptionLogoutClick();
                                return true;
                            default:
                                return false;
                        }
                    }
                });
    }


    @Override
    public void actualizaEmbarques(List<FilaEmbarqueResponse> embarquesList) {
        embarquesMuleroAdapter.addItems(embarquesList);
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
        final List<FilaEmbarqueResponse> filterModeList = filter(newListEmbarques, newText);
        embarquesMuleroAdapter.setFilter(filterModeList);
        return true;
    }

    private List<FilaEmbarqueResponse> filter(List<FilaEmbarqueResponse> models, String query) {
        query = query.toLowerCase();

        final List<FilaEmbarqueResponse> filteredModelList = new ArrayList<>();
        for (FilaEmbarqueResponse model : models) {
            final String text = model.getContainer().toLowerCase();
            final String text1 = model.getShipping_number().toLowerCase();
            final String text2 = model.getCarrier_id().toLowerCase();
            final String text3 = model.getTruck_number().toLowerCase();
            if (text.contains(query) || text1.contains(query) ||text2.contains(query) || text3.contains(query)) {
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
                        embarquesMuleroAdapter.setFilter(newListEmbarques);
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
