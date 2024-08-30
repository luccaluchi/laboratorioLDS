package com.lds.matricula_facil.model;

import com.lds.matricula_facil.model.enums.Status;
import com.lds.matricula_facil.util.IdGenerator;

public class Turma {
    
    private int id = IdGenerator.generateId();
    private String nome;
    private Status status = Status.ATIVA;
    private Professor professor;
    private Aluno[] alunos = new Aluno[60];

    public Turma(String nome, Professor professor) {
        this.nome = nome;
        this.professor = professor;
    }

    //TODO: Os alunos podem se matricular em 4 disciplinas como 1ª opção (obrigatórias) e em mais 2 outras alternativas (optativas).
    public boolean matricularAluno(Aluno aluno){
        if (estaCheia())
        {
            return false;
        }
        else
        {
            for (int i = 0; i < alunos.length; i++)
            {
                if (alunos[i] == null)
                {
                    alunos[i] = aluno;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean desmatricularAluno(Aluno aluno){
        for (int i = 0; i < alunos.length; i++)
        {
            if (alunos[i] == aluno)
            {
                alunos[i] = null;
                return true;
            }
        }
        return false;
    }

    private boolean estaCheia(){
        int count = 0;
        for (int i = 0; i < alunos.length; i++)
        {
            if (alunos[i] != null)
            {
                count++;
            }
        }
        return (count < 60) ? false : true;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
}

