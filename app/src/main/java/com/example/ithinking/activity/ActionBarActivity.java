package com.example.ithinking.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import com.example.ithinking.R;

public class ActionBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar);
        //隐藏actionBar上的显示标题的
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //判断父Activity是否为空
        if (NavUtils.getParentActivityName(ActionBarActivity.this) !=null ) {
            //显示向左返回箭头
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            //还需要在AndroidManifest.xml中配置
//            <meta-data
//            android:name="android.support.PARENT_ACTIVITY"
//            android:value=".MainActivity"></meta-data>
        }
    }

    //解析菜单资源文件
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();//实例化
        menuInflater.inflate(R.menu.actionbar_menu,menu);//指定菜单资源路径
        return super.onCreateOptionsMenu(menu);
    }
}
