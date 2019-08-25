package com.example.ithinking.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ithinking.R;

public class HandlerActivity extends AppCompatActivity {

//    /**Android 消息处理机制*/
//    Handler handler = new Handler(){
//        @Override
//        public void handleMessage(@NonNull Message msg) {
//            super.handleMessage(msg);
//            if (msg.what == 0x123){
//                TextView textView = findViewById(R.id.tv_handler);
//                textView.setText("修改后文字");
//            }
//        }
//    };
    private ProgressBar timer;//申明水平进度条
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        timer = findViewById(R.id.handler_timer);//获取进度条组件
        //启动进度条
        handler.sendEmptyMessage(TIMER_MSG);

    }
    final int TIME = 60;//定义时间长度60秒
    private int mProgressStatus = 0;//定义完成的进度
    private final int TIMER_MSG = 0x001;//消息代码
    //创建Handler对象，实现1秒钟更新进度
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (TIME - mProgressStatus > 0) {
                mProgressStatus++;
                timer.setProgress(TIME - mProgressStatus);//更新进度
                handler.sendEmptyMessageDelayed(TIMER_MSG,1000);
            }else {
                Toast.makeText(HandlerActivity.this, "时间到，游戏结束！", Toast.LENGTH_SHORT).show();
            }
        }
    };

//    public void updateText(View view) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                handler.sendEmptyMessage(0x123);//消息代码区分消息 自定义
//            }
//        }).start();
//    }
}
