package com.example.fortunephiri.assignment;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class SpeakersActivity extends AppCompatActivity {

    ListView listview;
    String [] firstnames = new String[6];
    String [] lastnames = new String[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speakers);
        listview = findViewById(R.id.SpeakerlistView);


        DatabaseHelper db  = new DatabaseHelper(getApplicationContext());
        Cursor cursor =db.getData();
        int counter =0;
        if (cursor.moveToFirst()){
            do{
                String fn = cursor.getString(cursor.getColumnIndex("firstname"));
                String ln = cursor.getString(cursor.getColumnIndex("lastname"));
                firstnames[counter] = fn;
                lastnames[counter] =ln;
                Log.d("names",firstnames[counter]);
                counter++;
            }while(cursor.moveToNext());
        }

        cursor.close();

        CustomAdapter customAdapter = new CustomAdapter();
            listview.setAdapter(customAdapter);
            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent =new Intent(getApplicationContext(),ListActivity.class);
                intent.putExtra("first",firstnames[position]);
                intent.putExtra("last",lastnames[position]);

                startActivity(intent);
            }
        });

    }

    private class CustomAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return firstnames.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view =getLayoutInflater().inflate(R.layout.new_data, null);
            TextView name =view.findViewById(R.id.firstname);
            TextView last = view.findViewById(R.id.lastname);
            name.setText(firstnames[position]);
            last.setText(lastnames[position]);
            return view;
        }
    }
}