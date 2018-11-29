package com.example.fortunephiri.assignment;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "DatabaseHelper";

    //database cols
    private static final String id ="idCol";
    private static final String firstnameCol ="firstname";
    private static final String lastnameCol ="lastname";
    private static final String tableName ="Speakers";
    private static final String affiliationCol = "Affiliation";
    private static final String email ="email";
    private static final String bio = "bio";

    public DatabaseHelper(Context context){
        super(context, tableName,null,1);
        Log.d("mina","database constructor");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("mina","onCreate database method call");
        String createTable ="Create table if not exists " + tableName + " (id Integer primary key autoincrement ," +
                firstnameCol + " Text ," + lastnameCol + "Text ," + affiliationCol + " Text ," +
                email + " Text, " + bio + " Text )";
        dropTable();
        db.execSQL(createTable);
        db.execSQL(String.format("insert into %s values('Sam','Smith','UNICEF','email@gmail.com','lead practitioner')", tableName));
        db.execSQL(String.format("insert into %s values('Lisa','Vio','UNICEF','eml@gmail.com','practitioner')", tableName));
        db.execSQL(String.format("insert into %s values('Creig','Phiri','Canker Corp','fortunephiri@gmail.com','Entreprenuer')", tableName));
        db.execSQL(String.format("insert into %s values('Omie','Mdlo','Diaman Corp','email@gmail.com','Gemologist')", tableName));
        db.execSQL(String.format("insert into %s values('Some','One','UNICEF','email@gmail.com','lead practitioner')", tableName));
        db.execSQL(String.format("insert into %s values('John','Doe','UNICEF','email@gmail.com','lead practitioner')", tableName));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Cursor getData(){
        //returns a cursor object with all the data
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "Select * from " + tableName;
        Cursor data = db.rawQuery(query,null);
        Log.d("data",data.toString());

        return data;
    }

    public void dropTable(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("drop table if exists " + tableName);
        Log.i("DropTable","Table was dropped ekse");
    }



}
