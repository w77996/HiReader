package com.w77996.hireader.todayofhistory;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.orhanobut.logger.Logger;
import com.w77996.hireader.R;
import com.w77996.hireader.todayofhistory.bean.TodayOfHistoryDetailBean;
import com.w77996.hireader.todayofhistory.contract.TodayOfHistoryDetailContract;
import com.w77996.hireader.todayofhistory.presenter.TodayOfHistoryDetailPresenter;

import org.w3c.dom.Text;

/**
 * Created by Administrator on 2017/3/27.
 */
public class TodayOfHistoryDetailActivity extends AppCompatActivity implements TodayOfHistoryDetailContract.View{
    ImageView imageView;
    TextView textView;
    FloatingActionButton floatingActionButton;
    String content;
    Toolbar mToolbar;
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    TodayOfHistoryDetailContract.Presenter presenter;
    TodayOfHistoryDetailPresenter todayOfHistoryDetailPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_todayofhistory_detail);
        initView();
        todayOfHistoryDetailPresenter = new TodayOfHistoryDetailPresenter(TodayOfHistoryDetailActivity.this,this);
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        mCollapsingToolbarLayout.setTitle(title);
        mCollapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.mdtp_white));
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.mdtp_white));

        String id = intent.getStringExtra("id")+"";
        Logger.d(id+"");
        presenter.requestData(id);

    }
    public void initView(){
        imageView = (ImageView)findViewById(R.id.todayofhistoryd_detail_img);
        textView = (TextView)findViewById(R.id.todayofhistoryd_detail_tv);
        floatingActionButton =(FloatingActionButton)findViewById(R.id.todayofhistoryd_detail_fb);
        mToolbar = (Toolbar)findViewById(R.id.todayofhistoryd_detail_toolbar);
        mCollapsingToolbarLayout=(CollapsingToolbarLayout)findViewById(R.id.todayofhistoryd_detail_collapsintoolbarlayout);
        
      /*  mToolbarLayout= (CollapsingToolbarLayout)findViewById(R.id.toolbar_layout);*/
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(content);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public void showResult(TodayOfHistoryDetailBean todayOfHistoryDetailBean) {
        content = todayOfHistoryDetailBean.getResult().get(0).getContent();
        textView.setText(content);
        mToolbar.setTitle(todayOfHistoryDetailBean.getResult().get(0).getTitle());
        String imgurl = todayOfHistoryDetailBean.getResult().get(0).getPic();
        if("".equals(imgurl)||null==imgurl){
            Glide.with(this).load(R.drawable.nav_header).asBitmap().into(imageView);
        }else{
            Glide.with(this).load(imgurl).asBitmap().into(imageView);
        }
    }
    @Override
    public void showError() {

    }

    @Override
    public void shareData(String txt) {
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");
        sharingIntent.putExtra(Intent.EXTRA_TEXT, txt);
        startActivity(Intent.createChooser(sharingIntent, "分享"));
    }

    @Override
    public void setPresenter(TodayOfHistoryDetailContract.Presenter presenter) {
        if(presenter!=null){
            this.presenter = presenter;
        }
    }

    @Override
    public void initView(View view) {

    }
}
