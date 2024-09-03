package com.lds.matricula_facil.model;

import java.util.ArrayList;
import java.util.List;

import com.lds.matricula_facil.util.IdGenerator;

public class Curriculo {
    private int id = IdGenerator.generateId();
    private int ano;
    private int semestre;
    private List<Turma> turmas = new ArrayList<>();

    public Curriculo(int ano, int semestre) {
        this.ano = ano;
        this.semestre = semestre;
    }

    public int getId() {
        return id;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public int getSemestre() {
        return semestre;
    }
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
    public List<Turma> getTurmas() {
        return turmas;
    }
    public void addTurma(Turma turma) {
        this.turmas.add(turma);
    }
    public void removeTurma(Turma turma) {
        this.turmas.remove(turma);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Curriculo: ")
                .append(ano)
                .append("/")
                .append(semestre)
                .append("\n\tId: ").append(id)
                .append("\n\tNúmero de turmas: ").append(turmas.size());
        return sb.toString();
    }

    public Curriculo fromString(String string) {
        String[] strings = string.split(",");
        return new Curriculo(Integer.parseInt(strings[1]), Integer.parseInt(strings[2]));
    }

}
