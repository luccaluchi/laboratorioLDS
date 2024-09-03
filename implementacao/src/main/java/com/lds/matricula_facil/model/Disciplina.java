package com.lds.matricula_facil.model;

import java.util.ArrayList;
import java.util.List;

import com.lds.matricula_facil.model.enums.Status;
import com.lds.matricula_facil.model.enums.TipoDisciplina;
import com.lds.matricula_facil.util.IdGenerator;

public class Disciplina {
    private int id = IdGenerator.generateId();
    private String nome;
    private TipoDisciplina tipo;
    private Status status;
    private List<Turma> turmas = new ArrayList<>();

    public Disciplina(String nome, TipoDisciplina tipo, Status status) {
        this.nome = nome;
        this.tipo = tipo;
        this.status = status.ATIVA;
    }

    public Turma abrirNovaTurma(Professor professor) {
        String nomeDaTurma = (this.nome + "." + turmas.size() + 1);
        Turma turma = new Turma(nomeDaTurma, professor);
        turmas.add(turma);
        return turma;
    }

    public boolean fecharTurma(int id) {
        Turma turma = getTurma(id);
        if (turma != null) {
            turma.setStatus(Status.INATIVA);
            return true;
        }
        return false;
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

    public Turma getTurma(int id) {
        return turmas.stream().filter(turma -> turma.getId() == id).findFirst().orElse(null);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Disciplina: ")
                .append(nome)
                .append("\n\tId: ").append(id)
                .append("\n\tTipo: ").append(tipo)
                .append("\n\tStatus: ").append(status)
                .append("\n\tNúmero de turmas: ").append(turmas.size());
        return sb.toString();
    }

    public Disciplina fromString(String string) {
        String[] strings = string.split(",");
        return new Disciplina(strings[1], TipoDisciplina.valueOf(strings[2]), Status.valueOf(strings[3]));
    }
}
