package com.example.ithinking.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.AttributeSet;
import android.view.View;

import com.example.ithinking.R;

public class PointerView extends View implements SensorEventListener {

    private SensorManager mSensorManager;//传感器管理器
    private Bitmap pointer;//定义指针位图对象
    private float[] mValues;//记录磁场传感器的值

    public PointerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //获取传感器管理器和注册监听器
        mSensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        mSensorManager.registerListener(this,mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD),mSensorManager.SENSOR_DELAY_GAME);
        pointer = BitmapFactory.decodeResource(super.getResources(), R.drawable.pointer);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //根据X轴、Y轴的值绘制指针
        if (mValues != null) {
            float x = mValues[0];//X轴的磁场强度
            float y = mValues[1];//Y轴的磁场强度

//            canvas.save();//保存画布状态,后续绘制的都是在新画布坐标
//            canvas.restore();//重置绘图对象

            canvas.translate(super.getWidth()/2,super.getHeight()/2);//设置旋转的中心点为屏幕的中心点
            if (y == 0 && x > 0) {
                canvas.rotate(90);//旋转90度
            }else if(y == 0 && x < 0 ) {
                canvas.rotate(270);//旋转270度
            }else {
                if (y >= 0){
                    canvas.rotate((float) (Math.tanh(x/y)*90));
                }else {
                    canvas.rotate(180+(float) (Math.tanh(x/y)*90));
                }
            }

        }
        canvas.drawBitmap(this.pointer,-this.pointer.getWidth()/2,-this.pointer.getHeight()/2,new Paint());
    }

    /**
     * 传感器值改变
     * @param sensorEvent
     */
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        //判断是否为磁场传感器
        if (sensorEvent.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
            mValues = sensorEvent.values;
            super.postInvalidate();//刷新界面
        }
    }

    /**
     * 传感器精度改变
     * @param sensor
     * @param i
     */
    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
