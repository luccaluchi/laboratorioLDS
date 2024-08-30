package com.lds.matricula_facil.model;

import java.util.List;

import com.lds.matricula_facil.util.IdGenerator;

public class Curriculo {
    private int id = IdGenerator.generateId();
    private int ano;
    private int semestre;
    private List<Turma> turmas;

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

}
