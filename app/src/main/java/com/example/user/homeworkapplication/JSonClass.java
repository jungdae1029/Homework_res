package com.example.user.homeworkapplication;

import android.app.Activity;
import android.content.res.AssetManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;



public class JSonClass extends Activity{

    Activity main;


    /*****************
     * function name :constructor
     * parameter:Activity
     *Receive the Activity and Set Activity because using getAsset()
     *****************/

    public JSonClass(Activity main)
    {

        this.main=main;
    }


    /*****************
     * function name :loadJSONFromAsset
     * parameter:String file_name
     *Using getAssets method get the InputStream data and Convert to String Data and Return String
     *****************/

    public String loadJSONFromAsset(String file_location) { //Load Json
        String json;
        try {
            /* Using getAssets get the Json Data*/
            InputStream is =main.getAssets().open(file_location);
            int size=is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }


    /*****************
     * function name :JsonParse
     * parameter:Json turned into A string
     *Using String  Convert to Air_Data(object) input  Json Data To Air_Data object
     *****************/


    public Air_Data JSonParse(String Json)
    {
        Air_Data air=null;
        try {
              /*Get the Json's information total count , sensor name, data*/
            JSONObject obj=new JSONObject(Json).getJSONObject("sensorData");
            int row=Integer.parseInt(obj.getString("totalRows"));
            String name=new JSONObject(Json).getJSONObject("sensorInfo").getString("name");
            JSONArray j_array=obj.getJSONArray("dataArray");
            air=new Air_Data(row,name);
            for(int i=0;i<row;i++)
            {
                air.Set_Data(j_array.getJSONObject(i).getString("time"),
                        j_array.getJSONObject(i).getString("co2"),
                        j_array.getJSONObject(i).getString("co"),
                        j_array.getJSONObject(i).getString("so2"),
                        j_array.getJSONObject(i).getString("no2"),
                        j_array.getJSONObject(i).getString("pm2.5"),
                        j_array.getJSONObject(i).getString("o3")
                );

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return air;

    }

    public void Get_Asset_List()
    {
        AssetManager am=main.getAssets();
        try {
            String s []=am.list(".json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
