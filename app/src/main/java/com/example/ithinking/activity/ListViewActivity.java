package com.example.ithinking.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.ithinking.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        int[] imageId = new int[]{
                R.mipmap.listview_img01,
                R.mipmap.listview_img02,
                R.mipmap.listview_img03,
                R.mipmap.listview_img04,
                R.mipmap.listview_img05,
                R.mipmap.listview_img06,
                R.mipmap.listview_img07,
                R.mipmap.listview_img08,
                R.mipmap.listview_img09
        };
        String[] title = new String[]{
                "六欲",
                "都是费",
                "第三个",
                "打个盹",
                "大帅哥",
                "舍得噶多个",
                "倒萨更多",
                "发撒旦",
                "多萨格"
        };
        List<Map<String,Object>> list = new ArrayList<>();
        for (int i = 0; i < imageId.length; i++) {
            Map<String,Object> map = new HashMap<>();
            map.put("image",imageId[i]);
            map.put("name",title[i]);
            list.add(map);
        }
        //创建适配器
        SimpleAdapter adapter = new SimpleAdapter(this,list,R.layout.activity_list_item,new String[]{"image","name"},new int[]{R.id.iv_item_image,R.id.tv_item_title});

        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Map<String,Object> map = (Map<String,Object>)adapterView.getItemAtPosition(position);
                Toast.makeText(ListViewActivity.this, map.get("name").toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
