package com.example.ithinking.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ithinking.R;

public class TaoBaoAddressDetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tao_bao_address_detail);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String name = bundle.getString("name");
        String phone = bundle.getString("phone");
        String email = bundle.getString("email");
        String site = bundle.getString("site1") + bundle.getString("site2") + bundle.getString("site3");

        TextView tv_name = findViewById(R.id.name);
        TextView tv_phone = findViewById(R.id.phone);
        TextView tv_site = findViewById(R.id.site);
        tv_name.setText(name);
        tv_phone.setText(phone);
        tv_site.setText(site);
    }
}
