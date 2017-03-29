package com.w77996.hireader.setting;

import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.w77996.hireader.R;
import com.w77996.hireader.utils.GlideCacheUtils;

import java.io.File;

/**
 * time:2017/3/29
 * Created by w77996
 * Github:https://github.com/w77996
 * CSDN:http://blog.csdn.net/w77996?viewmode=contents
 */
public class SettingActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private TextView mTextViewCache;
    private LinearLayout mLinearLayoutClearCache;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        mToolbar = (Toolbar)findViewById(R.id.setting_toolbar);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        //mToolbar.setTitle("设置");
        actionBar.setTitle("设置");
        if (actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);
        Logger.d(GlideCacheUtils.getInstance().getCacheSize(getApplicationContext()));
        mTextViewCache = (TextView)findViewById(R.id.setting_cache);
        mTextViewCache.setText(GlideCacheUtils.getInstance().getCacheSize(getApplicationContext()));
        mLinearLayoutClearCache = (LinearLayout)findViewById(R.id.setting_clear_layout);
        mLinearLayoutClearCache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
}
