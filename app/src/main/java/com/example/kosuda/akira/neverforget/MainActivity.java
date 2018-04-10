package com.example.kosuda.akira.neverforget;


import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

// TODO: 2018/04/10 動作せず、エラーの出る位置がいじっていないところなので対処不能



public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    final String[] fragments={
            "com.example.kosuda.akira.neverforget.MysizeFragment",
            "com.example.kosuda.akira.neverforget.PropertyFragment",
            "com.example.kosuda.akira.neverforget.MemorialFragment",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        drawer.openDrawer(GravityCompat.START);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();


        FragmentManager fragmentManager = getSupportFragmentManager();
        switch (id){
            case R.id.nav_mysize:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, Fragment.instantiate(MainActivity.this,fragments[0]))
                        .commit();
                break;
            case R.id.nav_property:
                fragmentManager.beginTransaction()
                        .replace(R.id.container,Fragment.instantiate(MainActivity.this,fragments[1]))
                        .commit();
                break;
            case R.id.nav_memorial:
                fragmentManager.beginTransaction()
                        .replace(R.id.container,Fragment.instantiate(MainActivity.this,fragments[2]))
                        .commit();
                break;

        }

        DrawerLayout drawer  =(DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }



}
