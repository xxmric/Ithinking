package com.example.ithinking.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.ithinking.R;

public class ArrayResourceActivity extends AppCompatActivity {

    int[] tvid = {
            R.id.textView1,
            R.id.textView2,
            R.id.textView3,
            R.id.textView4,
            R.id.textView5,
            R.id.textView6,
            R.id.textView7,
            R.id.textView8,
            R.id.textView9
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_resource);

        //获取文本和背景颜色数组
        int[] colors = getResources().getIntArray(R.array.bacolor);
        String[] words = getResources().getStringArray(R.array.word);

        for (int i = 0; i < tvid.length; i++) {
            TextView textView = findViewById(tvid[i]);
            textView.setBackgroundColor(colors[i]);
            textView.setText(words[i]);
        }
    }
}
