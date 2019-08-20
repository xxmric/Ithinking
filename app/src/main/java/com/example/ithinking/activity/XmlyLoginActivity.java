package com.example.ithinking.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ithinking.R;

public class XmlyLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xmly_login);

        TextView textView = findViewById(R.id.tv_xmly_forgetpwd);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(XmlyLoginActivity.this,XmlyForgetpwdActivity.class);
                startActivity(intent);
            }
        });
    }
}
