package com.example.fortunephiri.assignment.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface SpeakerDao {
    @Query("SELECT * FROM speakers_table")
    List<SpeakersModel> getAll();


    @Query("SELECT * FROM speakers_table WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    SpeakersModel findByName(String first, String last);

    @Insert
    void insertAll(SpeakersModel... speakers);

    @Delete
    void delete(SpeakersModel speakers);
}
