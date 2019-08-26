package com.example.ithinking.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ithinking.R;
import com.example.ithinking.service.BinderService;

import java.util.List;

public class BoundServiceActivity extends AppCompatActivity {

    private int[] tvid = {R.id.boundService_textView1,
            R.id.boundService_textView2,
            R.id.boundService_textView3,
            R.id.boundService_textView4,
            R.id.boundService_textView5,
            R.id.boundService_textView6,
            R.id.boundService_textView7,};

    private BinderService binderService;//自定义BinderService
    //创建ServiceConnection对象
    private ServiceConnection conn = new ServiceConnection() {

        //当serivce与和绑定它的组件连接时 回调的方法
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            binderService = ((BinderService.MyBinder)iBinder).getService();
        }

        //当serivce与和绑定它的组件断开连接时 回调的方法
        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound_service);

        Button button = findViewById(R.id.boundService_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> number = binderService.getRandomNumber();
                for (int i = 0; i < number.size(); i++) {
                    TextView textView = findViewById(tvid[i]);
                    textView.setText(number.get(i));
                }
            }
        });
    }

    //绑定自定义BinderService
    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this,BinderService.class);
        bindService(intent,conn,BIND_AUTO_CREATE);//0不自动创建
    }
    //绑定自定义BinderService
    @Override
    protected void onStop() {
        super.onStop();
        unbindService(conn);//解除绑定
    }
}
