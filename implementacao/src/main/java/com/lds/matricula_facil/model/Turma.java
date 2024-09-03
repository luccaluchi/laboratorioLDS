package com.lds.matricula_facil.model;

import com.lds.matricula_facil.model.enums.Status;
import com.lds.matricula_facil.model.enums.TipoDisciplina;
import com.lds.matricula_facil.util.IdGenerator;
import com.lds.matricula_facil.util.Persistence;
import com.lds.matricula_facil.util.Utils;

import java.util.Scanner;

import java.util.ArrayList;

public class Turma {
    
    private int id = IdGenerator.generateId();
    private String nome;
    private Status status = Status.ATIVA;
    private Professor professor;
    private ArrayList<Aluno> alunos = new ArrayList<>();
    private Utils utils = new Utils();
    private Persistence persistence = Persistence.getInstance();
    Scanner scanner = new Scanner(System.in);
    
    public Turma(String nome, Professor professor) {
        this.nome = nome;
        this.professor = professor;
    }
    
    //TODO: Os alunos podem se matricular em 4 disciplinas como 1ª opção (obrigatórias) e em mais 2 outras alternativas (optativas).
    public boolean matricularAluno(Aluno aluno) {
        if (alunos.contains(aluno)) {
            System.out.println("Aluno já matriculado!");
            return false;
        }
        if (estaCheia()) {
            System.out.println("Turma cheia!");
            return false;
        }        
        if (numeroDisciplinasObrigatoriasMatriculado(aluno) >= 4) {
            System.out.println("Limite de disciplinas obrigatórias atingido!");
            return false;
        }        
        if (numeroDisciplinasOptativaMatriculado(aluno) >= 2) {
            System.out.println("Limite de disciplinas optativas atingido!");
            return false;
        }
        alunos.add(aluno);
        return true;     
    }
    
    public boolean cancelarMatricularAluno(Aluno aluno) {
        if (alunos.contains(aluno)) {
            alunos.remove(aluno);
            return true;
        }
        System.out.println("Aluno não matriculado nesta turma!");
        return false;
    }
    
    public int numeroDisciplinasObrigatoriasMatriculado(Aluno aluno){
        int numeroDisciplinasObrigatoriasMatriculado = 0;
        for (Disciplina disciplina : Persistence.getInstance().getDisciplinas().stream().filter(disciplina -> disciplina.getStatus() == Status.ATIVA && disciplina.getTipo() == TipoDisciplina.OBRIGATORIA).toList()) {
            for (Turma turma : disciplina.getTurmas().stream().filter(turma -> turma.getStatus() == Status.ATIVA).toList()) {
                for (Aluno alunoFromTurma : turma.getAlunos()) {
                    if (aluno.equals(alunoFromTurma)) {
                        numeroDisciplinasObrigatoriasMatriculado++ ;
                    }
                }
            }        
        }
        return numeroDisciplinasObrigatoriasMatriculado;
    }

    public int numeroDisciplinasOptativaMatriculado(Aluno aluno){
        int numeroDisciplinasOptativasMatriculado = 0;
        for (Disciplina disciplina : Persistence.getInstance().getDisciplinas().stream().filter(disciplina -> disciplina.getStatus() == Status.ATIVA && disciplina.getTipo() == TipoDisciplina.OPTATIVA).toList()) {
            for (Turma turma : disciplina.getTurmas().stream().filter(turma -> turma.getStatus() == Status.ATIVA).toList()) {
                for (Aluno alunoFromTurma : turma.getAlunos()) {
                    if (aluno.equals(alunoFromTurma)) {
                        numeroDisciplinasOptativasMatriculado++ ;
                    }
                }
            }        
        }
        return numeroDisciplinasOptativasMatriculado;
    }   

    private boolean estaCheia() {
        return (alunos.size() < 60) ? false : true;
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

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Turma: ")
                .append(nome)
                .append("\n\tId: ").append(id)
                .append("\n\tStatus: ").append(status)
                .append("\n\tProfessor: ").append(professor.getNome())
                .append("\n\tNúmero de alunos: ").append(alunos.size());
        return sb.toString();
    }

    public Turma fromString(String string) {
        String[] strings = string.split(",");
        return new Turma(strings[1],((Professor) persistence.getUsuarioByIdOrNome(strings[2])));
    }
    
}

