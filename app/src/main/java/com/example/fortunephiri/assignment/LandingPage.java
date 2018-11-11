package com.example.fortunephiri.assignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;

import java.util.ArrayList;

public class LandingPage extends AppCompatActivity {

    private ArrayList <String> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
    }
}
