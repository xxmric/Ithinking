package com.example.ithinking.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.util.AttributeSet;
import android.view.View;
import android.hardware.SensorEventListener;

import com.example.ithinking.R;

public class SpiritlevelView extends View implements SensorEventListener {

    private SensorManager mSensorManager;
    private Bitmap bubble;//小蓝球位图对象
    float[] acclerValues = new float[3];//加速度传感器的值
    float[] magneValues = new float[3];;//加速度传感器的值

    private int MAX_ANGLE = 30;//手机的最大倾斜焦点
    private int bubbleX,bubbleY;//小蓝球的位置坐标

    public SpiritlevelView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mSensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        //加速度传感器监听器
        mSensorManager.registerListener(this,mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_GAME);
        //磁场传感器监听器
        mSensorManager.registerListener(this,mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD),SensorManager.SENSOR_DELAY_GAME);

        bubble = BitmapFactory.decodeResource(getResources(), R.drawable.bubble);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            acclerValues = sensorEvent.values.clone();//加速度传感器的值
        } else if(sensorEvent.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
            magneValues = sensorEvent.values.clone();//获取磁场传感器的值
        }
        float[] r = new float[9];//保存旋转数据的数组
        float[] values = new float[3];//保存方向数据的数组
        SensorManager.getRotationMatrix(r,null,acclerValues,magneValues);//获得一个包含
        SensorManager.getOrientation(r,values);//获取方向值
        float xAngle = (float) Math.toDegrees(values[1]); //x轴旋转角度
        float yAngle = (float) Math.toDegrees(values[2]); //y轴旋转角度
        getPosition(xAngle,yAngle);//获取小球的位置坐标
        super.postInvalidate();//刷新界面
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bubble,bubbleX,bubbleY,new Paint());
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    //根据x轴和y轴的旋转角度确定小蓝球的位置
    private  void getPosition(float xAngle,float yAngle){
        // 小蓝球位于中间时（水平仪完全水平），小蓝球的X、Y坐标
        int x = (super.getWidth() - bubble.getWidth()) / 2;
        int y = (super.getHeight() - bubble.getHeight()) / 2;
        /********控制小球的X轴位置******/

        if (Math.abs(yAngle) <= MAX_ANGLE) {   // 如果Y轴的倾斜角度还在最大角度之内
            // 根据Y轴的倾斜角度计算X坐标的变化值（倾斜角度越大，X坐标变化越大）
            int deltaX = (int) ((super.getWidth() - bubble.getWidth()) / 2 * yAngle / MAX_ANGLE);
            x -= deltaX;
        } else if (yAngle > MAX_ANGLE) {  // 如果Y轴的倾斜角度已经大于MAX_ANGLE，小蓝球在最左边
            x = 0;
        } else {  // 如果与Y轴的倾斜角已经小于负的MAX_ANGLE，小蓝球在最右边
            x = super.getWidth() - bubble.getWidth();
        }
        /********控制小球的Y轴位置******/
        if (Math.abs(xAngle) <= MAX_ANGLE) {  // 如果X轴的倾斜角度还在最大角度之内
            // 根据X轴的倾斜角度计算Y坐标的变化值（倾斜角度越大，Y坐标变化越大）
            int deltaY = (int) ((super.getHeight() - bubble.getHeight()) / 2 * xAngle / MAX_ANGLE);
            y += deltaY;
        } else if (xAngle > MAX_ANGLE) {  // 如果与X轴的倾斜角度已经大于MAX_ANGLE，小蓝球在最下边
            y = super.getHeight() - bubble.getHeight();
        } else {  // 如果X轴的倾斜角已经小于负的MAX_ANGLE，小蓝球在最上边
            y = 0;
        }
        //更新小蓝球的坐标
        bubbleX = x;
        bubbleY = y;
    }
}
