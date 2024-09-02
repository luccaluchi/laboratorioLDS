package com.lds.matricula_facil.util;

import com.lds.matricula_facil.model.Professor;
import com.lds.matricula_facil.model.enums.Status;

import java.util.Scanner;

public class ModuloProfessor {
    Scanner scanner = new Scanner(System.in);
    int choice;
    Persistence persistence = Persistence.getInstance();

    public ModuloProfessor() {
        System.out.println("Aperte 1 para visualizar alunos:");
        scanner.nextInt();
        if (choice != 1) {
            System.out.println("Opção invalida!");

        } else {
            visualizarAlunosTurma(null);
        }
    }

    public void visualizarAlunosTurma(Professor professor) {
        {
            persistence.disciplinas.stream().filter(disciplina -> disciplina.getStatus() == Status.ATIVA)
                    .forEach(disciplina -> {
                        disciplina.getTurmas().stream().filter(turma -> turma.getProfessor().equals(professor))
                                .forEach(turma -> {
                                    System.out.println("Turma: " + turma.getNome());
                                    turma.getAlunos().forEach(aluno -> {
                                        System.out.println("Aluno: " + aluno.getNome());
                                    });
                                });
                    });
        }
    }
}