package com.example.ithinking.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BinderService extends Service {
    public BinderService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return new MyBinder();
    }
    //自定义方法，用于生成随机数
    public List<String> getRandomNumber(){
        List<String> resArr = new ArrayList<String>();
        String strNumber = "";//用于保存生成的随机数
        for (int i = 0; i < 7; i++) {
            int number = new Random().nextInt(33)+1;//生成指定范围的随机数
            if (number < 10 ) {
                strNumber = "0" + String.valueOf(number);
            } else {
                strNumber = String.valueOf(number);
            }
            resArr.add(strNumber);
        }
        return resArr;
    }

    /*****创建MyBinder内部类*********/
    public class MyBinder extends Binder{
        //创建获取Service的方法
        public BinderService getService(){
            return BinderService.this;//返回当前的Service类
        }

    }

    @Override
    public void onDestroy() {//销毁Service
        super.onDestroy();
    }
}
