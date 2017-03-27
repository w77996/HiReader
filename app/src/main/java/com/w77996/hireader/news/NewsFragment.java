package com.w77996.hireader.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.w77996.hireader.R;
import com.w77996.hireader.news.adapter.NewsPagerAdapter;
import com.w77996.hireader.news.contract.NewsListContract;

/**
 * Created by Administrator on 2017/3/14.
 */
public class NewsFragment extends Fragment {


    public static final String TYPE_DOMESTIC = "国内";
    public static final String TYPE_INTERNETIONAL= "国际";//国际
    public static final String TYPE_MILITARY = "军事";//军事
    public static final String TYPE_FINANCE = "财经";//财经
    public static final String TYPE_INTERNET = "互联网";//互联网
    public static final String TYPE_ESTATE = "房地产";//房地产
    public static final String TYPE_CAR = "汽车";//汽车
    public static final String TYPE_SPORT = "体育";//体育
    public static final String TYPE_ENTERTAINMENT = "娱乐";//娱乐
    public static final String TYPE_GAMES ="游戏";//游戏
    public static final String TYPE_EDUCATIONAL = "教育";//教育
    public static final String TYPE_WOMEN = "女人";//女人
    public static final String TYPE_TECHNOLOGY = "科技";//科技
    public static final String TYPE_SOCIAL= "社会";//社会



    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FloatingActionButton floatingActionButton;
    public static NewsFragment newInstance(){
        return new NewsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        tabLayout = (TabLayout)view.findViewById(R.id.fragment_main_tablayout);
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        viewPager = (ViewPager)view.findViewById(R.id.fragment_main_viewpager);
        viewPager.setOffscreenPageLimit(12);
        floatingActionButton = (FloatingActionButton)view.findViewById(R.id.fragment_main_fab);
        floatingActionButton.hide();
        NewsPagerAdapter newsPagerAdapter = new NewsPagerAdapter(getChildFragmentManager());
        newsPagerAdapter.addFragment(NewsListFragment.getInstance(TYPE_DOMESTIC),TYPE_DOMESTIC);
        newsPagerAdapter.addFragment(NewsListFragment.getInstance(TYPE_INTERNETIONAL),TYPE_INTERNETIONAL);
        newsPagerAdapter.addFragment(NewsListFragment.getInstance(TYPE_MILITARY),TYPE_MILITARY);
        newsPagerAdapter.addFragment(NewsListFragment.getInstance(TYPE_FINANCE),TYPE_FINANCE);
        newsPagerAdapter.addFragment(NewsListFragment.getInstance(TYPE_INTERNET),TYPE_INTERNET);
       // newsPagerAdapter.addFragment(NewsListFragment.newInstance(TYPE_ESTATE),TYPE_ESTATE);
        newsPagerAdapter.addFragment(NewsListFragment.getInstance(TYPE_CAR),TYPE_CAR);
        newsPagerAdapter.addFragment(NewsListFragment.getInstance(TYPE_SPORT),TYPE_SPORT);
        newsPagerAdapter.addFragment(NewsListFragment.getInstance(TYPE_ENTERTAINMENT),TYPE_ENTERTAINMENT);
        newsPagerAdapter.addFragment(NewsListFragment.getInstance(TYPE_GAMES),TYPE_GAMES);
        newsPagerAdapter.addFragment(NewsListFragment.getInstance(TYPE_EDUCATIONAL),TYPE_EDUCATIONAL);
        newsPagerAdapter.addFragment(NewsListFragment.getInstance(TYPE_WOMEN),TYPE_WOMEN);
        newsPagerAdapter.addFragment(NewsListFragment.getInstance(TYPE_TECHNOLOGY),TYPE_TECHNOLOGY);
        newsPagerAdapter.addFragment(NewsListFragment.getInstance(TYPE_SOCIAL),TYPE_SOCIAL);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(newsPagerAdapter);
    }


}