package com.ithink.writenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends Activity {

    static boolean isPlay = true;//记录音乐播放状态
    private MediaPlayer mediaPlayer;
    private Button btn_music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_music = findViewById(R.id.btn_music);
        playMusic();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mediaPlayer!=null) {
            stopMusic();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer!=null) {
            stopMusic();
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (isPlay){
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
        playMusic();
    }

    private void playMusic() {
        if (mediaPlayer==null)
            mediaPlayer = MediaPlayer.create(this,R.raw.main_music);
        mediaPlayer.setLooping(true);//循环播放
        mediaPlayer.start();
    }

    public void onPlay(View view) {
        startActivity(new Intent(MainActivity.this,SelectActivity.class));
    }

    public void onMusic(View view) {
        if (isPlay) {
            if (mediaPlayer !=null){
                mediaPlayer.stop();
                btn_music.setBackgroundResource(R.drawable.btn_music2);
                isPlay = false;
            }
        }else {
            playMusic();
            btn_music.setBackgroundResource(R.drawable.btn_music1);
            isPlay = true;
        }
    }

    private void stopMusic(){
        if (mediaPlayer!=null) {
            mediaPlayer.stop();
            try {
                mediaPlayer.prepare();//要么在stop后调用prepare
            } catch (IOException e) {
                e.printStackTrace();
                Log.e("stop Main music","停止播放主界面音乐异常");
            }
        }
    }

    public void onAbout(View view) {
        startActivity(new Intent(MainActivity.this,AboutActivity.class));
    }
}
