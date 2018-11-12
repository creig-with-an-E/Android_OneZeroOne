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



public class LandingPage extends AppCompatActivity {

    private String [] textLink ={"My Schedule","Speakers","Maps: Places of interest","List of Attendees",
                                    "Sponsors","Twitter"};
    private int [] imageLink ={R.drawable.calendar,R.drawable.calendar,R.drawable.calendar,R.drawable.calendar,R.drawable.calendar,R.drawable.twitter};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        ListView listView = findViewById(R.id.listview);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
//                    Intent intent = new Intent(getApplicationContext(),NewActivity.class);
//                    startActivity(intent);
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
            View view1 = getLayoutInflater().inflate(R.layout.menu_data,null);
            //getting view in row_data
            TextView name = view1.findViewById(R.id.menuItem);
            ImageView image = view1.findViewById(R.id.imageView);

            name.setText(textLink[i]);
            image.setImageResource(imageLink[i]);

            return view1;

        }
    }
}
