package com.example.fortunephiri.assignment.database;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import io.reactivex.annotations.NonNull;

@Entity(tableName = "Speakers_table")
public class SpeakersModel {

    @PrimaryKey
    @NonNull
    private  int id ;

    private String first_name;
    private String last_name;
    private String affiliations;
    private String email;
    private String bio;

    public SpeakersModel(){};
    public SpeakersModel(int id, String first_name, String last_name, String affiliations, String email, String bio) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.affiliations = affiliations;
        this.email = email;
        this.bio = bio;
    }

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getAffiliations() {
        return affiliations;
    }

    public String getEmail() {
        return email;
    }

    public String getBio() {
        return bio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setAffiliations(String affiliations) {
        this.affiliations = affiliations;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
