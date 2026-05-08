package com.br.techweekmobile.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.br.techweekmobile.model.Checkin;

import java.util.List;

@Dao
public interface CheckInDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Checkin checkin);

    @Query("SELECT * FROM checkin WHERE participant_id = :participantId ORDER BY timestamp DESC LIMIT 1")
    Checkin findLatestByParticipantId(long participantId);

    @Query("SELECT * FROM checkin WHERE participant_id = :participantId LIMIT 1")
    Checkin findAnyByParticipantId(long participantId);

    @Query("SELECT * FROM checkin ORDER BY timestamp DESC")
    List<Checkin> listAll();

    @Query("DELETE FROM checkin WHERE participant_id = :participantId")
    void deleteByParticipantId(long participantId);

    @Query("SELECT COUNT(*) FROM checkin")
    int countTotal();
}
