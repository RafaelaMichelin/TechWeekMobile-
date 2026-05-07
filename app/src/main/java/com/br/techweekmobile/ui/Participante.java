package com.br.techweekmobile.ui;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "participante",
        indices = {@Index(value = {"ra"}, unique = true)}
)
public class Participante {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "nome")
    private String nome;

    @ColumnInfo(name = "ra")
    private String ra;

    @ColumnInfo(name = "curso")
    private String curso;

    @ColumnInfo(name = "serie")
    private String serie;

    @ColumnInfo(name = "coffee_break")
    private boolean coffeeBreak;

    // --- Getters e Setters ---

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getRa() { return ra; }
    public void setRa(String ra) { this.ra = ra; }

    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }

    public String getSerie() { return serie; }
    public void setSerie(String serie) { this.serie = serie; }

    public boolean isCoffeeBreak() { return coffeeBreak; }
    public void setCoffeeBreak(boolean coffeeBreak) { this.coffeeBreak = coffeeBreak; }
}