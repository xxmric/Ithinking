package com.example.ithinking.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.ithinking.R;

import java.util.Calendar;

public class AlarmManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_manager);

        //获取事件拾取组件
        final TimePicker timePicker = findViewById(R.id.tp_time);
        timePicker.setIs24HourView(true);//设置24小时制
        Button button = findViewById(R.id.bt_set);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //设置闹钟
                Intent intent = new Intent(AlarmManagerActivity.this,AlarmActivity.class);
                //定义一个Pending 获取显示闹钟的PendingIntent
                PendingIntent pendingIntent = PendingIntent.getActivity(AlarmManagerActivity.this,0,intent,0);
                AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);//获取AlarmManager管理器
                Calendar calendar = Calendar.getInstance();//获取日历对象
                calendar.set(Calendar.HOUR,timePicker.getCurrentHour());//设置闹钟小时数
                calendar.set(Calendar.MINUTE,timePicker.getCurrentMinute());//设置闹钟的分钟数
                calendar.set(Calendar.SECOND,0);//设置闹钟的秒数
                alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);//设置指定时间并唤醒系统 显示的页面
                Toast.makeText(AlarmManagerActivity.this, "闹钟设置成功！", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
