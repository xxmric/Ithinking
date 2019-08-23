package com.example.ithinking.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * 广播接收器
 */
public class MyReceiver extends BroadcastReceiver {
    private static final String ACTION1 = "zuckerberg";//动作1
    private static final String ACTION2 = "mayun";//动作2

    @Override
    public void onReceive(Context context, Intent intent) {
        if (ACTION1.equals(intent.getAction())) {//回复第一个广播
            Toast.makeText(context, "MyReceiver收到：扎尔伯格的广播", Toast.LENGTH_SHORT).show();
        }else if (ACTION2.equals(intent.getAction())) {//回复第二个广播
            Toast.makeText(context, "MyReceiver收到：马云的广播", Toast.LENGTH_SHORT).show();
        }

    }
}
