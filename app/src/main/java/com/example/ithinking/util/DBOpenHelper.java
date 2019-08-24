package com.example.ithinking.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * sqlite3数据库创建表类
 */
public class DBOpenHelper extends SQLiteOpenHelper {
    private String CREATE_TABLE_SQL = "create table tb_dict(_id integer primary key autoincrement,word,detail)";//创建数据表的SQL语句
    public DBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, null, version);//设置工厂为空
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_SQL);//创建单词的数据表
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Log.i("词典","--版本更新"+oldVersion+"--->"+newVersion);

    }
}
