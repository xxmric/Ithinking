package com.example.ithinking.activity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ithinking.R;
import com.example.ithinking.util.DBOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Sqlite3Activity extends AppCompatActivity {
    private DBOpenHelper dbOpenHelper;//申明DBOpenHelper对象

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite3);

        dbOpenHelper = new DBOpenHelper(this,"db_dict",null,1);//实例化DBOpenHelper对象 用来创建数据库

        final ListView listView = (ListView) findViewById(R.id.result_listView);  //获取显示结果的ListView
        final EditText etSearch = (EditText) findViewById(R.id.search_et);          //获取查询内容的编辑框
        ImageButton btnSearch = (ImageButton) findViewById(R.id.search_btn);     //获取查询按钮
        Button btn_add = (Button) findViewById(R.id.btn_add);                    //获取跳转添加生词界面的按钮
        btn_add.setOnClickListener(new View.OnClickListener() {   //单击添加生词按钮，实现跳转到添加生词的界面
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sqlite3Activity.this, Sqlite3AddActivity.class);  //通过Intent跳转添加生词界面
                startActivity(intent);
            }
        });
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String key = etSearch.getText().toString();//获取要查询的单词
                Cursor cursor = dbOpenHelper.getReadableDatabase().query("tb_dict",null,"word=?",new String[]{key},null,null,null);
                ArrayList<Map<String,String>> result = new ArrayList<>();//保存查询结果
                while (cursor.moveToNext()) {
                    Map<String,String> map = new HashMap<>();
                    map.put("word",cursor.getString(1));//第2列单词
                    map.put("interpret",cursor.getString(2));//第三列结果
                    result.add(map);
                }
                if (result ==null || result.size()== 0) {//数据库中没有数据
                    Toast.makeText(Sqlite3Activity.this, "很遗憾，没有相关记录！", Toast.LENGTH_SHORT).show();
                }else {
                    //否则将查询的结果显示到ListView列表中
                    SimpleAdapter simpleAdapter = new SimpleAdapter(Sqlite3Activity.this,result,R.layout.activity_sqlite_result,new String[]{"word","interpret"},new int[]{R.id.result_word,R.id.result_interpret});
                    listView.setAdapter(simpleAdapter);
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (dbOpenHelper != null) {
            dbOpenHelper.close();//关闭数据库连接
        }
    }
}
