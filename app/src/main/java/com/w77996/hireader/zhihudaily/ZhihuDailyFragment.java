package com.w77996.hireader.zhihudaily;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.w77996.hireader.R;
import com.w77996.hireader.interfaze.OnRecyclerViewOnClickListener;
import com.w77996.hireader.utils.DateFomatter;
import com.w77996.hireader.zhihudaily.adapter.ZhihuDailyAdapter;
import com.w77996.hireader.zhihudaily.bean.ZhihuDailyBean;
import com.w77996.hireader.zhihudaily.contract.ZhihuDailyContract;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by w77996 on 2017/3/11.
 */
public class ZhihuDailyFragment extends Fragment  implements ZhihuDailyContract.View{

    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private FloatingActionButton mFloatingActionButton;
    private TabLayout mTabLayout;

    private ZhihuDailyContract.Presenter presenter;
    DateFomatter dateFomatter = new DateFomatter();
    private ZhihuDailyAdapter zhihuDailyAdapter;

    private int mYear = Calendar.getInstance().get(Calendar.YEAR);
    private int mMonth = Calendar.getInstance().get(Calendar.MONTH);
    private int mDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    public static ZhihuDailyFragment newInstance(){
        return new ZhihuDailyFragment();
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      //  Log.d("ddd","dddddddddddddddd");
        View view = inflater.inflate(R.layout.fragment_content,container,false);
        initView(view);
        presenter.start();

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.refresh();
            }
        });
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            boolean isSlidingToFooter = false;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager)mRecyclerView.getLayoutManager();
                if(newState == RecyclerView.SCROLL_STATE_IDLE){
                    int lastVisibleItem = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                    int totalItemCount = linearLayoutManager.getItemCount();
                    if(lastVisibleItem == (totalItemCount-1)&&isSlidingToFooter){
                        Calendar c = Calendar.getInstance();
                        c.set(mYear, mMonth, --mDay);
                        presenter.loadMore(c.getTimeInMillis());
                    }
                }
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                isSlidingToFooter = dy>0;
                if(dy>0){
                    mFloatingActionButton.hide();
                }else{
                    mFloatingActionButton.show();
                }
            }
        });

        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mTabLayout.getSelectedTabPosition() == 0) {
                    showPickerDialog();
                }
            }
        });
        return view;
    }

    @Override
    public void showLoading() {
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);
            }
        });
    }

    @Override
    public void stopLoading() {
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public void showError() {
        Snackbar.make(mFloatingActionButton, "加载失败",Snackbar.LENGTH_INDEFINITE)
                .setAction("重试", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        presenter.refresh();
                    }
                })
                .show();
    }

    @Override
    public void showResult(List<ZhihuDailyBean.StoriesBean> list) {
        if(zhihuDailyAdapter==null){
            zhihuDailyAdapter = new ZhihuDailyAdapter(getContext(),list);
            zhihuDailyAdapter.setItemOnClick(new OnRecyclerViewOnClickListener() {
                @Override
                public void onItemClick(View v, int position) {
                    presenter.loadDetail(position);
                }
            });
            mRecyclerView.setAdapter(zhihuDailyAdapter);
        }else{
            zhihuDailyAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public void showPickerDialog() {
        Calendar now = Calendar.getInstance();
        now.set(mYear, mMonth, mDay);
        DatePickerDialog dialog = DatePickerDialog.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
                mYear = year;
                mMonth = monthOfYear;
                mDay = dayOfMonth;
                Calendar temp = Calendar.getInstance();
                temp.clear();
                temp.set(year, monthOfYear, dayOfMonth);
                presenter.requestData(temp.getTimeInMillis(), true);
            }
        }, now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));

        dialog.setMaxDate(Calendar.getInstance());
        Calendar minDate = Calendar.getInstance();
        // 2013.5.20是知乎日报api首次上线
        minDate.set(2013, 5, 20);
        dialog.setMinDate(minDate);
        dialog.vibrate(false);

        dialog.show(getActivity().getFragmentManager(), "DatePickerDialog");
    }

    @Override
    public void setPresenter(ZhihuDailyContract.Presenter presenter) {
        if(presenter!=null){
            this.presenter =presenter;
        }
    }

    @Override
    public void initView(View view) {
        mSwipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.fragment_content_swiperefreshlayout);
        mRecyclerView = (RecyclerView)view.findViewById(R.id.fragment_content_recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mFloatingActionButton = (FloatingActionButton)getActivity().findViewById(R.id.fragment_main_fab);
        mTabLayout = (TabLayout)getActivity().findViewById(R.id.fragment_main_tablayout);
    }
}
