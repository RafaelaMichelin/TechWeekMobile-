package com.br.techweekmobile.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.br.techweekmobile.ui.CheckIn;

import java.util.List;

@Dao
public interface Checkindao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void inserir(CheckIn checkIn);

    @Query("SELECT * FROM checkin WHERE participant_id = :participanteId LIMIT 1")
    CheckIn buscarPorParticipanteId(long participanteId);

    @Query("SELECT * FROM checkin ORDER BY timestamp DESC")
    List<CheckIn> listarTodos();

    @Query("DELETE FROM checkin WHERE participant_id = :participanteId")
    void deletarPorParticipante(long participanteId);

    @Query("SELECT COUNT(*) FROM checkin")
    int totalCheckIns();
}