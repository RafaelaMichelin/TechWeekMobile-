package com.br.techweekmobile.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.br.techweekmobile.model.Talk;

import java.util.List;

@Dao
public interface TalkDao {
    @Insert
    void insert(Talk talk);

    @Update
    void update(Talk talk);

    @Query("SELECT * FROM talk")
    LiveData<List<Talk>> getAll();

    @Query("SELECT * FROM talk WHERE id = :id")
    LiveData<Talk> getById(int id);

    @Query("SELECT * FROM talk WHERE is_favorite = 1")
    LiveData<List<Talk>> getFavorites();

    @Query("UPDATE talk SET is_favorite = :isFavorite WHERE id = :id")
    void setFavorite(int id, boolean isFavorite);
}
