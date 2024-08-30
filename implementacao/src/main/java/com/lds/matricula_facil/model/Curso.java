package com.lds.matricula_facil.model;

import java.util.List;

import com.lds.matricula_facil.util.idGenerator;

public class Curso {
    private int id = idGenerator.generateId();
    private String nome;
    private int creditos;
    private List<Disciplina> disciplinas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
}