package com.example.ithinking.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ithinking.R;

public class SharedPreferencesActivity extends AppCompatActivity {

    private String _USERNAME = "admin",_PASSWORD = "123";//定义后台账户密码

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        final EditText usernameET = findViewById(R.id.sp_username);
        final EditText passwordET = findViewById(R.id.sp_password);
        ImageButton login = findViewById(R.id.sp_login);
        //获取Shared Preferences 对象
        final SharedPreferences sp = getSharedPreferences("ithinking",MODE_PRIVATE);//指定文件名和本应用使用
        /*******实现自动登录功能***************/
        String username = sp.getString("username",null);//获取账户信息
        String password = sp.getString("password",null);//获取密码信息
        if (username != null && password != null) {
            if (_USERNAME.equals(username) && _PASSWORD.equals(password)) {
                Intent intent = new Intent(this,MessageActivity.class);
                startActivity(intent);
            }
        }else {
            /************实现手动登录并存储账户和密码*********/
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String in_username = usernameET.getText().toString().trim();//获取输入账户
                    String in_password = passwordET.getText().toString().trim();//获取输入密码
                    //获取Editor对象
                    SharedPreferences.Editor editor = sp.edit();
                    if (_USERNAME.equals(in_username) && _PASSWORD.equals(in_password)) {
                        editor.putString("username",in_username);//保存账户
                        editor.putString("password",in_password);//保存密码
                        editor.commit();//提交信息
                        Intent intent = new Intent(SharedPreferencesActivity.this,MessageActivity.class);
                        startActivity(intent);
                        Toast.makeText(SharedPreferencesActivity.this, "已保存账户和密码", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(SharedPreferencesActivity.this, "账户和密码错误", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
