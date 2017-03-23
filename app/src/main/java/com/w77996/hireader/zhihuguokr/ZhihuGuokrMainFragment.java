package com.w77996.hireader.zhihuguokr;

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
import com.w77996.hireader.zhihuguokr.guokr.GuokrFragment;
import com.w77996.hireader.zhihuguokr.guokr.presenter.GuokrPresenter;
import com.w77996.hireader.zhihuguokr.zhihudaily.ZhihuDailyFragment;
import com.w77996.hireader.zhihuguokr.zhihudaily.ZhihuDailyPresenter;

/**
 * Created by Administrator on 2017/3/11.
 */
public class ZhihuGuokrMainFragment extends Fragment {
    private Context mContext;
    private TabLayout mTabLayout;
    private FloatingActionButton mFloatingActionButton;
    private ZhihuGuokrPagerAdpater zhihuGuokrPagerAdpater;

    private ZhihuDailyFragment zhihuDailyFragment;
    private ZhihuDailyPresenter zhihuDailyPresenter;
    private GuokrFragment guokrFragment;
    private GuokrPresenter guokrPresenter;


    public ZhihuGuokrMainFragment(){

    }
    public static ZhihuGuokrMainFragment getInstance(){
        return new ZhihuGuokrMainFragment();
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

        zhihuGuokrPagerAdpater = new ZhihuGuokrPagerAdpater(
                getChildFragmentManager(),
                mContext,
                zhihuDailyFragment,
                guokrFragment
               );

        viewPager.setAdapter(zhihuGuokrPagerAdpater);
        mTabLayout.setupWithViewPager(viewPager);
    }
}
