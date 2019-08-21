package com.example.ithinking.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import com.example.ithinking.R;

/**
 * 自定义View 用来绘制帽子的
 */
public class HatView extends View {
    //记录帽子的坐标
    private float bitmapX;
    private float bitmapY;

    public HatView(Context context) {
        super(context);
        bitmapX = 65;
        bitmapY = 0;
    }

    /**
     * 绘制帽子
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //指定绘制帽子的图片资源
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.mipmap.touchevent_hat);
        //创建绘笔对象
        Paint paint = new Paint();
        canvas.drawBitmap(bitmap,bitmapX,bitmapY,paint);
        if(bitmap.isRecycled()){//判断绘笔对象资源是否回收
            bitmap.recycle();
        }
    }

    public float getBitmapX() {
        return bitmapX;
    }

    public void setBitmapX(float bitmapX) {
        this.bitmapX = bitmapX;
    }

    public float getBitmapY() {
        return bitmapY;
    }

    public void setBitmapY(float bitmapY) {
        this.bitmapY = bitmapY;
    }
}
