package com.example.ithinking.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;

import com.example.ithinking.R;

public class TabViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_view);
        //初始化选项卡tabHost组件

        TabHost tabHost = findViewById(android.R.id.tabhost);
        tabHost.setup();
        //添加标签页
        LayoutInflater inflater = LayoutInflater.from(this);
        inflater.inflate(R.layout.activity_tab_item1,tabHost.getTabContentView());
        inflater.inflate(R.layout.activity_tab_item2,tabHost.getTabContentView());
        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("精选表情").setContent(R.id.tab_item_left));
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("精选表情").setContent(R.id.tab_item_right));

    }
}
