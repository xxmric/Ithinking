package com.example.ithinking.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.ithinking.R;
import com.example.ithinking.fragment.WeChatFindFragment;
import com.example.ithinking.fragment.WeChatFragment;
import com.example.ithinking.fragment.WeChatMeFragment;
import com.example.ithinking.fragment.WeChatMessageFragment;

public class FragmentExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_example);

//        //代码中添加Fragment
//        DetailFragment detailFragment = new DetailFragment();
//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        ft.add(android.R.id.content,detailFragment);
//        ft.commit();

        ImageView imageView1 = findViewById(R.id.wechat_image1);
        ImageView imageView2 = findViewById(R.id.wechat_image2);
        ImageView imageView3 = findViewById(R.id.wechat_image3);
        ImageView imageView4 = findViewById(R.id.wechat_image4);

        imageView1.setOnClickListener(l);
        imageView2.setOnClickListener(l);
        imageView3.setOnClickListener(l);
        imageView4.setOnClickListener(l);
    }

    View.OnClickListener l = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

//            FragmentManager fragmentManager = getFragmentManager();
//            FragmentTransaction ft = fragmentManager.beginTransaction();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            Fragment f = null;
            switch (view.getId()) {
                case R.id.wechat_image1:
                    f = new WeChatFragment();
                    break;
                case R.id.wechat_image2:
                    f = new WeChatMessageFragment();
                    break;
                case R.id.wechat_image3:
                    f = new WeChatFindFragment();
                    break;
                case R.id.wechat_image4:
                    f = new WeChatMeFragment();
                    break;
                    default:break;
            }
            ft.replace(R.id.fragment_wechat,f);
            ft.commit();
        }
    };
}
