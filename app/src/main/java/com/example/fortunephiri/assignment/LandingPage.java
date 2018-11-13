package com.example.fortunephiri.assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class LandingPage extends AppCompatActivity {

    private ArrayList<String> textLink = new ArrayList <String>() ;
    private int [] imageLink ={R.drawable.calendar,R.drawable.calendar,R.drawable.calendar,R.drawable.calendar,R.drawable.calendar,R.drawable.calendar,R.drawable.twitter};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
        //creating the list
        textLink.add("General Schedule");                //index:0 ->General Schedule
        textLink.add("My Schedule");                     //index:1  ->My Schedule
        textLink.add("Speakers");                       //index:2  ->Speakers
        textLink.add("Maps: Places of interest");       //index:3  ->Maps
        textLink.add("List of attendees");              //index:4  ->List attendees
        textLink.add("Sponsors");                       //index:5  ->Sponsors
        textLink.add("Twitter");                        //index:6  ->twitter




        ListView listView = findViewById(R.id.listview);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0:
                        Intent intentGSchedule = new Intent(getApplicationContext(),MyScheduleActivity.class);
                        startActivity(intentGSchedule); //handles General schedule intent
                    case 1:
                        Intent intentMySch = new Intent(getApplicationContext(),MyScheduleActivity.class);
                        startActivity(intentMySch);     //starting My Schedule intent
                        break;
                    default:
                        break;
                }
            }
        });
         }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return imageLink.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            //fills the list(menu) with the ArrayList data
            View view1 = getLayoutInflater().inflate(R.layout.menu_data,null);
            //getting view in row_data
            TextView name = view1.findViewById(R.id.menuItem);
            ImageView image = view1.findViewById(R.id.imageView);

            name.setText(textLink.get(i));
            image.setImageResource(imageLink[i]);

            return view1;

        }
    }
}
