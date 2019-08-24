package com.example.ithinking.activity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ithinking.R;
import com.example.ithinking.util.DBOpenHelper;

public class Sqlite3AddActivity extends AppCompatActivity {

    private DBOpenHelper dbOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite3_add);

        dbOpenHelper = new DBOpenHelper(this,"db_dict",null,1);//实例化DBOpenHelper对象 用来创建数据库

        final EditText etWord = findViewById(R.id.add_word);
        final EditText etExplain = findViewById(R.id.add_interpret);
        ImageButton btn_Save = findViewById(R.id.save_btn);
        ImageButton btn_Cancel = findViewById(R.id.cancel_btn1);

        btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String word = etWord.getText().toString();  //获取填写的生词
                String interpret = etExplain.getText().toString(); //获取填写的解释
                if (word.equals("")||interpret.equals("")){  //如果填写的单词或者解释为空时
                    Toast.makeText(Sqlite3AddActivity.this, "填写的单词或解释为空", Toast.LENGTH_SHORT).show();
                }else {
                    // 调用insertData()方法，实现插入生词数据
                    insert(dbOpenHelper.getReadableDatabase(),word,interpret);
                    // 显示提示信息
                    Toast.makeText(Sqlite3AddActivity.this, "添加生词成功！", Toast.LENGTH_LONG).show();
                }
            }
        });
        btn_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Sqlite3AddActivity.this, Sqlite3Activity.class);  //通过Intent跳转查询单词界面
                startActivity(intent);
            }
        });
    }
    //插入数据的方法
    private void insert(SQLiteDatabase sqLiteDatabase,String word,String interpret) {
        ContentValues values = new ContentValues();
        values.put("word",word);
        values.put("detail",interpret);
        sqLiteDatabase.insert("tb_dict",null,values);//执行插入数据操作
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (dbOpenHelper != null) {
            dbOpenHelper.close();//关闭数据库连接
        }
    }

}
