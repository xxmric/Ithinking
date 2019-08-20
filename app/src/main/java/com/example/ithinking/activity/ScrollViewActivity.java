package com.example.ithinking.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.ithinking.R;

public class ScrollViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);

        LinearLayout linearLayout = findViewById(R.id.linearLayout);

        LinearLayout linearLayout1 = new LinearLayout(this);
        linearLayout1.setOrientation(LinearLayout.VERTICAL);

        ScrollView scrollView = new ScrollView(this);
        linearLayout.addView(scrollView);
        scrollView.addView(linearLayout1);

        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.mipmap.scrollview_cidian);
        linearLayout1.addView(imageView);

        TextView textView = new TextView(this);
        textView.setText(R.string.cidian);
        linearLayout1.addView(textView);
    }
}
