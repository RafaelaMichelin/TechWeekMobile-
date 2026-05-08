package com.br.techweekmobile.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.br.techweekmobile.model.Project;

import java.util.List;

@Dao
public interface ProjectDao {
    @Insert
    void insert(Project project);

    @Update
    void update(Project project);

    @Delete
    void delete(Project project);

    @Query("SELECT * FROM project")
    LiveData<List<Project>> getAll();

    @Query("SELECT * FROM project WHERE participant_id = :participantId")
    LiveData<List<Project>> getByParticipant(long participantId);
}
