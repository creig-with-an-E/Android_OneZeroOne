package com.example.fortunephiri.assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {
    TextView name, lastname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        name =findViewById(R.id.lvFirstName);
        lastname =findViewById(R.id.lvLastName);
        Intent intent = getIntent();
        name.setText(intent.getStringExtra("first"));
        lastname.setText(intent.getStringExtra("last"));
    }
}
