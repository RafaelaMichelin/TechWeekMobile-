package com.br.techweekmobile.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.br.techweekmobile.model.Speaker;

import java.util.List;

@Dao
public interface SpeakerDao {
    @Insert
    void insert(Speaker speaker);
    @Query("SELECT * FROM speaker")
    LiveData<List<Speaker>> getAll();


}
