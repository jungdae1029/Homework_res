package com.example.user.homeworkapplication;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    //Variable
    public static Air_Data air_data; //Global Variable Parsing Json Data Save this Variable
    ViewPager pager; //ViewPager Variable
    JSonClass jc; //JSonClass Variable
    //Vertical_Viewpager vertical_viewpager;
    ViewPager viewPager;
    Vertical_Viewpager v_viewpager;
    CustomAdapter adapter;
    /*****************
     * function name :
     * paramater
     *
     * ************8*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        //Assignment Variable
        jc=new JSonClass(this); // Create JSonClass object parameter this Activity
        String s_Json=jc.loadJSONFromAsset("sensordata.json"); //Parsing Json And Save to String  parameter Json File name
        air_data=jc.JSonParse(s_Json); //String Data to Convert Air_Data object


        v_viewpager=new Vertical_Viewpager(getApplicationContext());
        v_viewpager=(Vertical_Viewpager)findViewById(R.id.pager);
        adapter=new CustomAdapter(getLayoutInflater());
        v_viewpager.setAdapter(adapter);
        v_viewpager.setCurrentItem(0);

        Test_Service service=new Test_Service(rHandler);


        /*
        pager=(ViewPager)findViewById(R.id.pager);

        pager.setAdapter(new CustomAdapter(getLayoutInflater())); //Set CustomAdapter parameter LayoutInflater
        pager.setCurrentItem(0); //Viewpager 1 page Set
        */


    }
    private final Handler rHandler=new Handler(){

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what)
            {
                case 0:
                {
                    //((TextView)getLayoutInflater().inflate(R.layout.fragment_air_,null).findViewById(R.id.one_floor_Data1)).setText("asfzx");
                    //adapter.Set_View2(msg.getData().getInt("data"));
                    adapter.Set_View2(msg.getData().getStringArrayList("data"));
                    break;
                }
            }
            super.handleMessage(msg);
        }
    };



}
