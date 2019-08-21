package com.example.ithinking.activity;

import android.app.Activity;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.EditText;


import com.example.ithinking.R;

import java.util.ArrayList;

//第二步：实现GestureOverlayView.OnGesturePerformedListener接口，并重写onGesturePerformed()方法
public class CreateEventActivity extends Activity implements GestureOverlayView.OnGesturePerformedListener {

    private GestureLibrary mGestureLibrary;
    private EditText mEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
        //第三部：加载raw文件夹中的手势文件，如果加载失败则退出应用
        mGestureLibrary = GestureLibraries.fromRawResource(CreateEventActivity.this,R.raw.gestures);
        mEditText = findViewById(R.id.et_createEvent);
        if(!mGestureLibrary.load()){
            finish();
        }
        //第四步：获得GestureOverlayView组件，并且为其设置属性值和事件监听器
        GestureOverlayView gestureOverlayView = findViewById(R.id.gesture);
        gestureOverlayView.setGestureColor(Color.BLACK);
        gestureOverlayView.setFadeOffset(1000);
        gestureOverlayView.addOnGesturePerformedListener(this);
    }

    @Override
    public void onGesturePerformed(GestureOverlayView gestureOverlayView, Gesture gesture) {
        //第五步：获得最佳匹配进行显示，并更新编辑框
        ArrayList<Prediction> gestures = mGestureLibrary.recognize(gesture);
        int index = 0;
        double score = 0.0;
        for (int i = 0; i < gestures.size(); i++) {
            Prediction result = gestures.get(i);
            if(result.score > score) {
                index = i;
                score = result.score;
            }
        }
        String text = mEditText.getText().toString();
        text += gestures.get(index).name;
        mEditText.setText(text);

    }
}
