package com.w77996.hireader.homepage.main;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.w77996.hireader.R;
import com.w77996.hireader.news.NewsFragment;
import com.w77996.hireader.todayofhistory.TodayOfHistoryFragment;
import com.w77996.hireader.todayofhistory.presenter.TodayOfHistoryPresenter;

public class MainActivity extends AppCompatActivity {

    private  MainFragment mainFragment;
    private TodayOfHistoryFragment todayOfHistoryFragment;
    private TodayOfHistoryPresenter todayOfHistoryPresenter;

    private NewsFragment newsFragment;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mainFragment = MainFragment.getInstance();
        todayOfHistoryFragment = TodayOfHistoryFragment.getInstance();
        newsFragment = NewsFragment.getInstance();
        todayOfHistoryPresenter = new TodayOfHistoryPresenter(MainActivity.this,todayOfHistoryFragment);
        if(!mainFragment.isAdded()){
            getSupportFragmentManager().beginTransaction().add(R.id.main_container,mainFragment,"MainFragment").commit();
        }
        if(!todayOfHistoryFragment.isAdded()){
            getSupportFragmentManager().beginTransaction().add(R.id.main_container,todayOfHistoryFragment,"todyFragment").commit();
        }
        if(!newsFragment.isAdded()){
            getSupportFragmentManager().beginTransaction().add(R.id.main_container,newsFragment,"newsFragment").commit();
        }
        showMainFragment();
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
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout .closeDrawer(GravityCompat.START);
                int id = item.getItemId();
                if (id == R.id.nav_home) {
                    showMainFragment();
                } else if (id == R.id.nav_todayofhistory) {
                    showTodayOfHitoryFragment();
                }else if (id == R.id.nav_news) {
                    showNewsFragment();
                }
                return true;
            }
        });
    }
    private void showMainFragment() {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.show(mainFragment);
        fragmentTransaction.hide(todayOfHistoryFragment);
        fragmentTransaction.hide(newsFragment);
        fragmentTransaction.commit();

        toolbar.setTitle(getResources().getString(R.string.app_name));

    }

    private void showTodayOfHitoryFragment() {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.show(todayOfHistoryFragment);
        fragmentTransaction.hide(mainFragment);
        fragmentTransaction.hide(newsFragment);

        fragmentTransaction.commit();

        toolbar.setTitle("历史上的今天");



    }
    private void showNewsFragment() {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.show(newsFragment);
        fragmentTransaction.hide(mainFragment);
        fragmentTransaction.hide(todayOfHistoryFragment);

        fragmentTransaction.commit();

        toolbar.setTitle("新闻资讯");



    }
}
