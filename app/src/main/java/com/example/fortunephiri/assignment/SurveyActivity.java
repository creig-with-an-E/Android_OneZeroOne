package com.example.fortunephiri.assignment;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import java.io.OutputStreamWriter;
import java.util.logging.Logger;

public class SurveyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

    findViewById(R.id.btnSurvey).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String data ="this is data";
            try{
                OutputStreamWriter streamWriter = new OutputStreamWriter(getApplicationContext().openFileOutput("survey.txt", Context.MODE_PRIVATE));
                streamWriter.write(data);
                Log.d("Working","this was written");
                streamWriter.close();
            }catch (Exception e){
                Log.d("Working","error occurred");
                e.printStackTrace();
            }

        }
    });
    }
}