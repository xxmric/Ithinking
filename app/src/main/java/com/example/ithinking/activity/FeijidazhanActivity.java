package com.example.ithinking.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.ithinking.R;

public class FeijidazhanActivity extends AppCompatActivity {

    private Button button;
    private CheckBox checkBox1,checkBox2,checkBox3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feijidazhan);

        button = findViewById(R.id.bt_feiji_login);
        checkBox1 = findViewById(R.id.feiji_checkbox1);
        checkBox2 = findViewById(R.id.feiji_checkbox2);
        checkBox3 = findViewById(R.id.feiji_checkbox3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String checked = "";
                if(checkBox1.isChecked()) {
                    checked += checkBox1.getText().toString();
                }
                if(checkBox2.isChecked()) {
                    checked += checkBox2.getText().toString();
                }
                if(checkBox3.isChecked()) {
                    checked += checkBox3.getText().toString();
                }
                Toast.makeText(FeijidazhanActivity.this, checked, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
