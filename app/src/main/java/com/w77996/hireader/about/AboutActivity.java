package com.w77996.hireader.about;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
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
                .setName("Your Full Name")
                .setSubTitle("Mobile Develop")
                .setBrief("I'm warmed of mobile technologies. Ideas maker, curious and nature lover.")
                .setAppIcon(R.mipmap.ic_launcher)
                .setAppName(R.string.app_name)
                .setLinksColumnsCount(4)
                .addGooglePlayStoreLink("8002078663318221363")
                .addGitHubLink("w77996")
                .addFacebookLink("user")
                .addAndroidLink("user")
                .addEmailLink("1047239335@qq.com")
                .addIntroduceAction(intent)
                .addFiveStarsAction()
                .setVersionNameAsAppSubTitle()
                .addShareAction(R.string.app_name)
                .addMoreFromMeAction("user")
                .addHelpAction(intent)
                .addDonateAction(intent)
                .addChangeLogAction(intent)
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
}
