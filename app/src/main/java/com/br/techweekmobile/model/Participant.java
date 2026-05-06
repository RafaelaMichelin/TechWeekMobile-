package com.br.techweekmobile.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Participant {

    //Primary Key
    @PrimaryKey(autoGenerate = true)
    private int id;
    //ColumnInfo para nomear no banco
    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "ra")
    public String ra;

    @ColumnInfo(name = "course")
    public String course;

    @ColumnInfo(name = "semester")
    public int semester;

    @ColumnInfo(name = "participanteCoffe")
    public boolean participanteCoffe;

}
