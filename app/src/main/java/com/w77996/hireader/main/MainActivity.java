package com.w77996.hireader.main;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.w77996.hireader.R;

public class MainActivity extends AppCompatActivity {

    private  MainFragment mainFragment;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mainFragment = MainFragment.getInstance();
        if(!mainFragment.isAdded()){
            getSupportFragmentManager().beginTransaction().add(R.id.main_container,mainFragment,"MainFragment").commit();
        }
    }

    private void initView() {
        drawerLayout = (DrawerLayout)findViewById(R.id.mian_drawlayout);
        toolbar = (Toolbar)findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
         navigationView = (NavigationView) findViewById(R.id.main_nav_view);

    }
}
