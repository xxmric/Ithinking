package com.example.ithinking.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.example.ithinking.R;

public class BaiduMapActivity extends AppCompatActivity {

    private MapView mMapView;

    private BaiduMap mBaiduMap;//定义百度地图对象
    private boolean isFirstLoc = true;//是否为第一次定位
    private MyLocationConfiguration.LocationMode locationMode;//设置定位模式

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化地图SDK
        SDKInitializer.initialize(getApplicationContext());//不能用this
        setContentView(R.layout.activity_baidu_map);

        mMapView = findViewById(R.id.bmapview);//获取地图组件
        mBaiduMap = mMapView.getMap();  //获取百度地图对象

        /****获取定位服务***/
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
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
        locationUpdates(location);//将最新的定位信息传递给locationUpdates方法
    }

    /**
     * 获取定位信息
     * @param location
     */
    public void locationUpdates(Location location){
        if (location != null) {
            LatLng ll = new LatLng(location.getLatitude(),location.getLongitude());//获取最新定位信息
            Log.i("Location","纬度："+location.getLatitude()+"| 经度："+location.getLongitude());

            if (isFirstLoc) {
                MapStatusUpdate mapStatusUpdate = MapStatusUpdateFactory.newLatLng(ll);
                mBaiduMap.animateMapStatus(mapStatusUpdate);
                isFirstLoc = false;//取消第一次定位
            }
            //构造定位数据
            MyLocationData locationData = new MyLocationData.Builder()
                    .accuracy(location.getAccuracy())//设置精度
                    .direction(100)//设置方向信息
                    .latitude(location.getLatitude())//设置纬度坐标
                    .longitude(location.getLongitude())//设置经度坐标
                    .build();
            mBaiduMap.setMyLocationData(locationData);//设置定位数据
            BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.drawable.icon_geo);//设置图标
            //设置定位模式
            locationMode = MyLocationConfiguration.LocationMode.NORMAL;
            //设置构造方式
            MyLocationConfiguration configuration = new MyLocationConfiguration(locationMode,true,bitmapDescriptor);
            //显示定位图标
            mBaiduMap.setMyLocationConfiguration(configuration);
        }else {
            Log.i("Location","没有获取到您的定位信息！");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //启动定位图层
        mBaiduMap.setMyLocationEnabled(true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
        mMapView = null;
        //停止定位图层
        mBaiduMap.setMyLocationEnabled(false);
    }
}
