package com.example.ithinking.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.ithinking.R;

import java.util.Calendar;

public class DateAndTimeActivity extends Activity {
    private int year,month,day;
    private DatePicker datePickerDate;
    private TimePicker datePickerTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_and_time);
        //日期选择器
        datePickerDate = findViewById(R.id.dp_date);
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        datePickerDate.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int day) {
                DateAndTimeActivity.this.year = year;
                DateAndTimeActivity.this.month = month;
                DateAndTimeActivity.this.day = day;
                show(year, month, day);
            }
        });

        //时间选择器
        datePickerTime = findViewById(R.id.dp_time);
        datePickerTime.setIs24HourView(true);//设置24小时制
        datePickerTime.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int hourOfDay, int minute) {
                String str = hourOfDay + "时" + minute + "分";
                Toast.makeText(DateAndTimeActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void show(int year, int month, int day){
        String str = year+"年"+(month+1)+"月"+day+"日";
        Toast.makeText(DateAndTimeActivity.this, str, Toast.LENGTH_SHORT).show();
    }
}
