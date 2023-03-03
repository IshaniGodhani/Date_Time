package com.example.date_time;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText add_date,add_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add_date=findViewById(R.id.add_date);
        add_time=findViewById(R.id.add_time);
        add_date.setInputType(InputType.TYPE_NULL);
        add_time.setInputType(InputType.TYPE_NULL);
        add_date.setOnClickListener(view -> {
            Calendar calendar=Calendar.getInstance();
            DatePickerDialog datePickerDialog=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int date) {
                    add_date.setText(""+date+"/"+(month+1)+"/"+year);
                }
            },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DATE));
            datePickerDialog.show();
        });

        add_time.setOnClickListener(view -> {
            Calendar calendar=Calendar.getInstance();
            TimePickerDialog timePickerDialog=new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                    add_time.setText(""+hour+":"+minute);
                }
            },calendar.get(Calendar.HOUR),calendar.get(Calendar.MINUTE),false);
            timePickerDialog.show();
        });


    }
}