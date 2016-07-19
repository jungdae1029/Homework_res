package com.example.user.homeworkapplication;

import java.util.ArrayList;

/**
 * Created by user on 2016-07-15.
 */
public class Air_Data {

    public  int raw;
    public  String name;
    public ArrayList<Info_Data> if_array=new ArrayList<>();


    /*****************
     * function name :override constructor (Air_Data)
     * parameter:int raw,String name
     *Receive raw(data count),name(data kinds) and input
     *****************/
    public Air_Data(int raw,String name)
    {
        this.raw=raw;
        this.name=name;

    }

    /*****************
     * function name :Set_Data
     * parameter:Sensor data
     *Receive all kinds of Sensor data and input the Info_Data object to Info_Data ArrayList
     *****************/

    public void Set_Data(String time,String co2,String co,String so2,String no2,String pm2_5,String o3)//(int time,int co2,int co,int so2,int no2,int pm2_5,int o3)
    {

        if_array.add(new Info_Data(time,co2,co,so2,no2,pm2_5,o3));
    }

    /*****************
     * function name :Info_Data class
     *Json Parsing Data convert to Info_Data type
     *****************/

    public  class Info_Data
    {
        public  String time;
        public  String co2;
        public String co;
        public  String so2;
        public  String no2;
        public  String pm2_5;
        public String o3;

        public Info_Data(String time,String co2,String co,String so2,String no2,String pm2_5,String o3)
        {
            this.time=time;
            this.co2=co2;
            this.co=co;
            this.so2=so2;
            this.no2=no2;
            this.pm2_5=pm2_5;
            this.o3=o3;
        }
    }

}
