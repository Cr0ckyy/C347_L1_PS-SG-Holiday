package com.example.c349_l1_ps_sg_holidays;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HolidayAdapter extends ArrayAdapter<Holiday> {

    private ArrayList<Holiday> holiday;
    private Context context;
    private TextView tvName;
    private TextView tvDate;
    private ImageView ivImage;

    public HolidayAdapter(Context context, int resource, ArrayList<Holiday> objects){
        super(context, resource, objects);
        holiday = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.holiday_row, parent, false);

        tvName = rowView.findViewById(R.id.tvHoliday);
        tvDate = rowView.findViewById(R.id.tvDate);
        ivImage = rowView.findViewById(R.id.ivHoliday);

        Holiday currentHoliday = holiday.get(position);


        tvName.setText(currentHoliday.getName());
        tvDate.setText(currentHoliday.getDate());


        String currentImage = currentHoliday.getImage();
        if (currentImage == "cny") {
            ivImage.setImageResource(R.drawable.cny);
        } else if (currentImage == "goodFriday") {
            ivImage.setImageResource(R.drawable.good_friday);
        } else if (currentImage == "labourDay") {
            ivImage.setImageResource(R.drawable.labour_day);
        } else if (currentImage == "newYear") {
            ivImage.setImageResource(R.drawable.new_year);
        }

        return rowView;
    }
}
