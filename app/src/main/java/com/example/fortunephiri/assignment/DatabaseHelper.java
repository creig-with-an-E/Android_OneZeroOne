package com.example.fortunephiri.assignment;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "DatabaseHelper";

    //database cols
    private static final String id ="idCol";
    private static final String firstnameCol ="firstname";
    private static final String lastnameCol ="lastnameCol";
    private static final String tableName ="Speakers";
    private static final String affiliationCol = "Affiliation";
    private static final String email ="email";
    private static final String bio = "bio";

    public DatabaseHelper(Context context){
        super(context, tableName,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable ="Create table if not exists " + tableName + " (id Integer primary key autoincrement ," +
                firstnameCol + " Text ," + lastnameCol + "Text ," + affiliationCol + " Text ," +
                email + " Text, " + bio + " Text )";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Cursor getData(){
        //returns a cursor object with all the data
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "Select * from " + tableName;
        Cursor data = db.rawQuery(query,null);
        return data;

    }
}
