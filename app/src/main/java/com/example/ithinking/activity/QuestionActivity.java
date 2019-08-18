package com.example.ithinking.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.ithinking.MainActivity;
import com.example.ithinking.R;

public class QuestionActivity extends AppCompatActivity {

    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        radioGroup = findViewById(R.id.rg_question);
        Button button = findViewById(R.id.bt_submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < radioGroup.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton)radioGroup.getChildAt(i);
                    if(radioButton.isChecked()){//判断选中按钮
                        if("B：车站退款证明书".equals(radioButton.getText())){
                            Toast.makeText(QuestionActivity.this, "回答正确", Toast.LENGTH_SHORT).show();
                        }else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(QuestionActivity.this);
                            builder.setMessage("回答错误，下面告诉你答案：B：车站退款证明书,B：车站退款证明书B：车站退款证明书B：车站退款证明书B：车站退款证明书B：车站退款证明书B：车站退款证明书B：车站退款证明书B：车站退款证明书B：车站退款证明书B：车站退款证明书");
                            builder.setPositiveButton("确定",null).show();
                        }
                        break;
                    }

                }
            }
        });
    }
}
