package com.example.fortunephiri.assignment;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import helperClasses.SharedPreferenceConfig;

public class MainActivity extends AppCompatActivity {
    SharedPreferenceConfig preferenceConfig;
    EditText username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLogin  =findViewById(R.id.btnLogin);
            btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                preferenceConfig = new SharedPreferenceConfig(getApplicationContext());
//                preferenceConfig.writeUsernamePref();
                username = findViewById(R.id.usernameTv);
                if(username.getText().toString().length() !=0){
                    Intent intent = new Intent(getApplicationContext(),LandingPage.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"Username can not be empty",Toast.LENGTH_LONG).show();
                }


            }
        });

        DatabaseHelper db = new DatabaseHelper(getApplicationContext());
        Cursor cursor = db.getData();
        Log.d("columns",String.valueOf(cursor.getColumnName(2)));


    }
}
