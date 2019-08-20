package com.example.ithinking.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.ithinking.R;

public class SelectIcoHeadActivity extends Activity {
    private int[] imageId = new int[]{
            R.drawable.touxiang1,
            R.drawable.touxiang2,
            R.drawable.touxiang3,
            R.drawable.touxiang4,
            R.drawable.touxiang5
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_ico_head);
        GridView gridView = findViewById(R.id.ico_head_gridView);
        BaseAdapter baseAdapter = new BaseAdapter() {

            @Override
            public View getView(int position, View view, ViewGroup viewGroup) {
                ImageView imageView;
                if(view ==null) {
                    imageView = new ImageView(SelectIcoHeadActivity.this);
                    /**设置图像的宽度和高度**/
                    imageView.setAdjustViewBounds(true);
                    imageView.setMaxWidth(158);
                    imageView.setMaxHeight(150);
                    //设置内边距
                    imageView.setPadding(5,5,5,5);
                }else {
                    imageView = (ImageView) view;
                }
                imageView.setImageResource(imageId[position]);//为ImageView设置要显示的图片
                return imageView;
            }
            /*
             * 功能：获得当前选项的ID
             */
            @Override
            public long getItemId(int position) {
                return position;
            }

            /*
             * 功能：获得当前选项
             */
            @Override
            public Object getItem(int position) {
                return position;
            }

            /*
             * 获得数量
             */
            @Override
            public int getCount() {
                return imageId.length;
            }

        };
        // 将适配器与GridView关联
        gridView.setAdapter(baseAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = getIntent();//获取Intent对象
                Bundle bundle = new Bundle();//实例化要传递的数据包
                bundle.putInt("imageId",imageId[position]);// 显示选中的图片
                intent.putExtras(bundle);//将数据包保存到intent中
                setResult(0x11,intent);//设置返回的结果码，并返回调用该Activity的Activity
                finish();//关闭当前Activity
            }
        });
    }
}
