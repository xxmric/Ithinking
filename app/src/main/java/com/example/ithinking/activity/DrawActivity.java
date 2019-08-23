package com.example.ithinking.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.ithinking.R;
import com.example.ithinking.view.DrawView;

public class DrawActivity extends AppCompatActivity {

    private boolean flag = true;//记录播放状态
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);

        FrameLayout frameLayout = findViewById(R.id.fl_draw);
        frameLayout.addView(new DrawView(this));//将自定义View添加到帧布局管理器

        final AnimationDrawable animationDrawable = (AnimationDrawable) frameLayout.getBackground();
        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag) {
                    animationDrawable.start();
                    flag = false;
                }else {
                    animationDrawable.stop();
                    flag = true;
                }
            }
        });
        final ImageView imageView = findViewById(R.id.iv_alpha);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation alpha = AnimationUtils.loadAnimation(DrawActivity.this,R.anim.alpha);

                imageView.startAnimation(alpha);
                Animation rotate = AnimationUtils.loadAnimation(DrawActivity.this,R.anim.rotate);
                imageView.startAnimation(rotate);
                Animation scale = AnimationUtils.loadAnimation(DrawActivity.this,R.anim.scale);
                imageView.startAnimation(scale);
                Animation translate = AnimationUtils.loadAnimation(DrawActivity.this,R.anim.translate);
                imageView.startAnimation(translate);
            }
        });
    }
}
