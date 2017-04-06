package com.w77996.hireader.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.orhanobut.logger.Logger;
import com.w77996.hireader.R;
import com.w77996.hireader.base.BaseFragment;
import com.w77996.hireader.utils.interfaze.OnRecyclerViewOnClickListener;
import com.w77996.hireader.news.adapter.NewsListAdapter;
import com.w77996.hireader.news.bean.NewsBean;
import com.w77996.hireader.news.contract.NewsListContract;
import com.w77996.hireader.news.presenter.NewsListPresenter;
import com.w77996.hireader.utils.DateFomatter;

import java.util.List;

/**
 * Created by Administrator on 2017/3/15.
 */
public class NewsListFragment extends BaseFragment implements NewsListContract.View {

    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private String mType = NewsFragment.TYPE_DOMESTIC;
    private NewsListPresenter newsListPresenter;
    private NewsListContract.Presenter presenter;
    private NewsListAdapter newsListAdapter;
    private FloatingActionButton floatingActionButton;

    private boolean isPreper;// 标识fragment视图已经初始化完毕
    private boolean hasFetchData;// 标识已经触发过懒加载数据
    private int pager =1;
    public static NewsListFragment getInstance(String type){
        Bundle args = new Bundle();
        NewsListFragment fragment = new NewsListFragment();
        args.putString("type", type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content,container,false);
        newsListPresenter = new NewsListPresenter(getContext(),this);
        mType = getArguments().getString("type");
        initView(view);
        isPreper = true;
        Logger.d(mType);
        DateFomatter dateFomatter = new DateFomatter();
//        Logger.d("dddddddddddddddddddddddddddddddddddd");
        presenter.request(mType,1,dateFomatter.NewsDateFormat(),true);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                DateFomatter dateFomatter = new DateFomatter();
                presenter.refresh(mType,dateFomatter.NewsDateFormat());
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
                        DateFomatter dateFomatter = new DateFomatter();
                        presenter.loadMore(mType,dateFomatter.NewsDateFormat());
                    }
                }
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                isSlidingToFooter = dy>0;
            }
        });
        return view;
    }

   /* @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()&&isPreper) {
            DateFomatter dateFomatter = new DateFomatter();
//        Logger.d("dddddddddddddddddddddddddddddddddddd");
            presenter.request(mType,1,dateFomatter.NewsDateFormat(),true);
        }
    }*/
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
        Logger.d(mType);
        Snackbar.make(mSwipeRefreshLayout, "加载失败",Snackbar.LENGTH_INDEFINITE)
                .setAction("重试", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DateFomatter dateFomatter = new DateFomatter();
                        presenter.request(mType,1,dateFomatter.NewsDateFormat(),true);

                    }
                })
                .show();
    }

    @Override
    public void showResult(List<NewsBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean> list) {
//        Logger.d(""+list.size());
        if(newsListAdapter==null){
            newsListAdapter = new NewsListAdapter(getContext(),list);
            newsListAdapter.setItemClickListener(new OnRecyclerViewOnClickListener() {
                @Override
                public void onItemClick(View v, int position) {
                    presenter.showDetail(position);
                }
            });
            mRecyclerView.setAdapter(newsListAdapter);
        }else{
            newsListAdapter.notifyDataSetChanged();
        }
    }

/*    @Override
    public void onResume() {
        super.onResume();
        DateFomatter dateFomatter = new DateFomatter();
//        Logger.d("dddddddddddddddddddddddddddddddddddd");
        presenter.request(mType,1,dateFomatter.NewsDateFormat(),true);
    }*/

    @Override
    public void setPresenter(NewsListContract.Presenter presenter) {
        if(presenter!=null){
            this.presenter = presenter;
        }
    }

    @Override
    public void initView(View view) {
        mSwipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.fragment_content_swiperefreshlayout);
        mRecyclerView = (RecyclerView)view.findViewById(R.id.fragment_content_recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        floatingActionButton = (FloatingActionButton)getActivity().findViewById(R.id.fragment_main_fab);
        floatingActionButton.hide();
    }
  /*  @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Logger.d(getClass().getName() + "------>isVisibleToUser = " +               isVisibleToUser);
        if (isVisibleToUser) {//当当前为显示页面时
            lazyFetchDataIfPrepared();
        }
    }*/
    private void lazyFetchDataIfPrepared() {
// 用户可见fragment && 没有加载过数据 && 视图已经准备完毕
        if (getUserVisibleHint() && !hasFetchData && isPreper) {
            hasFetchData = true; //已加载过数据
           // lazyFetchData();
            DateFomatter dateFomatter = new DateFomatter();
//        Logger.d("dddddddddddddddddddddddddddddddddddd");
            presenter.request(mType,1,dateFomatter.NewsDateFormat(),true);
        }
    }

    @Override
    public void onDestroyView() {
       // onPause();
        newsListAdapter=null;
        super.onDestroyView();
        hasFetchData = false;
        isPreper = false;
    }
}
