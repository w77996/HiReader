package com.w77996.hireader.about;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.vansuita.materialabout.builder.AboutBuilder;
import com.vansuita.materialabout.builder.Item;
import com.vansuita.materialabout.views.AboutView;
import com.w77996.hireader.R;

import java.util.List;

/**
 * Created by Administrator on 2017/3/17.
 */
public class AboutActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    /*    mToolbar = (Toolbar)findViewById(R.id.about_toolbar);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        //mToolbar.setTitle("设置");
        actionBar.setTitle("关于");
        if (actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);*/
        LinearLayout layoutParams = (LinearLayout)findViewById(R.id.aboutView);
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        Intent intent = new Intent();
        AboutView view = AboutBuilder.with(this)
                .setBackgroundColor(R.color.mdtp_background_color)
                .setPhoto(R.mipmap.profile_picture)
                .setCover(R.mipmap.profile_cover)
                .setName("w77996")
                .setSubTitle("Android Develop")
                .setBrief("I'm warmed of mobile technologies. Ideas maker, curious and nature lover.")
                .setAppIcon(R.mipmap.ic_launcher)
                .setAppName(R.string.app_name)
                .setLinksColumnsCount(2)
                .addGitHubLink("w77996")
                .addEmailLink("1047239335@qq.com")
                .addIntroduceAction(intent)
                .addFiveStarsAction()
                .setVersionNameAsAppSubTitle()
                .addShareAction(R.string.app_name)
                .addMoreFromMeAction("user")
                .addDonateAction(intent)
                .addUpdateAction()
                .setWrapScrollView(true)
                .setLinksAnimated(true)
                .setShowAsCard(true)
                .build();

        addContentView(view, p);

        AboutBuilder aboutBuilder = AboutBuilder.with(this);

        List<Item> actions = aboutBuilder.getActions();
        List<Item> links = aboutBuilder.getActions();


       /* View lastLinkView = view.findItem(builder.getLastLink());
        View lastActionView = view.findItem(builder.getLastAction());*/
    }
   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }*/
}
