package com.example.fortunephiri.assignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import helperClasses.SharedPreferenceConfig;

public class MyScheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferenceConfig preferenceConfig = new SharedPreferenceConfig(getApplicationContext());
        setTitle("Schedule Assistant        *****" + preferenceConfig.readUserNamePref().toUpperCase() + "***");
        setContentView(R.layout.activity_my_schedule);
    }
}
