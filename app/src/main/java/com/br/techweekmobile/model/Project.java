package com.br.techweekmobile.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

//Criação da entidade Project, onde esta sendo feito uma relação participante
@Entity(
        tableName = "project",
        foreignKeys = @ForeignKey(
                entity = Participant.class,
                parentColumns = "id",
                childColumns = "participant_id",
                onDelete = ForeignKey.CASCADE
        ),
        indices = {@Index("participant_id")}
)
public class Project {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "description")
    public String description;

    @ColumnInfo(name = "participant_id")
    public int participantId;
}
