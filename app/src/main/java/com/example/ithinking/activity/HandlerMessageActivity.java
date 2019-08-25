package com.example.ithinking.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ithinking.R;

public class HandlerMessageActivity extends AppCompatActivity {

    private ViewFlipper flipper;
    private int[] images = {R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,
            R.drawable.img5,R.drawable.img6,R.drawable.img7,R.drawable.img8,};
    private int FLAG_MSG = 0x001;//消息代码
    private Message message;//申明消息对象

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_message);
        /***通过ViewFlipper组件播放广告图片 start **/
        flipper = findViewById(R.id.message_vf);
        for (int i = 0; i < images.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(images[i]);
            flipper.addView(imageView);
        }
        //设置切换图片动画效果
        flipper.setInAnimation(AnimationUtils.loadAnimation(this,R.anim.slide_in_right));
        flipper.setOutAnimation(AnimationUtils.loadAnimation(this,R.anim.slide_out_left));
        /***通过ViewFlipper组件播放广告图片 end **/

        /******开启广告轮播**********/
        message = Message.obtain();//获取message对象
        message.what = FLAG_MSG;//设置消息代码
        handler.sendMessage(message);//发送消息
    }
    /******创建hander对象，实现3秒钟更新一次图片 *******************/
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == FLAG_MSG) {
                flipper.showPrevious();//切换到下一张图片
                message = handler.obtainMessage(FLAG_MSG);//获取Message
                handler.sendMessageDelayed(message,3000);//延迟3秒发送消息
            }
        }
    };
}
