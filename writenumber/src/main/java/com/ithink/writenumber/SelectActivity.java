package com.ithink.writenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;

public class SelectActivity extends Activity {

    private MediaPlayer mMediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        if (MainActivity.isPlay) {//判断游戏主界面是否播放音乐
            playMusic();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopMusic();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopMusic();
        mMediaPlayer.release();
        mMediaPlayer = null;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (MainActivity.isPlay) {
            playMusic();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopMusic();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (MainActivity.isPlay) {
            playMusic();
        }
    }

    /**
     * 播放选择数字界面背景音乐
     */
    private void playMusic() {
        if (mMediaPlayer==null)
            mMediaPlayer = MediaPlayer.create(this,R.raw.number_music);
        mMediaPlayer.setLooping(true);
        mMediaPlayer.start();
    }

    /**
     * 停止选择数字界面背景音乐
     */
    private void stopMusic(){
        if (mMediaPlayer !=null) {
            mMediaPlayer.stop();
            try {
                mMediaPlayer.prepare();//要么在stop后调用prepare
            } catch (IOException e) {
                e.printStackTrace();
                Log.e("stop Number music","停止播放数字音乐异常");
            }
        }
    }

    /**
     * 跳转到数字1的书写页面
     * @param view
     */
    public void onOne(View view){
        startActivity(new Intent(SelectActivity.this,OneActivity.class));
    }
    public void onTwo(View v){   //单击事件  进入数字2书写界面
        //当前界面跳转至数字2书写界面
        startActivity(new Intent(SelectActivity.this, TwoActivity.class));
    }
    public void onThree(View v){   //单击事件  进入数字3书写界面
        //当前界面跳转至数字3书写界面
        startActivity(new Intent(SelectActivity.this, ThreeActivity.class));
    }
    public void onFour(View v){   //单击事件  进入数字4书写界面
        //当前界面跳转至数字4书写界面
        startActivity(new Intent(SelectActivity.this, FourActivity.class));
    }
    public void onFive(View v){   //单击事件  进入数字5书写界面
        //当前界面跳转至数字5书写界面
        startActivity(new Intent(SelectActivity.this, FiveActivity.class));
    }
    public void onSix(View v){   //单击事件  进入数字6书写界面
        //当前界面跳转至数字6书写界面
        startActivity(new Intent(SelectActivity.this, SixActivity.class));
    }
    public void onSeven(View v){   //单击事件  进入数字7书写界面
        //当前界面跳转至数字7书写界面
        startActivity(new Intent(SelectActivity.this, SevenActivity.class));
    }
    public void onEight(View v){   //单击事件  进入数字8书写界面
        //当前界面跳转至数字8书写界面
        startActivity(new Intent(SelectActivity.this, EightActivity.class));
    }
    public void onNine(View v){   //单击事件  进入数字9书写界面
        //当前界面跳转至数字9书写界面
        startActivity(new Intent(SelectActivity.this, NineActivity.class));
    }
    public void onZero(View v){   //单击事件  进入数字8书写界面
        //当前界面跳转至数字8书写界面
        startActivity(new Intent(SelectActivity.this, ZeroActivity.class));
    }
}
