package com.example.user.homeworkapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;

import java.util.ArrayList;

/**
 * Created by user on 2016-07-19.
 */
public class Test_Service extends Service {
    Handler re_handle;
    Air_Data air_data=MainActivity.air_data;
    public Test_Service(Handler re_handle) {
        this.re_handle=re_handle;
        //Send_msg(new Bundle());
        randomThread randomThread=new randomThread();
        randomThread.start();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public void Send_msg(Bundle bundle)
    {
        Message msg = new Message() ;
        msg.setData(bundle);
        re_handle.sendMessage(msg);
     //   random_array.clear();

    }

    ArrayList<String> random_array=new ArrayList<>();
    class randomThread extends Thread{


        int x=0,y=66,z=99;
        @Override
        public void run() {
            super.run();

            try{
                while(true) {
                    //HR CO CO2 NO2 O3 SO2 PM2_5 TIME  NAME
                    Thread.sleep(1000);
                    for(int i=0;i<7;i++)
                    {
                        //random_array.add(i,String.valueOf((int) (Math.random() * 100)));
                        if(i%3==0)
                        {
                            random_array.add(i,String.valueOf(x++));
                        }
                        else if(i%3==1)
                        {
                            random_array.add(i,String.valueOf(y++));

                        }
                        else if(i%3==2)
                        {
                            random_array.add(i,String.valueOf(z++));

                        }
                    }
                    if(x>100)
                    {
                        x=0;
                    }
                    if(y>100)
                    {
                        y=0;
                    }
                    if(z>100)
                    {
                        z=0;
                    }
                    Bundle bundle=new Bundle();
                    //bundle.putInt("");
                    bundle.putStringArrayList("data",random_array);
                    Send_msg(bundle);


                }
            }catch (Exception e)
            {

            }
        }
    }

    public void random_pass()
    {
        Message msg=new Message();
        Bundle msg_Bundle=new Bundle();

       // msg_Bundle.putInt();
        //re_handle.sendMessage();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
