package com.example.ithinking.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.ithinking.R;
import com.example.ithinking.fragment.Fragment1;
import com.example.ithinking.fragment.Fragment2;
import com.example.ithinking.fragment.Fragment3;
import com.example.ithinking.fragment.Fragment4;
import com.example.ithinking.fragment.Fragment5;
import com.example.ithinking.listener.ActionBarTabListener;

public class ActionBarAndTabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_and_tab);

        //设置actionBar 为选项卡模式 并将标签页添加到Action bar中
        ActionBar actionBar = getSupportActionBar();
        //设置actionbar为选项卡模式
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayOptions(0,ActionBar.DISPLAY_SHOW_TITLE);//隐藏标题栏

        //把各个标签页添加到Action bar中
        actionBar.addTab(actionBar.newTab().setText("词典").setTabListener(new ActionBarTabListener(this, Fragment1.class)));
        actionBar.addTab(actionBar.newTab().setText("百科").setTabListener(new ActionBarTabListener(this, Fragment2.class)));
        actionBar.addTab(actionBar.newTab().setText("翻译").setTabListener(new ActionBarTabListener(this, Fragment3.class)));
        actionBar.addTab(actionBar.newTab().setText("发现").setTabListener(new ActionBarTabListener(this, Fragment4.class)));
        actionBar.addTab(actionBar.newTab().setText("我的").setTabListener(new ActionBarTabListener(this, Fragment5.class)));
    }
}
