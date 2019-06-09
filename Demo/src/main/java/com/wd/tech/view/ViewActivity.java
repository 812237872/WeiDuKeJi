package com.wd.tech.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

import com.hjm.bottomtabbar.BottomTabBar;
import com.wd.tech.R;
import com.wd.tech.fragment.CommunityFragment;
import com.wd.tech.fragment.InformationFragment;
import com.wd.tech.fragment.MessageFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewActivity extends AppCompatActivity {

    @BindView(R.id.view_tabBar_id)
    BottomTabBar tabBarId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        ButterKnife.bind(this);
        tabBarId.init(getSupportFragmentManager())
                .addTabItem("资讯",R.mipmap.common_tab_informatiion_s_hdpi,R.mipmap.common_tab_information_n_hdpi,InformationFragment.class)
                .addTabItem("消息",R.mipmap.common_tab_message_s_hdpi,R.mipmap.common_tab_message_n_hdpi,MessageFragment.class)
                .addTabItem("社区",R.mipmap.common_tab_community_s_hdpi,R.mipmap.common_tab_community_n_hdpi,CommunityFragment.class);
    }
}
