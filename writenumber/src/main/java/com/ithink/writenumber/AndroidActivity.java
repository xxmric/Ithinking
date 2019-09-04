package com.ithink.writenumber;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
/*
 * 程序首页面
 */
public class AndroidActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //点击事件 进入不同的数字页面
    public void onOne(View v) {
        //页面跳转
        startActivity(new Intent(AndroidActivity.this, OneActivity.class));
    }

    public void onTwo(View v){   //单击事件  进入数字2书写界面
        //当前界面跳转至数字2书写界面
        startActivity(new Intent(AndroidActivity.this, TwoActivity.class));
    }
    public void onThree(View v){   //单击事件  进入数字3书写界面
        //当前界面跳转至数字3书写界面
        startActivity(new Intent(AndroidActivity.this, ThreeActivity.class));
    }
    public void onFour(View v){   //单击事件  进入数字4书写界面
        //当前界面跳转至数字4书写界面
        startActivity(new Intent(AndroidActivity.this, FourActivity.class));
    }
    public void onFive(View v){   //单击事件  进入数字5书写界面
        //当前界面跳转至数字5书写界面
        startActivity(new Intent(AndroidActivity.this, FiveActivity.class));
    }
    public void onSix(View v){   //单击事件  进入数字6书写界面
        //当前界面跳转至数字6书写界面
        startActivity(new Intent(AndroidActivity.this, SixActivity.class));
    }
    public void onSeven(View v){   //单击事件  进入数字7书写界面
        //当前界面跳转至数字7书写界面
        startActivity(new Intent(AndroidActivity.this, SevenActivity.class));
    }
    public void onEight(View v){   //单击事件  进入数字8书写界面
        //当前界面跳转至数字8书写界面
        startActivity(new Intent(AndroidActivity.this, EightActivity.class));
    }
    public void onNine(View v){   //单击事件  进入数字9书写界面
        //当前界面跳转至数字9书写界面
        startActivity(new Intent(AndroidActivity.this, NineActivity.class));
    }
    public void onZero(View v){   //单击事件  进入数字8书写界面
        //当前界面跳转至数字8书写界面
        startActivity(new Intent(AndroidActivity.this, ZeroActivity.class));
    }

    //点击事件 进入关于页面
    public void onAbout(View v) {
        startActivity(new Intent(AndroidActivity.this, AboutActivity.class));
    }
}