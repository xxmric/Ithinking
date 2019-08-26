package com.example.ithinking.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ithinking.R;

/**
 * 第一步：实现SensorEventListener接口
 */
public class LightSensorActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;//声明一个传感器

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_sensor);
        
        //获取传感器监听器
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
    }

    /**
     * 第二步：注册指定类型传感器监听器
     */
    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this,mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT),SensorManager.SENSOR_DELAY_GAME);//注册光线传感器指定精度为游戏模式精度

    }
    /**
     * 第三步：取消注册指定类型传感器监听器
     */
    @Override
    protected void onPause() {
        mSensorManager.unregisterListener(this);
        super.onPause();

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] values = sensorEvent.values;//获取传感器提供的数据值
        int type = sensorEvent.sensor.getType();//获取传感器类型
        if (Sensor.TYPE_LIGHT == type) {//光线传感器
            StringBuilder sb = new StringBuilder("当前光线的强度值：");
            sb.append(values[0]);
            TextView textView = findViewById(R.id.tv_lightSensor);
            textView.setText(sb.toString());
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
