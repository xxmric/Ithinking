package com.example.ithinking.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.ithinking.R;
import com.example.ithinking.view.HatView;

public class TouchEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_event);

        //第二步：创建并实例化帽子类的一个对象，并为帽子添加触摸事件监听器
        final HatView hatView = new HatView(this);
        hatView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                hatView.setBitmapX(motionEvent.getX()-200);
                hatView.setBitmapY(motionEvent.getY()-300);
                hatView.invalidate();//进行绘制
                return true;//返回true
            }
        });
        //第三步：添加到布局管理器中
        RelativeLayout relativeLayout = findViewById(R.id.rl_touchevent);
        relativeLayout.addView(hatView);
    }
}
