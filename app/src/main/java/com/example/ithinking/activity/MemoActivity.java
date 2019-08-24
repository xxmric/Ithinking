package com.example.ithinking.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ithinking.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MemoActivity extends AppCompatActivity {
    private byte[] buffer ;//保存数据字节数组

    private File file;//申明一个文件对象，用来指定外部存储文件的
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);
        ImageButton cancel = findViewById(R.id.memo_cancel);

        /************************内部存储start****/
        final EditText editText = findViewById(R.id.memo_editText);
        ImageButton inSave = findViewById(R.id.memo_save);//内部存储
        inSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /****存储保存填写的备忘信息***/
                FileOutputStream fos = null;//声明文件输出流
                String text = editText.getText().toString();//获取输入的备忘信息
                try {
                    fos = openFileOutput("memo",MODE_PRIVATE);//指定文件名和访问权限
                    fos.write(text.getBytes());//保存备忘信息
                    fos.flush();//刷新清除缓存
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if (fos != null) {
                        try {

                            fos.close();
                            Toast.makeText(MemoActivity.this, "保存备忘信息成功！", Toast.LENGTH_SHORT).show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        });
        /*****d读取保存的备忘信息******************************/
        FileInputStream fis = null;
        try {
            fis = openFileInput("memo");//获取文件输入流对象

            buffer = new byte[fis.available()];
            fis.read(buffer);//从输入流中读取数据
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fis != null){
                try {

                    fis.close();//关闭输入流对象
                    String data = new String(buffer);//把字节数组中的数据转换成字符串
                    editText.setText(data);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        /************************内部存储end ****/

        /************************外部存储start ****/
//        file = new File(Environment.getExternalStorageDirectory(),"Text.text");//实例化文件
        /************************外部存储end ****/
    }
}
