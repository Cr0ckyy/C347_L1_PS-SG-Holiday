package com.example.c349_l1_ps_sg_holidays;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lv;
    TextView tv;
    ArrayAdapter holidayArrayAdapter;
    ArrayList<Holiday> holidayArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv = findViewById(R.id.lvHoliday);
        tv = findViewById(R.id.tvHoliday);

        Intent i = getIntent();
        String type = i.getStringExtra("types");
        tv.setText(type);

        holidayArrayList = new ArrayList<>();

        if (type.equals("Secular")) {
            holidayArrayList.add(new Holiday("New Year's Day", "1 Jan 2022", "newYear"));
            holidayArrayList.add(new Holiday("Labour Day", "1 May 2022", "labourDay"));

        } else {
            holidayArrayList.add(new Holiday("Chinese New Year", "28-29 Jan 2022", "cny"));
            holidayArrayList.add(new Holiday("Good Friday", "14 April 2022", "goodFriday"));
        }

        holidayArrayAdapter = new HolidayAdapter(this, R.layout.holiday_row, holidayArrayList);
        lv.setAdapter(holidayArrayAdapter);
        lv.setOnItemClickListener((parent, view, position, id) -> {
            Holiday selectedHoliday = holidayArrayList.get(position);
            Toast.makeText(SecondActivity.this, selectedHoliday.getName() + ": " + selectedHoliday.getDate(), Toast.LENGTH_SHORT).show();
        });
    }
}