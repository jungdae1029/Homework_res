package com.example.user.homeworkapplication;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by user on 2016-07-16.
 */
public class CustomAdapter extends PagerAdapter {

    LayoutInflater inflater;

    public CustomAdapter(LayoutInflater inflater)
    {
        this.inflater=inflater;
    }
    @Override
    public int getCount() {

        return MainActivity.air_data.raw;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view=inflater.inflate(R.layout.fragment_air2,null);

        Set_View(view,position);
        container.addView(view);
        return view;

    }

    public void Set_View(View v,int page_num)
    {
        Air_Data air_data=MainActivity.air_data;


        TextView local=(TextView)v.findViewById(R.id.one_floor_Data1);
        local.setText(air_data.if_array.get(page_num).co);

        local=(TextView)v.findViewById(R.id.one_floor_Data2);
        local.setText(air_data.if_array.get(page_num).co2);


        local=(TextView)v.findViewById(R.id.two_floor_Data1);
        local.setText(air_data.if_array.get(page_num).no2);


        local=(TextView)v.findViewById(R.id.two_floor_Data2);
        local.setText(air_data.if_array.get(page_num).o3);


        local=(TextView)v.findViewById(R.id.three_floor_Data1);
        local.setText(air_data.if_array.get(page_num).so2);


        local=(TextView)v.findViewById(R.id.three_floor_Data2);
        local.setText(air_data.if_array.get(page_num).pm2_5);


        local=(TextView)v.findViewById(R.id.four_floor_Data2);
        local.setText(air_data.name);


        local=(TextView)v.findViewById(R.id.four_floor_Data1);
        local.setText(air_data.if_array.get(page_num).time);



    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return  view==object;
        //return false;
    }
}
