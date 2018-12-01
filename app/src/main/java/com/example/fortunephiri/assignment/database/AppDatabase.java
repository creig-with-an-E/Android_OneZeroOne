package com.example.fortunephiri.assignment.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {SpeakersModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract SpeakerDao speakerDao();

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "user-database")
                            // allow queries on the main thread.
                            // Don't do this on a real app! See PersistenceBasicSample for an example.
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    private static SpeakersModel addSpeaker(final AppDatabase db, SpeakersModel user) {
        db.speakerDao().insertAll(user);
        return user;
    }

    private static void populateWithTestData(AppDatabase db) {
        SpeakersModel speaker = new SpeakersModel();
        speaker.setFirst_name("Ajay");
        speaker.setLast_name("Saini");
        speaker.setAffiliations("George brown");
        addSpeaker(db, speaker);
    }
}