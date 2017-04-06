package com.w77996.hireader.homepage;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.w77996.hireader.R;
import com.w77996.hireader.about.AboutActivity;
import com.w77996.hireader.chat.ChatFragment;
import com.w77996.hireader.setting.SettingActivity;
import com.w77996.hireader.weather.WeatherFragment;
import com.w77996.hireader.weather.presenter.WeatherPresenter;
import com.w77996.hireader.zhihuguokr.ZhihuGuokrMainFragment;
import com.w77996.hireader.news.NewsFragment;
import com.w77996.hireader.todayofhistory.TodayOfHistoryFragment;
import com.w77996.hireader.todayofhistory.presenter.TodayOfHistoryPresenter;

public class MainActivity extends AppCompatActivity {

    private ZhihuGuokrMainFragment zhihuGuokrMainFragment;
    private TodayOfHistoryFragment todayOfHistoryFragment;
    private TodayOfHistoryPresenter todayOfHistoryPresenter;
    private ChatFragment chatFragment;
    private NewsFragment newsFragment;
    private WeatherFragment weatherFragment;
    private WeatherPresenter weatherPresenter;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        zhihuGuokrMainFragment = ZhihuGuokrMainFragment.newInstance();
        todayOfHistoryFragment = TodayOfHistoryFragment.newInstance();
        newsFragment = NewsFragment.newInstance();
        chatFragment = ChatFragment.newIntance();
        weatherFragment = WeatherFragment.newInstance();

        todayOfHistoryPresenter = new TodayOfHistoryPresenter(MainActivity.this,todayOfHistoryFragment);
        weatherPresenter = new WeatherPresenter(MainActivity.this,weatherFragment);
        if(!zhihuGuokrMainFragment.isAdded()){
            getSupportFragmentManager().beginTransaction().add(R.id.main_container, zhihuGuokrMainFragment,"MainFragment").commit();
        }
        if(!todayOfHistoryFragment.isAdded()){
            getSupportFragmentManager().beginTransaction().add(R.id.main_container,todayOfHistoryFragment,"todyFragment").commit();
        }
        if(!newsFragment.isAdded()){
            getSupportFragmentManager().beginTransaction().add(R.id.main_container,newsFragment,"newsFragment").commit();
        }
        if(!chatFragment.isAdded()){
            getSupportFragmentManager().beginTransaction().add(R.id.main_container,chatFragment,"chatFragment").commit();
        }
        if(!weatherFragment.isAdded()){
            getSupportFragmentManager().beginTransaction().add(R.id.main_container,weatherFragment,"waetherFragment").commit();
        }
        showNewsFragment();

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
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("新闻资讯");
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
                }else if(id==R.id.nav_about){
                    MainActivity.this.startActivity(new Intent(MainActivity.this, AboutActivity.class));
                }else if(id==R.id.nav_chat){
                   showChatFragment();
                }else if(id==R.id.nav_weather){
                    showWeatherFragment();
                }else if(id==R.id.nav_settings){
                    MainActivity.this.startActivity(new Intent(MainActivity.this, SettingActivity.class));
                }
                return true;
            }

            
        });
    }

    private void showChatFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.show(chatFragment);
        fragmentTransaction.hide(todayOfHistoryFragment);
        fragmentTransaction.hide(newsFragment);
        fragmentTransaction.hide(zhihuGuokrMainFragment);
        fragmentTransaction.hide(weatherFragment);
        fragmentTransaction.commit();

        toolbar.setTitle("聊天机器人");
    }

    private void showMainFragment() {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.show(zhihuGuokrMainFragment);
        fragmentTransaction.hide(todayOfHistoryFragment);
        fragmentTransaction.hide(newsFragment);
        fragmentTransaction.hide(chatFragment);
        fragmentTransaction.hide(weatherFragment);
        fragmentTransaction.commit();

        toolbar.setTitle("知乎果壳");

    }

    private void showTodayOfHitoryFragment() {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.show(todayOfHistoryFragment);
        fragmentTransaction.hide(zhihuGuokrMainFragment);
        fragmentTransaction.hide(newsFragment);
        fragmentTransaction.hide(chatFragment);
        fragmentTransaction.hide(weatherFragment);
        fragmentTransaction.commit();

        toolbar.setTitle("历史上的今天");

    }
    private void showNewsFragment() {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.show(newsFragment);
        fragmentTransaction.hide(zhihuGuokrMainFragment);
        fragmentTransaction.hide(todayOfHistoryFragment);
        fragmentTransaction.hide(chatFragment);
        fragmentTransaction.hide(weatherFragment);
        fragmentTransaction.commit();

        toolbar.setTitle("新闻资讯");
    }
    private void showWeatherFragment() {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.show(weatherFragment);
        fragmentTransaction.hide(zhihuGuokrMainFragment);
        fragmentTransaction.hide(todayOfHistoryFragment);
        fragmentTransaction.hide(chatFragment);
        fragmentTransaction.hide(newsFragment);
        fragmentTransaction.commit();

        toolbar.setTitle("城市天气");
    }
}
