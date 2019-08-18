package com.example.ithinking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.ithinking.activity.ChronometerActivity;
import com.example.ithinking.activity.DateAndTimeActivity;
import com.example.ithinking.activity.FeijidazhanActivity;
import com.example.ithinking.activity.FrameLayoutActivity;
import com.example.ithinking.activity.KxxxlLoginActivity;
import com.example.ithinking.activity.KxxxlStartActivity;
import com.example.ithinking.activity.ProgressBarActivity;
import com.example.ithinking.activity.QQImageActivity;
import com.example.ithinking.activity.QQMessagesActivity;
import com.example.ithinking.activity.QQSpeakActivity;
import com.example.ithinking.activity.QuestionActivity;
import com.example.ithinking.activity.RabbitActivity;
import com.example.ithinking.activity.SoftwareUpdateActivity;
import com.example.ithinking.activity.WeixinFriendActivity;
import com.example.ithinking.activity.WeixinLoginActivity;
import com.example.ithinking.activity.XmlyLoginActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * 显示QQ相册
     * @param view
     */
    public void showQQImage(View view) {
        Intent intent = new Intent(this, QQImageActivity.class);
        startActivity(intent);
    }
    /**
     * 跟随手指的小兔子
     * @param view
     */
    public void rabbit(View view) {
        Intent intent = new Intent(this, RabbitActivity.class);
        startActivity(intent);
    }

    /**
     * 软件更新
     * @param view
     */
    public void softwareUpdate(View view) {
        Intent intent = new Intent(this, SoftwareUpdateActivity.class);
        startActivity(intent);
    }

    /**
     * 微信登录页
     * @param view
     */
    public void weixinLogin(View view) {
        Intent intent = new Intent(this, WeixinLoginActivity.class);
        startActivity(intent);
    }

    /**
     * 帧布局管理器
     * @param view
     */
    public void frameLayout(View view) {
        Intent intent = new Intent(this, FrameLayoutActivity.class);
        startActivity(intent);
    }

    /**
     * 表格布局管理器实现喜马拉雅登录页
     * @param view
     */
    public void xmlyLogin(View view) {
        Intent intent = new Intent(this, XmlyLoginActivity.class);
        startActivity(intent);
    }

    /**
     * 网格布局管理器实现QQ消息列表
     * @param view
     */
    public void qqMessage(View view) {
        Intent intent = new Intent(this, QQMessagesActivity.class);
        startActivity(intent);
    }

    /**
     * 微信朋友圈
     * @param view
     */
    public void weixinFriend(View view) {
        Intent intent = new Intent(this, WeixinFriendActivity.class);
        startActivity(intent);
    }

    /**
     * 发布QQ空间
     * @param view
     */
    public void qqSpeak(View view) {
        Intent intent = new Intent(this, QQSpeakActivity.class);
        startActivity(intent);
    }

    /**
     * 授权开心消消乐登录界面
     * @param view
     */
    public void kxxxlLogin(View view) {
        Intent intent = new Intent(this, KxxxlLoginActivity.class);
        startActivity(intent);
    }

    /**
     * 开心消消乐开始页面
     * @param view
     */
    public void kxxxlStart(View view) {
        Intent intent = new Intent(this, KxxxlStartActivity.class);
        startActivity(intent);
    }

    /**
     * 逻辑推理题
     * @param view
     */
    public void question(View view) {
        Intent intent = new Intent(this, QuestionActivity.class);
        startActivity(intent);
    }

    /**
     * 飞机大战授权界面
     * @param view
     */
    public void feijidazhan(View view) {
        Intent intent = new Intent(this, FeijidazhanActivity.class);
        startActivity(intent);
    }

    /**
     * 日期与时间选择器
     * @param view
     */
    public void dateAndTime(View view) {
        Intent intent = new Intent(this, DateAndTimeActivity.class);
        startActivity(intent);
    }

    /**
     * 计时器
     * @param view
     */
    public void chronometer(View view) {
        Intent intent = new Intent(this, ChronometerActivity.class);
        startActivity(intent);
    }

    /**
     * 进度条
     * @param view
     */
    public void progressBar(View view) {
        Intent intent = new Intent(this, ProgressBarActivity.class);
        startActivity(intent);
    }
}
