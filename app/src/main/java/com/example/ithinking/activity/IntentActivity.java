package com.example.ithinking.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.ithinking.R;

public class IntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        ImageButton imageButton = findViewById(R.id.intent_imageButton_phone);
        ImageButton imageButton1 = findViewById(R.id.intent_imageButton_sms);
        ImageButton imageButton2 = findViewById(R.id.intent_imageButton_close);
        ImageButton imageButton3 = findViewById(R.id.intent_imageButton_openUrl);
        ImageButton imageButton4 = findViewById(R.id.intent_imageButton_filter);

        imageButton.setOnClickListener(l);
        imageButton1.setOnClickListener(l);
        imageButton2.setOnClickListener(l);
        imageButton3.setOnClickListener(l);
        imageButton4.setOnClickListener(l);
    }

    View.OnClickListener l = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            ImageButton imageButton = (ImageButton) view;
            switch (imageButton.getId()) {
                case R.id.intent_imageButton_phone:
                    intent.setAction(intent.ACTION_DIAL);//调用拨号面板
                    intent.setData(Uri.parse("tel:18701925083"));
                    startActivity(intent);
                    break;
                case R.id.intent_imageButton_sms:
                    intent.setAction(intent.ACTION_SENDTO);//发送短信
                    intent.setData(Uri.parse("smsto:17602185083"));
                    intent.putExtra("sms_body","短信内容：Welcome to Android");
                    startActivity(intent);
                    break;
                case R.id.intent_imageButton_close:
                    intent.setAction(intent.ACTION_MAIN);//回到主界面
                    intent.addCategory(intent.CATEGORY_HOME);
                    startActivity(intent);
                    break;
                case R.id.intent_imageButton_openUrl:
                    intent.setAction(intent.ACTION_VIEW);//显示给用户
                    intent.setData(Uri.parse("http://www.mingribook.com"));
                    startActivity(intent);
                    break;
                case R.id.intent_imageButton_filter:
                    intent.setAction(intent.ACTION_VIEW);//显示给用户
                    startActivity(intent);
                    break;
            }
        }
    };
}
