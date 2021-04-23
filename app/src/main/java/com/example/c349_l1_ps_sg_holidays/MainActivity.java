package com.example.c349_l1_ps_sg_holidays;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView ListViewType;
    ArrayList<String> holidayTypesArrayList;
    ArrayAdapter<String> typeArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListViewType = findViewById(R.id.lvTypes);
        holidayTypesArrayList = new ArrayList();

        holidayTypesArrayList.add("Secular");
        holidayTypesArrayList.add("Ethnic & Religion");

        typeArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, holidayTypesArrayList);
        ListViewType.setAdapter(typeArrayAdapter);

        ListViewType.setOnItemClickListener((adapterView, view, position, l) -> {
            String types = holidayTypesArrayList.get(position);

            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("types", types);
            startActivity(intent);
        });
    }
}