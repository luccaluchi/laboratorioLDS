package com.lds.matricula_facil.model;

import java.util.List;

import com.lds.matricula_facil.model.enums.Status;
import com.lds.matricula_facil.model.enums.TipoDisciplina;
import com.lds.matricula_facil.util.IdGenerator;

public class Disciplina {
    private int id = IdGenerator.generateId();
    private String nome;
    private TipoDisciplina tipo;
    private Status status;
    private List<Turma> turmas;

    public Disciplina(String nome, TipoDisciplina tipo, Status status) {
        this.nome = nome;
        this.tipo = tipo;
        this.status = status;
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

    public TipoDisciplina getTipo() {
        return tipo;
    }

    public void setTipo(TipoDisciplina tipo) {
        this.tipo = tipo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public void encerrarMatriculas() {
        // fazer!!
    }

    public void cancelarMatriculas() {
        // fazer!!
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Disciplina:")
          .append("\tId: ").append(id)
          .append("\n\tNome: ").append(nome)
          .append("\n\tTipo: ").append(tipo)
          .append("\n\tStatus: ").append(status);
        return sb.toString();
    }
    
}
