package com.br.techweekmobile.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

//Criação da entidade palestra/talk, onde esta sendo feito uma relação entre palestrante e a palestra
//se o palestrante/speaker for deletado, então o vinculo com a palestra/talk será removido
@Entity(
        tableName = "talk",
        foreignKeys = @ForeignKey(
                entity = Speaker.class,
                parentColumns = "id",
                childColumns = "speaker_id",
                onDelete = ForeignKey.SET_NULL
        ),
        indices = {@Index("speaker_id")}
)
public class Talk {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "speaker_id")
    public Integer speakerId;   //relação com speaker

    @ColumnInfo(name = "schedule") //programação
    public String schedule;

    @ColumnInfo(name = "location")
    public String location;

    @ColumnInfo(name = "is_favorite")
    public boolean isFavorite;
}
