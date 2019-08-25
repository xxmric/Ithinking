package com.example.ithinking.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.example.ithinking.R;

public class MusicService extends Service {

    public static boolean isPlay;//记录当前播放状态
    private MediaPlayer player;//播放音乐的

    public MusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        //创建MediaPlayer对象，并加载播放音乐
        player = MediaPlayer.create(this, R.raw.kxxxl_music);
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (!player.isPlaying()) {
            //播放音乐
            player.start();
            isPlay = player.isPlaying();//设置当前播放音乐状态
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        //停止播放音乐
        player.stop();
        isPlay = player.isPlaying();//设置当前播放音乐状态
        player.release();//释放资源
        super.onDestroy();
    }

}
