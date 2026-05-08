package com.br.techweekmobile.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "checkin",
        foreignKeys = @ForeignKey(
                entity = Participant.class,
                parentColumns = "id",
                childColumns = "participant_id",
                onDelete = ForeignKey.CASCADE
        ),
        indices = {@Index("participant_id"), @Index(value = "talk_id")}
)
public class Checkin {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "participant_id")
    private long participantId;

    /** Opcional: vínculo com palestra quando existir registro em {@link Talk}. */
    @ColumnInfo(name = "talk_id")
    private Integer talkId;

    @ColumnInfo(name = "timestamp")
    private long timestamp;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getParticipantId() {
        return participantId;
    }

    public void setParticipantId(long participantId) {
        this.participantId = participantId;
    }

    public Integer getTalkId() {
        return talkId;
    }

    public void setTalkId(Integer talkId) {
        this.talkId = talkId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
