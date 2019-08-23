package com.example.ithinking.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.ithinking.R;

import java.io.File;

public class VideoViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);
        /***设置播放视频源***///sdcard
        VideoView videoView = findViewById(R.id.vv_videoView);
        File file = new File(Environment.getExternalStorageDirectory().getPath()+"/DCIM/Camera/2019-08-04-191449262.mp4");
        if (file.exists()) {
            videoView.setVideoPath(file.getAbsolutePath());
        } else {
            Toast.makeText(this, "要播放的视频文件不存在！", Toast.LENGTH_SHORT).show();
        }

        /***控制视频的播放**/
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);//让videoView 与MediaController关联
        videoView.requestFocus();//让VideoView获得焦点
        videoView.start();//开始播放
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                Toast.makeText(VideoViewActivity.this, "视频播放完毕！", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
