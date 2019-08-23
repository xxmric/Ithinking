package com.example.ithinking.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Environment;
import android.view.View;

import com.example.ithinking.R;

import java.io.File;

/**
 * 画笔和画布
 */
public class DrawView extends View {

    public DrawView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /***绘制一个橙色的矩形**/
//        Paint paint = new Paint();//定义一个默认的画笔
//        paint.setColor(0xFFFF6600);//设置画笔的颜色 默认是透明的
//        paint.setStyle(Paint.Style.FILL);//设置填充的方式
//        canvas.drawRect(10,10,280,150,paint);//绘制矩形

        /**绘制一个安卓机器人**/
        Paint p = new Paint();
        p.setAntiAlias(true);//设置采用抗锯齿功能
        p.setColor(0xFFA4C739);//设置画笔的颜色为绿色
        //绘制机器人的头
        RectF rectF = new RectF(10,10,100,100);
        rectF.offset(90,20);
        canvas.drawArc(rectF,-10,-160,false,p);//绘制弧

        //绘制眼镜
        p.setColor(0xFFFFFFFF);
        canvas.drawCircle(165,53,4,p);
        canvas.drawCircle(125,53,4,p);
        //绘制天线
        p.setColor(0xFFA4C739);
        p.setStrokeWidth(2);//设置笔触宽度
        canvas.drawLine(110,15,125,35,p);
        canvas.drawLine(180,15,165,35,p);
        //绘制身体
        canvas.drawRect(100,75,190,150,p);//绘制矩形
        RectF rectF_body = new RectF(100,140,190,160);
        canvas.drawRoundRect(rectF_body,10,10,p);//绘制圆角矩形
        //绘制胳膊
        RectF rectF_arm = new RectF(75,75,95,140);
        canvas.drawRoundRect(rectF_arm,10,10,p);//绘制圆角矩形
        rectF_arm.offset(120,0);
        canvas.drawRoundRect(rectF_arm,10,10,p);
        //绘制腿
        RectF rectf_leg=new RectF(115,150,135,200);
        canvas.drawRoundRect(rectf_leg, 10, 10, p);	//绘制左侧的腿
        rectf_leg.offset(40, 0);							//设置在X轴上偏移40像素
        canvas.drawRoundRect(rectf_leg, 10, 10, p);	//绘制右侧的腿

        /**绘制文本**/
        p.setColor(0xFF000000);//黑色
        p.setAntiAlias(true);//采用抗锯齿功能
        p.setTextAlign(Paint.Align.LEFT);//文字对齐方式
        p.setTextSize(25);//设置文字大小 不需要单位
        canvas.drawText("你想和我一起",300,160,p);
        canvas.drawText("去探险吗？",300,200,p);
        canvas.drawText("不，我不想去！",345,45,p);

        /***绘制图片**/
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.mipmap.rabbit);
        canvas.drawBitmap(bitmap,500,500,p);
        //挖取图片一小块区域
        canvas.drawBitmap(bitmap.createBitmap(bitmap,0,0,100,50),600,500,p);

        if(bitmap.isRecycled()) {//强制回收
            bitmap.recycle();
        }

        /****绘制路径**/
        p.setColor(0xFF0000FF);//蓝色
        p.setStyle(Paint.Style.STROKE);//设置填充样式为描边
        Path path = new Path();
        path.addCircle(150,500,50,Path.Direction.CW);//创建圆形路径
        canvas.drawPath(path,p);//绘制路径
        canvas.drawTextOnPath("活着就是为了改变世界",path,0,0,p);

        /***/
    }
}
