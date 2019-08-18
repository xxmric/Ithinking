package com.example.ithinking.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.ithinking.R;

public class KxxxlStartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        //全屏显示 去掉上面的任务栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_kxxxl_start);

        ImageButton imageButton = findViewById(R.id.ib_kxxxl_start);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(KxxxlStartActivity.this, "您单击了开始游戏按钮", Toast.LENGTH_SHORT).show();
            }
        });
        ImageButton switchIB = findViewById(R.id.ib_kxxxl_switch);
        switchIB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(KxxxlStartActivity.this, "您单击了切换账号按钮", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
