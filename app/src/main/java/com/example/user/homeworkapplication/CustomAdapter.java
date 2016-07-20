package com.example.user.homeworkapplication;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 2016-07-16.
 */
public class CustomAdapter extends PagerAdapter {

    LayoutInflater inflater;
    View view;
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

      view=inflater.inflate(R.layout.fragment_air_,null);

        Set_View(view,position);
        container.addView(view);
        return view;

    }
    private final Handler rHandler=new Handler(){

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what)
            {
                case 1:
                {
                    break;
                }
            }
            super.handleMessage(msg);
        }
    };
    public void Set_View2(ArrayList<String> array)
    {

        // 100을 기준
        //0~33 이면 초록 34~66이면 노랑 67~100이면 빨강
        //        80E12A          FAEB78          CD1F48
        //HR CO CO2 NO2 O3 SO2 PM2_5 TIME  NAME
        LinearLayout linear=(LinearLayout)view.findViewById(R.id.one_floor_Linear);
        TextView local=(TextView)view.findViewById(R.id.one_floor_Data1);
        set_background(array.get(0),local,linear);

        //local.setText(set_background(Integer.valueOf(array.get(0))));


        local=(TextView)view.findViewById(R.id.one_floor_Data2);
        linear=(LinearLayout)view.findViewById(R.id.one_floor_Linear1);
        set_background(array.get(1),local,linear);

        local=(TextView)view.findViewById(R.id.two_floor_Data1);
        linear=(LinearLayout)view.findViewById(R.id.two_floor_Linear1);
        set_background(array.get(2),local,linear);

        local=(TextView)view.findViewById(R.id.two_floor_Data2);
        linear=(LinearLayout)view.findViewById(R.id.two_floor_Linear2);
        set_background(array.get(3),local,linear);


        local=(TextView)view.findViewById(R.id.three_floor_Data1);
        linear=(LinearLayout)view.findViewById(R.id.three_floor_Linear1);
        set_background(array.get(4),local,linear);

        local=(TextView)view.findViewById(R.id.three_floor_Data2);
        linear=(LinearLayout)view.findViewById(R.id.three_floor_Linear2);
        set_background(array.get(5),local,linear);

        local=(TextView)view.findViewById(R.id.zero_floor_Data1);

        linear=(LinearLayout)view.findViewById(R.id.zero_floor_Linear);
        set_background(array.get(6),local,linear);



    }
    public void set_background(String s,TextView local,LinearLayout linear)
    {
        //80E12A          FAEB78          CD1F48
        local.setText(s);
        int i=Integer.valueOf(s);
        if(i>0&&i<33)
        {
            //local.setBackgroundColor(R.color.red);
            //local.setBackgroundColor(get);
            //local.setBackgroundColor(Color.green());
            //local.setBackground(Drawable.createFromPath("#80E12A"));
            //local.setBackgroundColor(80E12);
            //local.setBackgroundColor(Color.parseColor("#80E12A"));
            local.setBackgroundColor(Color.parseColor("#5EC75E"));
            linear.setBackgroundColor(Color.parseColor("#5EC75E"));

        }
        else if (34<i&&i<66)
        {
            //local.setBackground(Drawable.createFromPath("#FAEB78"));
            //local.setBackgroundColor(Color.parseColor("#FAEB78"));
            local.setBackgroundColor(Color.parseColor("#FFAF0A"));
            linear.setBackgroundColor(Color.parseColor("#FFAF0A"));
        }
        else if (66<i&&i<101)
        {
            //local.setBackground(Drawable.createFromPath("#CD1F48"));
            //local.setBackgroundColor(Color.parseColor("#CD1F48"));
            local.setBackgroundColor(Color.parseColor("#CD3C3C"));
            linear.setBackgroundColor(Color.parseColor("#CD3C3C"));
        }

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


        /*local=(TextView)v.findViewById(R.id.four_floor_Data2);
        local.setText(air_data.name);


        local=(TextView)v.findViewById(R.id.four_floor_Data1);
        local.setText(air_data.if_array.get(page_num).time);
        */


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
