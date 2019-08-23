package com.example.ithinking.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.example.ithinking.R;

public class NotificationActivity extends AppCompatActivity {

    private final int NOTIFICATION_ID = 0x123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        //创建并发送通知
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder;
        //判断是否是8.0Android.O
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel chan1 = new NotificationChannel("static", "Primary Channel", NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(chan1);
            builder = new NotificationCompat.Builder(NotificationActivity.this, "static");
        } else {
            builder = new NotificationCompat.Builder(this);
        }

        builder.setAutoCancel(true);//设置通知打开后，自动消失
        builder.setSmallIcon(R.drawable.notification_packet);//设置通知图标
        builder.setContentTitle("奖励百万红包！！！");
        builder.setContentText("点击查看详情！");//设置通知内容
        builder.setWhen(System.currentTimeMillis());//设置发送时间
        builder.setDefaults(Notification.DEFAULT_SOUND |Notification.DEFAULT_VIBRATE);//设置默认声音和震动

        //创建一个启动详情页面的Intent
        Intent intent = new Intent(NotificationActivity.this,NotificationDetailActivity.class);
        PendingIntent pi = PendingIntent.getActivity(NotificationActivity.this,0,intent,0);
        builder.setContentIntent(pi);

        notificationManager.notify(NOTIFICATION_ID,builder.build());//发送通知


    }
}
