package com.example.ithinking.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ithinking.R;

public class BroadcastReceiverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver);
    }

    public void sendBroadcastReceiver(View view) {
        //发送一条广播
        Intent intent = new Intent();
        intent.setAction("zuckerberg");//为Intent添加动作
        sendBroadcast(intent);
    }
}
