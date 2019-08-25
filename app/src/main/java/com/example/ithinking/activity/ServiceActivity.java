package com.example.ithinking.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ithinking.R;
import com.example.ithinking.service.MusicService;

public class ServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        final Intent intent = new Intent(this,MusicService.class);

        ImageButton imageButton = findViewById(R.id.service_play);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //启动和停止MusicService
                if (!MusicService.isPlay) { //未启动
                    startService(intent);
                    ((ImageButton)view).setImageDrawable(getResources().getDrawable(R.drawable.service_play,null));
                } else {
                    stopService(intent);
                    ((ImageButton)view).setImageDrawable(getResources().getDrawable(R.drawable.service_stop,null));
                }
            }
        });
    }

    @Override
    protected void onStart() {//页面启动 默认播放音乐
        startService(new Intent(this,MusicService.class));
        super.onStart();
    }
}
