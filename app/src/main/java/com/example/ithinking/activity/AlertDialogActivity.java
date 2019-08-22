package com.example.ithinking.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ithinking.R;

public class AlertDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
        //显示带取消、确定按钮的对话框按钮
        Button button1 = findViewById(R.id.alertdialog_button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog = new AlertDialog.Builder(AlertDialogActivity.this).create();
                //设置图标
                alertDialog.setIcon(R.drawable.alertdialog_advise);
                //设置标题
                alertDialog.setTitle("乔布斯：");
                //设置内容
                alertDialog.setMessage("活着就是为了改变世界，难道还有其他原因吗？");
                //取消按钮和回调事件
                alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "否", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //为否按钮做出相应处理
                        Toast.makeText(AlertDialogActivity.this, "单击了否按钮", Toast.LENGTH_SHORT).show();
                    }
                });
                //确定按钮和回调事件
                alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //为确定按钮做出相应处理
                        Toast.makeText(AlertDialogActivity.this, "单击了确定按钮", Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog.show();//显示对话框
            }
        });
        //显示带列表的的对话框
        Button button2 = findViewById(R.id.alertdialog_button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //带4个列表项的列表对话框
                final String[] items = {"当你有使命，它会让你更专注","要么出众，要么出局","活着就是为了改变世界",
                        "求知若饥，虚心若愚"};
                AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogActivity.this);
                builder.setIcon(R.drawable.alertdialog_advise1);
                builder.setTitle("请选择你喜欢的名言");//设置标题
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //为确定按钮做出相应处理
                        Toast.makeText(AlertDialogActivity.this, "您选择了【"+items[i]+"】", Toast.LENGTH_SHORT).show();

                    }
                });
                builder.create().show();//创建并显示列表对话框

            }
        });
        //显示带单选列表的对话框
        Button button3 = findViewById(R.id.alertdialog_button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] items = {"扎尔伯克","乔布斯","拉里.埃里森","安迪.鲁宾","马云"};
                AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogActivity.this);
                builder.setIcon(R.drawable.alertdialog_advise2);
                builder.setTitle("如果让你选择，你最喜欢做哪一个：");
                builder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(AlertDialogActivity.this, "你选择了【"+items[i]+"】", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setPositiveButton("确定",null);
                builder.create().show();
            }
        });
        Button button4 = findViewById(R.id.alertdialog_button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final boolean[] checkedItems = {false,true,false,true,false};//记录各选项的状态
                final String[] items = {"开心消消乐","球球大作战","欢乐斗地主","梦幻西游","超级玛丽"};

                AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogActivity.this);
                builder.setIcon(R.drawable.alertdialog_advise2);
                builder.setTitle("你喜欢玩哪些游戏");
                builder.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which, boolean isChecked) {
                        checkedItems[which] = isChecked;

                    }
                });//添加列表项
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String result = "";//记录选择结果的
                        for (int j = 0; j < checkedItems.length; j++) {
                            if (checkedItems[j]) {
                                result += items[j]+"、";
                            }
                        }
                        if (!"".equals(result))
                        Toast.makeText(AlertDialogActivity.this, "你选择了【"+result+"】", Toast.LENGTH_SHORT).show();

                    }
                });
                builder.create().show();//创建并显示对话框了
            }
        });
    }
}
