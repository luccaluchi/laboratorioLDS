package com.lds.matricula_facil.util;

import com.lds.matricula_facil.model.Aluno;
import com.lds.matricula_facil.model.Disciplina;
import com.lds.matricula_facil.model.Turma;
import com.lds.matricula_facil.model.enums.Status;

import java.util.Scanner;

import com.lds.matricula_facil.model.Turma;

public class ModuloProfessor {
    Scanner scanner = new Scanner(System.in);
    int choice;

    public ModuloProfessor() {
        System.out.println("Aperte 1 para visualizar alunos:");
        scanner.nextInt();
        if (choice != 1) {
            System.out.println("Opção invalida!");

        } else {
        }
    }
}