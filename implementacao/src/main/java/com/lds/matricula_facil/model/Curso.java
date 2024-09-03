package com.lds.matricula_facil.model;

import java.util.ArrayList;
import java.util.List;

import com.lds.matricula_facil.util.IdGenerator;

public class Curso {
    private int id = IdGenerator.generateId();
    private String nome;
    private int creditos;
    private List<Disciplina> disciplinas = new ArrayList<>();

    public Curso(String nome, int creditos) {
        this.nome = nome;
        this.creditos = creditos;
    }

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Curso: ")
                .append(nome)
                .append("\n\tId: ").append(id)
                .append("\n\tCréditos: ").append(creditos)
                .append("\n\tNúmero de disciplinas: ").append(disciplinas.size());
        return sb.toString();
    }

    public Curso fromString(String string) {
        String[] strings = string.split(",");
        return new Curso(strings[1], Integer.parseInt(strings[2]));
    }
}