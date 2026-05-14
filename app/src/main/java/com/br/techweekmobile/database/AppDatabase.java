package com.br.techweekmobile.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.br.techweekmobile.dao.ParticipantDao;
import com.br.techweekmobile.dao.ProjectDao;
import com.br.techweekmobile.dao.SpeakerDao;
import com.br.techweekmobile.dao.TalkDao;
import com.br.techweekmobile.dao.Checkindao;
import com.br.techweekmobile.model.Checkin;
import com.br.techweekmobile.model.Participant;
import com.br.techweekmobile.model.Project;
import com.br.techweekmobile.model.Speaker;
import com.br.techweekmobile.model.Talk;

@Database(
        entities = {
                Participant.class,
                Speaker.class,
                Talk.class,
                Checkin.class,
                Project.class
        },
        version = 2,
        exportSchema = false
)
public abstract class AppDatabase extends RoomDatabase {
    private static volatile AppDatabase instance;

    public abstract ParticipantDao participantDao();

    public abstract ProjectDao projectDao();

    public abstract SpeakerDao speakerDao();

    public abstract TalkDao talkDao();

    public abstract Checkindao checkInDao();

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            synchronized (AppDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(
                                    context.getApplicationContext(),
                                    AppDatabase.class,
                                    "techweek_db"
                            )
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return instance;
    }
}
