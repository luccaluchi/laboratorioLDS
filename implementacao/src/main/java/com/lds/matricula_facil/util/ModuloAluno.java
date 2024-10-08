package com.lds.matricula_facil.util;

import com.lds.matricula_facil.model.Aluno;
import com.lds.matricula_facil.model.Disciplina;
import com.lds.matricula_facil.model.Turma;
import com.lds.matricula_facil.model.enums.Status;

import java.util.Scanner;

public class ModuloAluno {
    // Atributos, construtores e métodos da classe aqui
    Scanner scanner = new Scanner(System.in);
    Persistence persistence = Persistence.getInstance();
    Utils utils = new Utils();

    Aluno aluno = null;

    int option = 0;

    // Exemplo de construtor
    public ModuloAluno(Aluno aluno) {
        this.aluno = aluno;
        while (true) {
            System.out.println(
                    "Selecione o que deseja fazer: \n1- Realizar matrícula\n2- Cancelar matrícula\n3- Visualizar matrículas\n4- Visualizar disciplinas\n0- Sair");
            option = scanner.nextInt();
            scanner.nextLine(); // Consumindo o \n deixado pelo .nextInt()
            switch (option) {
                case 1:
                    realizarMatricula();
                    break;
                case 2:
                    cancelarMatricula();
                    break;                 
                case 3:
                    visualizarMatriculas();
                    break;
                case 4:
                    visualizarDisciplinas();
                    break;
                // case 0:
                //     break;
                default:
                System.out.println("Opção inválida");
                    break;
            }
        }

    }

    public boolean realizarMatricula() {
        System.out.println("Digite o nome ou id da disciplina: ");
        String identificacaoDisciplina = scanner.nextLine();
        Disciplina disciplina = persistence.getDisciplinaByIdOrNome(identificacaoDisciplina);
        if (disciplina == null) {
            System.out.println("Disciplina não encontrada");
            return false;
        }
        if (disciplina.getStatus() != Status.ATIVA) {
            System.out.println("A disciplina deve estar ativa para realizar a matrícula");
            return false;
        }
        for (Turma turma : disciplina.getTurmas()) {
            if (turma.matricularAluno(aluno)) {
                System.out.println("Matrícula realizada com sucesso na turma " + turma.getNome() + " da disciplina "
                        + disciplina.getNome());
                return true;
            } else {
                System.out.println("Não foi possível realizar a matrícula: ");
                return false;
            }
        }
        return true;
    }

    public boolean cancelarMatricula() {
        System.out.println("Digite o nome ou id da disciplina: ");
        String identificacaoDisciplina = scanner.nextLine();
        Disciplina disciplina = persistence.getDisciplinaByIdOrNome(identificacaoDisciplina);
        if (disciplina == null) {
            System.out.println("Disciplina não encontrada");
            return false;
        }
        for (Turma turma : disciplina.getTurmas()) {
            if (turma.cancelarMatricularAluno(aluno)) {
                System.out.println("Matrícula cancelada com sucesso na turma " + turma.getNome() + " da disciplina "
                        + disciplina.getNome());
                return true;
            } else {
                System.out.println("Não foi possível cancelar a matrícula: ");
                return false;
            }
        }
        return true;
    }

    public void visualizarMatriculas() {
        System.out.println("Turmas matriculadas: ");
        if (aluno.turmasMatriculado().isEmpty()) {
            System.out.println("Nenhuma turma encontrada");
            return;
        }
        aluno.turmasMatriculado().forEach(turma -> {
            System.out.println(turma.toString());
        });
    }

    public void visualizarDisciplinas() {
        if (utils.getDisciplinasAtivas().isEmpty()) {
            System.out.println("Nenhuma disciplina encontrada");
            return;
        }

        utils.getDisciplinasAtivas().forEach(disciplina -> {
            System.out.println(disciplina.toString());
        });
    }
}