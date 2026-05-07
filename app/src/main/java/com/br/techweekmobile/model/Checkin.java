package com.br.techweekmobile.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
//Criação da entidade Checkin, onde esta sendo feito uma relação participante e palestra
//utilizando o cascade
@Entity(
        tableName = "checkin",
        foreignKeys = {
                @ForeignKey(
                        entity = Participant.class,
                        parentColumns = "id",
                        childColumns = "participant_id",
                        onDelete = ForeignKey.CASCADE
                ),
                @ForeignKey(
                        entity = Talk.class,
                        parentColumns = "id",
                        childColumns = "talk_id",
                        onDelete = ForeignKey.CASCADE
                )
        },
        indices = {@Index("participant_id"), @Index("talk_id")}
)

public class Checkin {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "participant_id")
    public int participantId; // relação com participante

    @ColumnInfo(name = "talk_id")
    public int talkId; //relação com a palestra

    @ColumnInfo(name = "timestamp")
    public long timestamp;

}
