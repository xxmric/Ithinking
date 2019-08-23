package com.example.ithinking.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.ithinking.R;

import java.io.IOException;

public class PlayerAudioActivity extends AppCompatActivity {

    private boolean isPause = false;//是否为暂停状态
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_audio);

        final ImageButton play = findViewById(R.id.btn_play);
        ImageButton pause = findViewById(R.id.btn_pause);
        ImageButton stop = findViewById(R.id.btn_stop);

        mMediaPlayer = MediaPlayer.create(this,R.raw.bird);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mMediaPlayer.isPlaying() && !isPause) {//正在播放
                    mMediaPlayer.pause();//暂停播放
                    isPause = true;
                    ((ImageButton) view).setImageDrawable(getResources().getDrawable(R.drawable.audio_play,null));
                } else {
                    mMediaPlayer.start();
                    isPause = false;
                    ((ImageButton) view).setImageDrawable(getResources().getDrawable(R.drawable.audio_pause,null));
                }

            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMediaPlayer.pause();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMediaPlayer.stop();
                play.setImageDrawable(getResources().getDrawable(R.drawable.audio_play,null));
            }
        });

        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                //重新播放音频
                mMediaPlayer.reset();
                play.setImageDrawable(getResources().getDrawable(R.drawable.audio_play,null));
                try {
                    mMediaPlayer.setDataSource(PlayerAudioActivity.this, imageTranslateUri(R.raw.bird));
                    mMediaPlayer.prepare();
//                    mMediaPlayer.start();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        if (mMediaPlayer.isPlaying()) {
            mMediaPlayer.stop();
        }
        mMediaPlayer.release();//释放资源
        super.onDestroy();
    }

    /**
     * res/drawable(mipmap)/xxx.png::::uri－－－－>url
     *
     * @return
     */
    private Uri imageTranslateUri(int resId) {

        Resources r = getResources();
        Uri uri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                + r.getResourcePackageName(resId) + "/"
                + r.getResourceTypeName(resId) + "/"
                + r.getResourceEntryName(resId));

        return uri;
    }
}
