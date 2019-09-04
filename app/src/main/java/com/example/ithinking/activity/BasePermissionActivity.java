package com.example.ithinking.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;

import com.example.ithinking.R;
import com.example.ithinking.permission.PermissionHelper;
import com.example.ithinking.permission.PermissionInterface;

public class BasePermissionActivity extends AppCompatActivity implements PermissionInterface {

    private static final int PERMESSION_REQUEST_CODE = 99999;
    private static final int NOT_NOTICE = 2;//如果勾选了不再询问
    private PermissionHelper mPermissionHelper;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_base_permission);
        //初始化并发起权限申请
        mPermissionHelper = new PermissionHelper(this, this);
        mPermissionHelper.requestPermissions();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(mPermissionHelper.requestPermissionsResult(requestCode, permissions, grantResults)){
            //权限请求结果，并已经处理了该回调
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public int getPermissionsRequestCode() {
        //设置权限请求requestCode，只有不跟onRequestPermissionsResult方法中的其他请求码冲突即可。
        return PERMESSION_REQUEST_CODE;
    }

    @Override
    public String[] getPermissions() {
        //设置该界面所需的全部权限
        return new String[]{
                Manifest.permission.CALL_PHONE,
                Manifest.permission.SEND_SMS,
                Manifest.permission.VIBRATE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,

                Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS,
                Manifest.permission.CAMERA,
                Manifest.permission.READ_CONTACTS,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_NETWORK_STATE,
                Manifest.permission.INTERNET,
                Manifest.permission.WAKE_LOCK,
                Manifest.permission.CHANGE_WIFI_STATE,
                Manifest.permission.ACCESS_WIFI_STATE,
                Manifest.permission.WRITE_SETTINGS
        };

    }

    @Override
    public void requestPermissionsSuccess() {
        //权限请求用户已经全部允许
    }

    @Override
    public void requestPermissionsFail() {
        //权限请求不被用户允许。可以提示并退出或者提示权限的用途并重新发起权限申请。
//        AlertDialog.Builder builder = new AlertDialog.Builder(BasePermissionActivity.this);
//        builder.setTitle("温馨提示")
//                .setMessage("点击允许才可以使用我们的app哦")
//                .setPositiveButton("去允许", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        if (alertDialog != null && alertDialog.isShowing()) {
//                            alertDialog.dismiss();
//                        }
//                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
//                        Uri uri = Uri.fromParts("package", getPackageName(), null);//注意就是"package",不用改成自己的包名
//                        intent.setData(uri);
//                        startActivityForResult(intent, NOT_NOTICE);
//                    }
//                });
//        alertDialog = builder.create();
//        alertDialog.setCanceledOnTouchOutside(false);
//        alertDialog.show();
//        finish();
    }
}
