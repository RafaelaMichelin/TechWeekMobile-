package com.br.techweekmobile.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.br.techweekmobile.model.Participant;
import com.br.techweekmobile.model.Speaker;

import java.util.List;

@Dao
public interface ParticipantDao {
    //Inserir um participante no Banco
    @Insert
    void insert(Participant participant);

    @Update
    void update(Participant participant);

    @Delete
    void delete(Participant participant);

    //Busca todos os registros da tabela participant
    @Query("SELECT * FROM participant")
    LiveData<List<Participant>> getAll();



}

