package com.example.ithinking.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.ithinking.R;

public class RatingBarActivity extends AppCompatActivity {

    private RatingBar mRatingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar);

        mRatingBar = findViewById(R.id.ratingbar);
        Button button = findViewById(R.id.rating_bt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float rating = mRatingBar.getRating();
                Toast.makeText(RatingBarActivity.this, "您得到了"+rating+"颗星", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
