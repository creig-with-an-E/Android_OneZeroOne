package com.example.fortunephiri.assignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class SurveyActivity extends AppCompatActivity {
    EditText q1, q2,q3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        q1 = findViewById(R.id.question1);
        q2 = findViewById(R.id.question2);
        q3 = findViewById(R.id.question3);

    }

    public void save(View view) {
        String data =  q1.getText().toString() + "\n";
               data += q3.getText().toString() + "\n";
               data += q2.getText().toString() + "\n";

        final String FILE_NAME = "survey.txt";
        FileOutputStream fos =null;
        try {
            fos = openFileOutput(FILE_NAME,MODE_PRIVATE);
            fos.write(data.getBytes());
            q1.getText().clear();
            q2.getText().clear();
            q3.getText().clear();

            Toast.makeText(this,"survey submitted",Toast.LENGTH_LONG).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}