package com.example.ithinking.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ithinking.R;

public class TaoBaoAddressActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tao_bao_address);

        Button button = findViewById(R.id.bt_taobao_submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String site1 = ((EditText)findViewById(R.id.et_site1)).getText().toString();
                String site2 = ((EditText)findViewById(R.id.et_site2)).getText().toString();
                String site3 = ((EditText)findViewById(R.id.et_site3)).getText().toString();
                String name = ((EditText)findViewById(R.id.et_name)).getText().toString();
                String phone = ((EditText)findViewById(R.id.et_phone)).getText().toString();
                String email = ((EditText)findViewById(R.id.et_email)).getText().toString();
                if (!"".equals(site1) && !"".equals(site2) && !"".equals(site3)
                && !"".equals(name) && !"".equals(phone) && !"".equals(email) ) {

                    Intent intent = new Intent(TaoBaoAddressActivity.this,TaoBaoAddressDetailActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putCharSequence("site1",site1);
                    bundle.putCharSequence("site2",site2);
                    bundle.putCharSequence("site3",site3);
                    bundle.putCharSequence("name",name);
                    bundle.putCharSequence("phone",phone);
                    bundle.putCharSequence("email",email);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }else {
                    Toast.makeText(TaoBaoAddressActivity.this, "请将收货信息填写完整！", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
