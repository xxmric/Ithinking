package com.example.ithinking.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.example.ithinking.R;

public class QQImageActivity extends AppCompatActivity {

    private ImageView[] images = new ImageView[12];
    private int[] imagePath = new int[]{
            R.mipmap.img01,R.mipmap.img02,R.mipmap.img03,R.mipmap.img04,
            R.mipmap.img05,R.mipmap.img06,R.mipmap.img07,R.mipmap.img08,
            R.mipmap.img09,R.mipmap.img10,R.mipmap.img11,R.mipmap.img12,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qqimage);

        GridLayout gridLayout = findViewById(R.id.gl_qq);
        for (int i = 0; i < imagePath.length; i++) {
            images[i] = new ImageView(this);
            images[i].setImageResource(imagePath[i]);
            images[i].setPadding(2,2,2,2);
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(116,68);
            images[i].setLayoutParams(params);
            gridLayout.addView(images[i]);
        }
    }
}
