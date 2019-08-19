package com.example.ithinking.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ViewSwitcher;

import com.example.ithinking.R;

public class ImageSwitcherActivity extends AppCompatActivity {
    private int[] arrayPicture = new int[]{
            R.mipmap.img01,R.mipmap.img02,R.mipmap.img03,R.mipmap.img04,
            R.mipmap.img05,R.mipmap.img06,R.mipmap.img07,R.mipmap.img08,
            R.mipmap.img09,R.mipmap.img10,R.mipmap.img11,R.mipmap.img12,
    };
    private ImageSwitcher mImageSwitcher;
    private int index;//图片索引
    private float touchDownX;//手指按下的x坐标
    private float touchUpX;//手指抬起的x坐标


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_switcher);

        mImageSwitcher = findViewById(R.id.imageSwitcher);

        mImageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_out));
        mImageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));
        mImageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(ImageSwitcherActivity.this);
                imageView.setImageResource(arrayPicture[index]);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ImageSwitcher.LayoutParams.MATCH_PARENT,ImageSwitcher.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        });
        mImageSwitcher.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    touchDownX = motionEvent.getX();
                    return true;
                }
                if(motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    touchUpX = motionEvent.getX();
                    if(touchUpX - touchDownX > 100) {//从左向右滑动
                        index = index ==0?arrayPicture.length-1:index-1;
                        mImageSwitcher.setInAnimation(AnimationUtils.loadAnimation(ImageSwitcherActivity.this,R.anim.slide_in_left));
                        mImageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(ImageSwitcherActivity.this,R.anim.slide_out_right));
                        mImageSwitcher.setImageResource(arrayPicture[index]);
                    }else if(touchDownX - touchUpX > 100) {//从右向左滑动
                        index = index ==arrayPicture.length-1?0:index+1;
                        mImageSwitcher.setInAnimation(AnimationUtils.loadAnimation(ImageSwitcherActivity.this,R.anim.slide_in_right));
                        mImageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(ImageSwitcherActivity.this,R.anim.slide_out_left));
                        mImageSwitcher.setImageResource(arrayPicture[index]);

                    }
                    return true;
                }
                return false;
            }
        });
    }
}
