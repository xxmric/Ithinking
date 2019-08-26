package com.example.ithinking.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.widget.Toast;

import com.example.ithinking.R;

public class AccelerometerSensorActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Vibrator mVibrator;//定义震动器对象

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer_sensor);
        //获取传感器管理器
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mVibrator = (Vibrator) getSystemService(Service.VIBRATOR_SERVICE);//获取震动器
    }

    @Override
    protected void onResume() {
        super.onResume();
        //注册监听器
        mSensorManager.registerListener(this,mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSensorManager.unregisterListener(this);//取消监听器
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        if (Sensor.TYPE_ACCELEROMETER == type) {
            float[] values = sensorEvent.values;//获取传感器的值
            if (values[0] > 15 || values[1] > 15 || values[2] >20 ) {
                Toast.makeText(this, "摇一摇", Toast.LENGTH_SHORT).show();

                AlertDialog.Builder builder = new AlertDialog.Builder(this);//创建对话框构建器
                builder.setView(R.layout.packet);
                builder.show();//显示对话框
                mVibrator.vibrate(500);//设置振动器的震动频率
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
