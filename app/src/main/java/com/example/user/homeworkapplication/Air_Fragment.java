package com.example.user.homeworkapplication;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by user on 2016-07-15.
 */
public class Air_Fragment extends Fragment {

    public View view;
    public Air_Fragment()
    {

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.fragment_air_, container, false);
        return view;

    }

}
