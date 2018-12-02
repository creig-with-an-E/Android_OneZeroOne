package com.example.fortunephiri.assignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import helperClasses.SharedPreferenceConfig;

public class ListAttendeesActivity extends AppCompatActivity {
    SharedPreferenceConfig preferenceConfig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferenceConfig = new SharedPreferenceConfig(getApplicationContext());
        setTitle("Schedule Assistant        *****" + preferenceConfig.readUserNamePref().toUpperCase() + "***");
        setContentView(R.layout.activity_list_attendees);
    }
}
