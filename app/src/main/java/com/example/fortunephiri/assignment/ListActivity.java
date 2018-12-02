package com.example.fortunephiri.assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import helperClasses.SharedPreferenceConfig;

public class ListActivity extends AppCompatActivity {
    TextView name, lastname, bio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferenceConfig preferenceConfig = new SharedPreferenceConfig(getApplicationContext());
        setTitle("Schedule Assistant        *****" + preferenceConfig.readUserNamePref().toUpperCase() + "***");
        setContentView(R.layout.activity_list);
        name =findViewById(R.id.lvFirstName);
        lastname =findViewById(R.id.lvLastName);
        bio = findViewById(R.id.lvBio);
        Intent intent = getIntent();
        name.setText(intent.getStringExtra("first"));
        lastname.setText(intent.getStringExtra("last"));
        bio.setText(intent.getStringExtra("bio"));
    }
}
