package com.example.ithinking.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.ithinking.R;

/**
 * 第一步：实现GestureDetector.OnGestureListener接口
 */
public class MyEventActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {

    //动画资源
    private Animation[] mAnimations = new Animation[4];
    //手势动作两点之间最小距离
    private int distance = 50;
    //图片资源
    private int[] images = new int[]{
            R.mipmap.img01,R.mipmap.img02,R.mipmap.img03,R.mipmap.img04,
            R.mipmap.img05,R.mipmap.img06,R.mipmap.img07,R.mipmap.img08,
            R.mipmap.img09,R.mipmap.img10,R.mipmap.img11,R.mipmap.img12,
    };
    //定义一个手势检测器
    private GestureDetector mGestureDetector;
    private ViewFlipper mViewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_event);

        //第二步：实例化一个全局的手势检测器
        mGestureDetector = new GestureDetector(MyEventActivity.this,this);
        //第三步：将图片加载到ViewFlipper中，并且初始化动画数组
        mViewFlipper = findViewById(R.id.vf_flipper);
        for (int i = 0; i < images.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(images[i]);
            mViewFlipper.addView(imageView);
        }
        //初始化动画资源
        mAnimations[0] = AnimationUtils.loadAnimation(this,R.anim.slide_in_left);
        mAnimations[1] = AnimationUtils.loadAnimation(this,R.anim.slide_out_left);
        mAnimations[2] = AnimationUtils.loadAnimation(this,R.anim.slide_in_right);
        mAnimations[3] = AnimationUtils.loadAnimation(this,R.anim.slide_out_right);
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        //第四步：通过触摸事件的X坐标判断是向左滑还是向右滑，并为设置动画效果
        //从右向左滑
        if (motionEvent.getX() - motionEvent1.getX() > distance) {
            mViewFlipper.setInAnimation(mAnimations[2]);
            mViewFlipper.setOutAnimation(mAnimations[1]);
            mViewFlipper.showPrevious();
            return true;
        } else if (motionEvent1.getX() - motionEvent.getX() > distance) {//从左向右滑动
            mViewFlipper.setInAnimation(mAnimations[0]);
            mViewFlipper.setOutAnimation(mAnimations[3]);
            mViewFlipper.showNext();
            return true;
        }
        return false;
    }
    //第五步：将Activity上的触摸事件交给GestureDetector处理

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        return super.onTouchEvent(event);
        return mGestureDetector.onTouchEvent(event);
    }
}
