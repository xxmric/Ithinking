package com.example.ithinking.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ithinking.R;

public class ProgressBarActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private int mProgress = 0;
    private Handler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        progressBar = findViewById(R.id.progressBar);
        mHandler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                if(msg.what == 0x111) {
                    progressBar.setProgress(mProgress);
                }else {
                    Toast.makeText(ProgressBarActivity.this, "耗时操作已完成", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);//设置进度条不显示
                }
            }
        };
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    mProgress = doWork();
                    Message message = new Message();
                    if(mProgress < 100) {
                        message.what = 0x111;//消息代码 未完成
                        mHandler.sendMessage(message);
                    }else {
                        message.what = 0x110;//已完成标识 可任意定义
                        break;
                    }
                }
            }
            private int doWork() {
                mProgress += Math.random()*10;
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return mProgress;
            }
        }).start();
    }

}
