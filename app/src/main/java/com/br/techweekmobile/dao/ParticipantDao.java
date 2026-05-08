package com.br.techweekmobile.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.br.techweekmobile.model.Participant;

import java.util.List;

@Dao
public interface ParticipantDao {

    @Insert
    void insert(Participant participant);

    @Update
    void update(Participant participant);

    @Delete
    void delete(Participant participant);

    @Query("SELECT * FROM participant")
    LiveData<List<Participant>> getAll();

    @Query("SELECT * FROM participant WHERE ra = :ra LIMIT 1")
    Participant findByRa(String ra);

    @Query("SELECT * FROM participant WHERE coffee_break = 1")
    List<Participant> getCoffeeBreakParticipants();
}
