package com.example.ithinking.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.ithinking.R;

import java.util.List;

public class LocationProviderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_provider);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //获取显示LocationProvider
        TextView textView = findViewById(R.id.provider);
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        List<String> providers = locationManager.getAllProviders();//获取所有的LocationProvider名称
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < providers.size(); i++) {
            sb.append(providers.get(i)+"\n");
        }
        textView.setText(sb.toString());

        //获取基于GPS的LocationProvider
//        locationManager.getProvider(LocationManager.GPS_PROVIDER);

        //获取最佳的LocationProvider
        Criteria criteria = new Criteria();//创建一个过滤=条件对象
        criteria.setCostAllowed(false);//不收费的
        criteria.setAccuracy(Criteria.ACCURACY_FINE);//使用精度最准确的
        criteria.setPowerRequirement(Criteria.POWER_LOW);//使用耗电量最低的
        String provider = locationManager.getBestProvider(criteria,true);//获取最佳的LocationProvider名称

        sb.append("最佳LocationProvider名称："+provider);

        textView.setText(sb.toString());
        //添加权限检查
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                1000,//间隔时间
                1,//位置间隔一米
                new LocationListener() {//GPS定位信息发生改变时触发，用于更新位置信息

                    @Override
                    public void onLocationChanged(Location location) {
                        //GPS信息发生改变时，更新位置
                        locationUpdates(location);
                    }

                    @Override
                    //位置状态发生改变时触发
                    public void onStatusChanged(String provider, int status, Bundle extras) {
                    }

                    @Override
                    //定位提供者启动时触发
                    public void onProviderEnabled(String provider) {
                    }

                    @Override
                    //定位提供者关闭时触发
                    public void onProviderDisabled(String provider) {
                    }
                });
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        String s = locationUpdates(location);//将最新的定位信息传递给locationUpdates方法

        sb.append(s);
        textView.setText(sb.toString());

        //GnmU88Tgtuqz81X8sQN29WuHdGGO6roi
    }

    /**
     * 获取定位信息
     * @param location
     */
    public String locationUpdates(Location location){
        if (location != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("\n您的位置是：");
            sb.append("\n经度：");
            sb.append(location.getLongitude());
            sb.append("\n纬度：");
            sb.append(location.getLatitude());
            return sb.toString();
        }
        return "没有获取到您的位置信息";
    }
}
