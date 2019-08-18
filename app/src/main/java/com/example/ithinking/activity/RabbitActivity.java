package com.example.ithinking.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import com.example.ithinking.R;
import com.example.ithinking.view.RabbitView;

public class RabbitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rabbit);

        FrameLayout frameLayout = findViewById(R.id.fl_rabbit);

        final RabbitView rabbitView = new RabbitView(this);
        //添加触屏监听器
        rabbitView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                rabbitView.bitmapX = motionEvent.getX();
                rabbitView.bitmapY = motionEvent.getY();
                rabbitView.invalidate();//重绘
                return true;
            }
        });

        //添加View
        frameLayout.addView(rabbitView);
    }
}
