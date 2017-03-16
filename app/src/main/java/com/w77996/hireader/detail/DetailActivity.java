package com.w77996.hireader.detail;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.customtabs.CustomTabsCallback;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.orhanobut.logger.Logger;
import com.w77996.hireader.R;
import com.w77996.hireader.homepage.zhihudaily.bean.ZhihuDailyBean;
import com.w77996.hireader.homepage.zhihudaily.bean.ZhihuDetailBean;
import com.w77996.hireader.utils.Api;
import com.w77996.hireader.utils.ApiService;
import com.w77996.hireader.utils.HttpUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/3/15.
 */
public class DetailActivity extends AppCompatActivity {
    WebView webView;
    private Toolbar toolbar;
    private int mType;
    private String mUrl;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_fragment);

         webView = (WebView)findViewById(R.id.webview);
        toolbar = (Toolbar)findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      /*  DetailFragment detailFragment = DetailFragment.newInstance();
        if(!detailFragment.isAdded()){
            getSupportFragmentManager().beginTransaction().replace(R.id.detail_frament,detailFragment,"DetailFragment").commit();
        }*/
        //setHasOptionsMenu(true);
        WebSettings webSettings  =webView.getSettings();
        webView.setScrollbarFadingEnabled(true);
        webSettings.setJavaScriptEnabled(true);
       webSettings.setDomStorageEnabled(true);
        webSettings.setBuiltInZoomControls(false);
        Intent intent = getIntent();
        mType = intent.getIntExtra("type",1);
        webView.setWebViewClient(new webViewClient());
        String id;
        String url;
        switch (mType){
            case BeanType.TYPE_ZHIHU:
                id= intent.getStringExtra("id");
                url= Api.ZHIHU_NEWS+id;

             HttpUtils.getInstance()
                        .create(ApiService.class,Api.ZHIHU_NEWS)
                        .getZhihuDetailNews(id)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<ZhihuDetailBean>() {
                            @Override
                            public void accept(ZhihuDetailBean zhihuDetailBean) throws Exception {
                                    String url = zhihuDetailBean.getShare_url();
                                Logger.d(url);
                                webView.loadUrl(url);
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                Logger.e(throwable+"");
                            }
                        });
                break;
            case BeanType.TYPE_GUOKR:
                 id= intent.getStringExtra("id");
                 url = Api.GUOKR_ARTICLE_LINK+"pick/"+id;
                Logger.d(url);
                webView.loadUrl(url);
                break;
            case BeanType.TYPE_HISTORY:

                break;
            case BeanType.TYPE_NEWS:
                id= intent.getStringExtra("link");
                webView.loadUrl(id);
                break;
        }
      //  String url = "http://daily.zhihu.com/story/9289923";
     //   Logger.d(url);
      //  webView.loadUrl(url);

      //  Logger.d(Api.ZHIHU_NEWS+url);

    }

    private void swithcType(String mType) {

    }

    private class webViewClient extends WebViewClient {
        @Override

        public boolean shouldOverrideUrlLoading(WebView view, String url) {

          /*  CustomTabsIntent.Builder customTabsIntent = new CustomTabsIntent.Builder()
                    .setToolbarColor(getApplication().getResources().getColor(R.color.colorAccent))
                    .setShowTitle(true);
           // CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            CustomTabsIntent  c= customTabsIntent.build();
            c.launchUrl(DetailActivity.this, Uri.parse(url));*/
            //如果不需要其他对点击链接事件的处理返回true，否则返回false
           // DetailActivity.this.startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse(url)));
            webView.loadUrl(url);
            return true;

        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
