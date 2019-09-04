package com.example.ithinking.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ithinking.MainActivity;
import com.example.ithinking.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class ScanQrCodeActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requsetPermission();//申请系统权限
        setContentView(R.layout.activity_scan_qr_code);

        mTextView = findViewById(R.id.text_result);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if (grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    //这里已经获取到了摄像头的权限，想干嘛干嘛了可以

                }else {
                    //这里是拒绝给APP摄像头权限，给个提示什么的说明一下都可以。
                    Toast.makeText(ScanQrCodeActivity.this,"请手动打开相机权限",Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                mTextView.setText(result.getContents());
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void requsetPermission(){
        if (Build.VERSION.SDK_INT>22){
            if (ContextCompat.checkSelfPermission(ScanQrCodeActivity.this,
                    android.Manifest.permission.CAMERA)!=     PackageManager.PERMISSION_GRANTED){
                //先判断有没有权限 ，没有就在这里进行权限的申请
                ActivityCompat.requestPermissions(ScanQrCodeActivity.this,
                        new String[]{android.Manifest.permission.CAMERA},1);

            }else {

            }
        }else {

        }
    }

    /***
     * 触发扫描二维码事件
     * @param view
     */
    public void startScan(View view) {
        /*以下是启动我们自定义的扫描活动*/
        IntentIntegrator intentIntegrator = new IntentIntegrator(ScanQrCodeActivity.this);
        intentIntegrator.setBeepEnabled(true);
        intentIntegrator.setCaptureActivity(ScanActivity.class);
        intentIntegrator.initiateScan();
    }

    /**
     * 自定义扫描样式
     * @param view
     */
    public void startScan2(View view) {
        // 创建IntentIntegrator对象
        IntentIntegrator intentIntegrator = new IntentIntegrator(ScanQrCodeActivity.this);
        // 设置可以保存条形码（二维码）图片
//        intentIntegrator.setBarcodeImageEnabled(true);
        /*设置启动我们自定义的扫描活动，若不设置，将启动默认活动*/
        intentIntegrator.setCaptureActivity(ScanActivity.class);
        /**设置扫描提示音*/
        intentIntegrator.setBeepEnabled(true);
        //设置条形码的格式 默认全部类型 IntentIntegrator.QR_CODE_TYPES 为二维码类型
        intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        //该方法用于设置扫描界面的提示信息
        intentIntegrator.setPrompt("这里是设置扫描界面的提示信息");
        //这里是设置二维码的超时时间
        intentIntegrator.setTimeout(10000);
        //指定自定义扫描
        intentIntegrator.setCaptureActivity(CustomCaptureActivity.class);
        // 开始扫描
        intentIntegrator.initiateScan();
    }
}
