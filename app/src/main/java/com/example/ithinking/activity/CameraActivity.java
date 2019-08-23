package com.example.ithinking.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.ithinking.MainActivity;
import com.example.ithinking.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CameraActivity extends AppCompatActivity {

    private boolean isPreview;//是否为预览状态
    private Camera camera;//定义一个摄像头

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        ImageButton imageButton = findViewById(R.id.camera_takephoto);
        ImageButton imageButton2 = findViewById(R.id.camera_preview);

        /**打开摄像头并预览**/
        SurfaceView surfaceView = findViewById(R.id.camera_surfaceView);
        final SurfaceHolder surfaceHolder = surfaceView.getHolder();//
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);//设置自己不维护缓冲

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //预览按钮
                if(!isPreview){
                    camera = Camera.open();
                    isPreview = true;
                }
                try {
                    camera.setPreviewDisplay(surfaceHolder);//设置用于显示预览
                    Camera.Parameters parameters = camera.getParameters();//获取摄像头参数

                    parameters.setPictureFormat(PixelFormat.JPEG);
                    parameters.set("jpeg-quality",80);//设置图片质量

                    camera.setParameters(parameters);
                    camera.startPreview();//开始预览
                    camera.autoFocus(null);//自动对焦
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //实现拍照功能
                if(camera !=null) {
                    camera.takePicture(null,null,jpeg);//进行牌照
                }
            }
        });
    }

    Camera.PictureCallback jpeg = new Camera.PictureCallback() {
        @Override
        public void onPictureTaken(byte[] bytes, Camera camera) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.length);//根据拍照所得数据创建位图

            camera.stopPreview();//停止预览
            isPreview = false;
            //获取sd卡根目录
            File appDir = new File(Environment.getExternalStorageDirectory(), "/DCIM/Camera/");
            if (!appDir.exists()) {      //如果该目录不存在
                appDir.mkdir();          //就创建该目录

            }
            String fileName = System.currentTimeMillis() + ".jpg"; //将获取当前系统时间设置为照片名称
            File file = new File(appDir, fileName);  //创建文件对象

            try {  //保存拍到的图片
                FileOutputStream fos = new FileOutputStream(file);  //创建一个文件输出流对象
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);  //将图片内容压缩为JPEG格式输出到输出流对象中
                fos.flush();                                        //将缓冲区中的数据全部写出到输出流中
                fos.close();                                        //关闭文件输出流对象
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //将照片插入到系统图库
            try {
                MediaStore.Images.Media.insertImage(CameraActivity.this.getContentResolver(),
                        file.getAbsolutePath(), fileName, null);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            // 最后通知图库更新
            CameraActivity.this.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
                    Uri.parse("file://" + "")));
            Toast.makeText(CameraActivity.this, "照片保存至：" + file, Toast.LENGTH_LONG).show();
            resetCamera(); //调用重新预览resetCamera()方法

        }
    };

    private void resetCamera() {     //创建resetCamera()方法，实现重新预览功能
        if (!isPreview) {            //如果为非预览模式
            camera.startPreview();    //开启预览
            isPreview = true;
        }
    }

    @Override
    protected void onPause() {  //当暂停Activity时，停止预览并释放资源
        if (camera != null) {        //如果相机不为空
            camera.stopPreview();    //停止预览
            camera.release();        //释放资源
        }
        super.onPause();
    }
}
