package com.example.fortunephiri.assignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SpeakersActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speakers);

        databaseHelper.onCreate();
    }
}
