package com.w77996.hireader.main;

import android.content.Context;
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
import com.w77996.hireader.guokr.GuokrFragment;
import com.w77996.hireader.guokr.presenter.GuokrPresenter;
import com.w77996.hireader.zhihudaily.ZhihuDailyFragment;
import com.w77996.hireader.zhihudaily.ZhihuDailyPresenter;

/**
 * Created by Administrator on 2017/3/11.
 */
public class MainFragment extends Fragment {
    private Context mContext;
    private TabLayout mTabLayout;
    private FloatingActionButton mFloatingActionButton;
    private MainPagerAdpater mainPagerAdpater;

    private ZhihuDailyFragment zhihuDailyFragment;
    private ZhihuDailyPresenter zhihuDailyPresenter;
    private GuokrFragment guokrFragment;
    private GuokrPresenter guokrPresenter;
    public MainFragment(){

    }
    public static MainFragment getInstance(){
        return new MainFragment();
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext = getActivity();
        zhihuDailyFragment = ZhihuDailyFragment.newInstance();
        guokrFragment = GuokrFragment.newInstance();
        zhihuDailyPresenter = new ZhihuDailyPresenter(mContext, zhihuDailyFragment);
        guokrPresenter = new GuokrPresenter(mContext,guokrFragment);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        initView(view);
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fragment_main_fab);
                if (tab.getPosition() != 0) {
                    fab.hide();
                }else{
                    fab.show();
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return view;
    }

    private void initView(View view) {
        mTabLayout = (TabLayout) view.findViewById(R.id.fragment_main_tablayout);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.fragment_main_viewpager);
        viewPager.setOffscreenPageLimit(2);

        mainPagerAdpater = new MainPagerAdpater(
                getChildFragmentManager(),
                mContext,
                zhihuDailyFragment,
                guokrFragment
               );

        viewPager.setAdapter(mainPagerAdpater);
        mTabLayout.setupWithViewPager(viewPager);
    }
}
