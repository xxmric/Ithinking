package com.example.ithinking.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.ithinking.R;

import java.util.HashMap;

public class SoundPoolActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_pool);
        ListView listView = findViewById(R.id.soundpool_listView);
        /***********创建SoundPool对象，并设置音频相关属性******/
        AudioAttributes attributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_MEDIA)//设置音效场景
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)//设置音效类型
                .build();
        final SoundPool soundPool = new SoundPool.Builder()
                .setAudioAttributes(attributes)//设置音效池属性
                .setMaxStreams(10)//设置最多可容纳10个音频流
                .build();
        /****将要播放的音频保存到HashMap对象中*****/
        final HashMap<Integer,Integer> soundmap = new HashMap<>();
        soundmap.put(0,soundPool.load(this,R.raw.cuckoo,1));
        soundmap.put(1,soundPool.load(this,R.raw.chimes,1));
        soundmap.put(2,soundPool.load(this,R.raw.notify,1));
        soundmap.put(3,soundPool.load(this,R.raw.ringout,1));
        soundmap.put(4,soundPool.load(this,R.raw.bird,1));
        soundmap.put(5,soundPool.load(this,R.raw.water,1));
        soundmap.put(6,soundPool.load(this,R.raw.cock,1));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int postion, long l) {
                if(postion<7) {
                    soundPool.play(soundmap.get(postion),1,1,0,0,1);
                }else {
                    soundPool.play(soundmap.get(0),1,1,0,0,1);
                }

            }
        });
    }
}
