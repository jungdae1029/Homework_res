package com.example.user.homeworkapplication;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //Variable
    public static Air_Data air_data; //Global Variable Parsing Json Data Save this Variable
    ViewPager pager; //ViewPager Variable
    JSonClass jc; //JSonClass Variable


    /*****************
     * function name :
     * paramater
     *
     * ************8*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Assignment Variable
        jc=new JSonClass(this); // Create JSonClass object parameter this Activity
        String s_Json=jc.loadJSONFromAsset("sensordata.json"); //Parsing Json And Save to String  parameter Json File name
        air_data=jc.JSonParse(s_Json); //String Data to Convert Air_Data object

        //Viewpager Set
        pager=(ViewPager)findViewById(R.id.pager); //Assignment Value Set
        pager.setAdapter(new CustomAdapter(getLayoutInflater())); //Set CustomAdapter parameter LayoutInflater
        pager.setCurrentItem(0); //Viewpager 1 page Set

    }



}
