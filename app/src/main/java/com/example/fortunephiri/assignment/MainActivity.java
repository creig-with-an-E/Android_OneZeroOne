package com.example.fortunephiri.assignment;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import helperClasses.SharedPreferenceConfig;

public class MainActivity extends AppCompatActivity {
    SharedPreferenceConfig preferenceConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLogin  =findViewById(R.id.btnLogin);
            btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),LandingPage.class);
                startActivity(intent);

            }
        });
            DatabaseHelper db = new DatabaseHelper(getApplicationContext());
            Cursor cursor = db.getData();
            Log.d("columns",String.valueOf(cursor.getColumnName(2)));


    }
}
