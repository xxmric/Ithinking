package com.example.ithinking.activity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ithinking.R;

public class ContentProviderActivity extends AppCompatActivity {
    private String columns = ContactsContract.Contacts.DISPLAY_NAME;//希望获得姓名

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);
        TextView textView = findViewById(R.id.contentProvider_result);
        textView.setText(getQueryData());//显示获取的同学录信息
    }

    private CharSequence getQueryData() {
        StringBuilder stringBuilder = new StringBuilder();//用于保存获取的联系人
        ContentResolver resolver = getContentResolver();
        Cursor cursor = resolver.query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);
        int displayNameIndex = cursor.getColumnIndex(columns);//获得姓名记录的索引值
        for (cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()) {
            String displayName = cursor.getString(displayNameIndex);
            stringBuilder.append(displayName+"\n");
        }
        cursor.close();//关闭记录集
        return stringBuilder.toString();//返回查询结果
    }
}
