package com.example.ithinking;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.example.ithinking.activity.ActionBarActivity;
import com.example.ithinking.activity.ActionBarAndTabActivity;
import com.example.ithinking.activity.AlarmManagerActivity;
import com.example.ithinking.activity.AlertDialogActivity;
import com.example.ithinking.activity.ArrayResourceActivity;
import com.example.ithinking.activity.BroadcastReceiverActivity;
import com.example.ithinking.activity.CameraActivity;
import com.example.ithinking.activity.ChronometerActivity;
import com.example.ithinking.activity.CreateEventActivity;
import com.example.ithinking.activity.DateAndTimeActivity;
import com.example.ithinking.activity.DrawActivity;
import com.example.ithinking.activity.ExitMapActivity;
import com.example.ithinking.activity.FeijidazhanActivity;
import com.example.ithinking.activity.FragmentExampleActivity;
import com.example.ithinking.activity.FrameLayoutActivity;
import com.example.ithinking.activity.GridViewActivity;
import com.example.ithinking.activity.ImageSwitcherActivity;
import com.example.ithinking.activity.ImageViewActivity;
import com.example.ithinking.activity.IntentActivity;
import com.example.ithinking.activity.KxxxlLoginActivity;
import com.example.ithinking.activity.KxxxlStartActivity;
import com.example.ithinking.activity.ListViewActivity;
import com.example.ithinking.activity.MyEventActivity;
import com.example.ithinking.activity.MyMenuActivity;
import com.example.ithinking.activity.MyThemeActivity;
import com.example.ithinking.activity.NotificationActivity;
import com.example.ithinking.activity.PlayerAudioActivity;
import com.example.ithinking.activity.ProgressBarActivity;
import com.example.ithinking.activity.QQImageActivity;
import com.example.ithinking.activity.QQMessagesActivity;
import com.example.ithinking.activity.QQSpeakActivity;
import com.example.ithinking.activity.QuestionActivity;
import com.example.ithinking.activity.RabbitActivity;
import com.example.ithinking.activity.RatingBarActivity;
import com.example.ithinking.activity.ScrollViewActivity;
import com.example.ithinking.activity.SeekBarActivity;
import com.example.ithinking.activity.SelectIcoActivity;
import com.example.ithinking.activity.SoftwareUpdateActivity;
import com.example.ithinking.activity.SoundPoolActivity;
import com.example.ithinking.activity.SpinnerActivity;
import com.example.ithinking.activity.StateListDrawableActivity;
import com.example.ithinking.activity.StringResourceActivity;
import com.example.ithinking.activity.TabViewActivity;
import com.example.ithinking.activity.TaoBaoAddressActivity;
import com.example.ithinking.activity.TouchEventActivity;
import com.example.ithinking.activity.VideoViewActivity;
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

    /**
     * 拖动条
     * @param view
     */
    public void seekBar(View view) {
        Intent intent = new Intent(this, SeekBarActivity.class);
        startActivity(intent);
    }

    /**
     * 星级评分条
     * @param view
     */
    public void ratingBar(View view) {
        Intent intent = new Intent(this, RatingBarActivity.class);
        startActivity(intent);
    }

    /**
     * 图像视图
     * @param view
     */
    public void imageView(View view) {
        Intent intent = new Intent(this, ImageViewActivity.class);
        startActivity(intent);
    }

    /**
     * 图像切换器
     * @param view
     */
    public void imageSwitcher(View view) {
        Intent intent = new Intent(this, ImageSwitcherActivity.class);
        startActivity(intent);
    }

    /**
     * 网格视图
     * @param view
     */
    public void gridView(View view) {
        Intent intent = new Intent(this, GridViewActivity.class);
        startActivity(intent);
    }

    /**
     * 下拉列表框
     * @param view
     */
    public void spinner(View view) {
        Intent intent = new Intent(this, SpinnerActivity.class);
        startActivity(intent);
    }

    /**
     * 列表视图
     * @param view
     */
    public void listView(View view) {
        Intent intent = new Intent(this, ListViewActivity.class);
        startActivity(intent);
    }

    /**
     * 滚动视图
     * @param view
     */
    public void scrollView(View view) {
        Intent intent = new Intent(this, ScrollViewActivity.class);
        startActivity(intent);
    }

    /**
     * 选项卡
     * @param view
     */
    public void tab(View view) {
        Intent intent = new Intent(this, TabViewActivity.class);
        startActivity(intent);
    }

    /**
     * 管理淘宝收货地址实现activity直接交换数据
     * @param view
     */
    public void tabbaoAddress(View view) {
        Intent intent = new Intent(this, TaoBaoAddressActivity.class);
        startActivity(intent);
    }

    /**
     * 选择图像并保存 调用activity并返回数据
     * @param view
     */
    public void selectIco(View view) {
        Intent intent = new Intent(this, SelectIcoActivity.class);
        startActivity(intent);
    }

    /**
     * Fragment
     * @param view
     */
    public void fragment(View view) {
        Intent intent = new Intent(this, FragmentExampleActivity.class);
        startActivity(intent);
    }

    /**
     * Intent
     * @param view
     */
    public void intent(View view) {
        Intent intent = new Intent(this, IntentActivity.class);
        intent.setFlags(intent.FLAG_ACTIVITY_NO_HISTORY);//当前activity不在历史栈中保留
        startActivity(intent);
    }

    /**
     * 监听返回、长按事件
     * @param view
     */
    public void exitMap(View view) {
        Intent intent = new Intent(this, ExitMapActivity.class);
        startActivity(intent);
    }

    /**
     * 触摸事件
     * @param view
     */
    public void touchEvent(View view) {
        Intent intent = new Intent(this, TouchEventActivity.class);
        startActivity(intent);
    }

    /**
     * 自定义手势浏览相册中的图片
     * @param view
     */
    public void myEvent(View view) {
        Intent intent = new Intent(this, MyEventActivity.class);
        startActivity(intent);
    }

    /**
     * 创建自定义手势
     * @param view
     */
    public void createEvent(View view) {
        Intent intent = new Intent(this, CreateEventActivity.class);
        startActivity(intent);
    }

    /**
     * 字符串/尺寸/颜色资源
     * @param view
     */
    public void stringResource(View view) {
        Intent intent = new Intent(this, StringResourceActivity.class);
        startActivity(intent);
    }

    /**
     * 数组资源
     * @param view
     */
    public void arrayResource(View view) {
        Intent intent = new Intent(this, ArrayResourceActivity.class);
        startActivity(intent);
    }

    /**
     * 状态列表资源
     * @param view
     */
    public void stateListDrawable(View view) {
        Intent intent = new Intent(this, StateListDrawableActivity.class);
        startActivity(intent);
    }

    /**
     * 自定义主题资源样式
     * @param view
     */
    public void todaynews(View view) {
        Intent intent = new Intent(this, MyThemeActivity.class);
        startActivity(intent);
    }

    /**
     * 定义选项菜单
     * @param view
     */
    public void myMenu(View view) {
        Intent intent = new Intent(this, MyMenuActivity.class);
        startActivity(intent);
    }

    /**
     * actionBar添加item
     * @param view
     */
    public void actionBar(View view) {
        Intent intent = new Intent(this, ActionBarActivity.class);
        startActivity(intent);
    }

    /**
     * actionBar与tab
     * @param view
     */
    public void actionBarAndTab(View view) {
        Intent intent = new Intent(this, ActionBarAndTabActivity.class);
        startActivity(intent);
    }

    /**
     * 对话框
     * @param view
     */
    public void alertDialog(View view) {
        Intent intent = new Intent(this, AlertDialogActivity.class);
        startActivity(intent);
    }

    /**
     * Notification在状态栏显示通知
     * @param view
     */
    public void notification(View view) {
        Intent intent = new Intent(this, NotificationActivity.class);
        startActivity(intent);
    }

    /**
     * BroadcastReceiver
     * @param view
     */
    public void broadcastReceiver(View view) {
        Intent intent = new Intent(this, BroadcastReceiverActivity.class);
        startActivity(intent);
    }

    /**
     * AlarmManager设置闹钟
     * @param view
     */
    public void alarmManager(View view) {
        Intent intent = new Intent(this, AlarmManagerActivity.class);
        startActivity(intent);
    }

    /**
     * 画笔和画布
     * @param view
     */
    public void draw(View view) {
        Intent intent = new Intent(this, DrawActivity.class);
        startActivity(intent);
    }

    /**
     * 使用MediaPlayer播放音频文件
     * @param view
     */
    public void playerAudio(View view) {
        Intent intent = new Intent(this, PlayerAudioActivity.class);
        startActivity(intent);
    }

    /**
     * 使用SoundPool播放音频文件
     * @param view
     */
    public void soundPool(View view) {
        Intent intent = new Intent(this, SoundPoolActivity.class);
        startActivity(intent);
    }

    /**
     * 使用VideoView组件播放视频
     * @param view
     */
    public void videoView(View view) {
        Intent intent = new Intent(this, VideoViewActivity.class);
        startActivity(intent);
    }

    /***
     * 调用摄像头拍照
     * @param view
     */
    public void camera(View view) {
        Intent intent = new Intent(this, CameraActivity.class);
        startActivity(intent);
    }
}
