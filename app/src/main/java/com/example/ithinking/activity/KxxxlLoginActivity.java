package com.example.ithinking.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ithinking.R;

public class KxxxlLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kxxxl_login);

        Button button = findViewById(R.id.bt_kxxxl_login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(KxxxlLoginActivity.this, "您已授权登录开心消消乐", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
