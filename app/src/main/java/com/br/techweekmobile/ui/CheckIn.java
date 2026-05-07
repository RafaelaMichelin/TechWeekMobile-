package com.br.techweekmobile.ui;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.br.techweekmobile.model.Participant;

@Entity(
        tableName = "checkin",
        foreignKeys = @ForeignKey(
                entity = Participant.class,
                parentColumns = "id",
                childColumns = "participante_id",
                onDelete = ForeignKey.CASCADE
        )
)
public class CheckIn {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "participante_id", index = true)
    private long participanteId;

    @ColumnInfo(name = "timestamp")
    private long timestamp;


    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public long getParticipanteId() { return participanteId; }
    public void setParticipanteId(long participanteId) { this.participanteId = participanteId; }

    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }
}