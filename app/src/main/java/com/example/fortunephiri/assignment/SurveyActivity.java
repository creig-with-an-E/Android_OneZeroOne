package com.example.fortunephiri.assignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import java.text.SimpleDateFormat;
import java.util.Date;


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
//        StringBuilder data= new StringBuilder();
        String timestamp=new SimpleDateFormat("yyyy-MM-dd.HH:mm:ss").format(new Date());
//        data.append(timestamp);
//               data.append(q1.getText().toString() + "\n");
//               data.append(q2.getText().toString() + "\n");
//               data.append(q3.getText().toString() + "\n");


        final String FILE_NAME = "survey.txt";
        OutputStream fos =null;
        MyJSON newJson = new MyJSON();
        try {
            JSONObject data=newJson.makeJSON(timestamp,q1.getText().toString(),q2.getText().toString(),q3.getText().toString());
            fos = openFileOutput(FILE_NAME,MODE_PRIVATE);
            fos.write(data.toString().getBytes());

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

    public class MyJSON extends JSONObject {

        public JSONObject makeJSON(String timeStamp, String q1, String q2, String q3){
            JSONObject json = new JSONObject();
            try {
                json.put("timestamp",timeStamp);
                json.put("question1",q1);
                json.put("question2",q2);
                json.put("question3",q3);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Log.d("json",json.toString());
            return json;
        }

    }
}
