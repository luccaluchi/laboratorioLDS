package com.lds.matricula_facil.util;

import com.lds.matricula_facil.model.Aluno;
import com.lds.matricula_facil.model.Curriculo;
import com.lds.matricula_facil.model.Curso;
import com.lds.matricula_facil.model.Disciplina;
import com.lds.matricula_facil.model.Professor;
import com.lds.matricula_facil.model.Turma;
import com.lds.matricula_facil.model.enums.Status;
import com.lds.matricula_facil.model.enums.TipoDisciplina;

import java.util.Scanner;

public class ModuloSecretaria {

    private static Persistence persistence = Persistence.getInstance();
    private static Utils utils = new Utils();
    private Scanner scanner = new Scanner(System.in);

    public ModuloSecretaria() {

    }

    ////////////////////
    // Section: Aluno //
    ////////////////////
    /**
     * Realiza o cadastro de um aluno.
     */
    public  void cadastrarAluno() {
        String nome = "";
        String email = "";
        String senha = "";
        System.out.println("Digite o nome do aluno: ");
        nome = scanner.nextLine();
        System.out.println("Digite o email do aluno: ");
        email = scanner.nextLine();
        System.out.println("Digite a senha do aluno: ");
        senha = scanner.nextLine();
        persistence.saveUsuario(new Aluno(nome, email, senha));
    }

    public void updateAluno() {
        String input = scanner.nextLine();
        System.out.println("Digite o id ou nome do aluno: ");
        input = scanner.nextLine();
        Aluno aluno = (Aluno) persistence.getUsuarioByIdOrNome(input);
        if (aluno != null) {
            System.out.println("O que deseja atualizar?");
            System.out.println("1 - Nome \n 2 - Email \n 9 - Salvar \n 0 - Cancelar");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consumindo o \n deixado pelo .nextInt()
            while (option != 9) {
                switch (option) {
                    case 1:
                        System.out.println("Digite o novo nome do aluno: ");
                        aluno.setNome(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Digite o novo email do aluno: ");
                        aluno.setEmail(scanner.nextLine());
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
                System.out.println("O que deseja atualizar?");
                System.out.println("1 - Nome \n 2 - Email \n 9 - Salvar \n 0 - Cancelar");
                option = scanner.nextInt();
                scanner.nextLine(); // Consumindo o \n deixado pelo .nextInt()
            }
        } else {
            System.out.println("Aluno não encontrado!");
        }
    }

    /**
     * Realiza a visualização de todos os alunos cadastrados.
     */
    public void visualizarAlunos() {
        persistence.getAlunos().forEach(aluno -> System.out.println(aluno.toString()));
    }

    ////////////////////////
    // Section: Professor //
    ////////////////////////

    /**
     * Realiza o cadastro de um professor.
     */
    public void cadastrarProfessor() {
        String nome = "";
        String email = "";
        String senha = "";
        String especialidade = "";
        System.out.println("Digite o nome do professor: ");
        nome = scanner.nextLine();
        System.out.println("Digite o email do professor: ");
        email = scanner.nextLine();
        System.out.println("Digite a senha do professor: ");
        senha = scanner.nextLine();
        System.out.println("Digite a especialidade do professor: ");
        especialidade = scanner.nextLine();
        persistence.saveUsuario(new Professor(nome, email, senha, especialidade));
    }

    public void updateProfessor(){
        String input = "";
        scanner.nextLine();
        System.out.println("Digite o id ou nome do professor: ");
        input = scanner.nextLine();
        Professor professor = (Professor) persistence.getUsuarioByIdOrNome(input);
        if (professor != null) {
            System.out.println("O que deseja atualizar?");
            System.out.println("1 - Nome \n 2 - Email \n 4 - Especialidade \n 9 - Salvar \n 0 - Cancelar");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consumindo o \n deixado pelo .nextInt()
            while (option != 9) {
                switch (option) {
                    case 1:
                        System.out.println("Digite o novo nome do professor: ");
                        professor.setNome(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Digite o novo email do professor: ");
                        professor.setEmail(scanner.nextLine());
                        break;
                    case 4:
                        System.out.println("Digite a nova especialidade do professor: ");
                        professor.setEspecialidade(scanner.nextLine());
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
                System.out.println("O que deseja atualizar?");
                System.out.println("1 - Nome \n 2 - Email \n 4 - Especialidade \n 9 - Salvar \n 0 - Cancelar");
                option = scanner.nextInt();
                scanner.nextLine(); // Consumindo o \n deixado pelo .nextInt()
            }
        } else {
            System.out.println("Professor não encontrado!");
        }
    }

    public void listarProfessores(){
        persistence.getProfessores().forEach(professor -> System.out.println(professor.toString()));
    }

    //////////////////////
    // Section: Usuario //
    //////////////////////

    public void visualizarUsuario() {
        String input = scanner.nextLine();
        System.out.println("Digite o id ou nome do usuário: ");
        System.out.println(persistence.getUsuarioByIdOrNome(input).toString());
    }

    /**
     * Cancela o cadastro de um usuário, seja ele aluno ou professor.
     */
    public void cancelarCadastrarUsuario() {
        String input = scanner.nextLine();

        System.out.println("Digite o id ou nome do usuário: ");
        if (persistence.deleteUsuarioByIdOrNome(input)) {
            System.out.println("Registro do usuário deletado com sucesso!");
        } else {
            System.out.println("Não foi deletar o resistro do usuário!");
        }
    }

    /////////////////////////
    // Section: Disciplina //
    /////////////////////////

    /**
     * Realiza o cadastro de uma disciplina.
     */
    public void cadastrarDisciplina() {
        String nome = "";
        TipoDisciplina tipo = null;
        Status status = null;

        System.out.println("Digite o nome da disciplina: ");
        nome = scanner.nextLine();
        System.out.println("Digite o tipo da disciplina: ");
        System.out.println("1 - OBRIGATORIA /n 2 - OPTATIVA");
        tipo = TipoDisciplina.getfromValue(scanner.nextInt());
        scanner.nextLine(); // Consumindo o \n deixado pelo .nextInt()
        System.out.println("Digite o status da disciplina: ");
        System.out.println("1 - ATIVA /n 2 - INATIVA /n 3 - ENCERRADA");
        status = Status.getFromValue(scanner.nextInt());
        persistence.saveDisciplina(new Disciplina(nome, tipo, status));
    }

    /**
     * Realiza a visualização de uma disciplina.
     */
    public void visualizarDisciplina() {
        scanner.nextLine(); //consumir possível \n
        System.out.println("Digite o id ou nome da disciplina: ");
        String input = scanner.nextLine();
        System.out.println(persistence.getDisciplinaByIdOrNome(input).toString());
    }

    /**
     * Realiza a visualização de todas as disciplinas cadastradas.
     */
    public void visualizarDisciplinas() {
        persistence.getDisciplinas().forEach(disciplina -> System.out.println(disciplina.toString()));
    }

    public void visualizarTurmasDisciplina(){
        System.out.println("Digite o id ou nome da disciplina: ");
        String input = scanner.nextLine();
        Disciplina disciplina = persistence.getDisciplinaByIdOrNome(input);
        disciplina.getTurmas().forEach(turma -> { System.out.println(turma.toString()); });
    }

    public void removerDiscipplina(){
        System.out.println("Digite o nome ou id da disciplina que deseja remover:");
        scanner.nextLine(); // consumir possível \n
        scanner.nextLine();
        Disciplina disciplina = persistence.getDisciplinaByIdOrNome(scanner.nextLine());
        disciplina.setStatus(Status.INATIVA);
    }

    public void updateDisciplina(){
        String input = "";
        scanner.nextLine();
        System.out.println("Digite o id ou nome da disciplina: ");
        input = scanner.nextLine();
        Disciplina disciplina = persistence.getDisciplinaByIdOrNome(input);
        if (disciplina != null) {
            System.out.println("O que deseja atualizar?");
            System.out.println("1 - Nome \n 2 - Tipo \n 3 - Status \n 9 - Salvar \n 0 - Cancelar");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consumindo o \n deixado pelo .nextInt()
            while (option != 9) {
                switch (option) {
                    case 1:
                        System.out.println("Digite o novo nome da disciplina: ");
                        disciplina.setNome(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Digite o novo tipo da disciplina: ");
                        System.out.println("1 - OBRIGATORIA /n 2 - OPTATIVA");
                        disciplina.setTipo(TipoDisciplina.getfromValue(scanner.nextInt()));
                        scanner.nextLine(); // Consumindo o \n deixado pelo .nextInt()
                        break;
                    case 3:
                        System.out.println("Digite o novo status da disciplina: ");
                        System.out.println("1 - ATIVA /n 2 - INATIVA /n 3 - ENCERRADA");
                        disciplina.setStatus(Status.getFromValue(scanner.nextInt()));
                        scanner.nextLine(); // Consumindo o \n deixado pelo .nextInt()
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
                System.out.println("O que deseja atualizar?");
                System.out.println("1 - Nome \n 2 - Tipo \n 3 - Status \n 9 - Salvar \n 0 - Cancelar");
                option = scanner.nextInt();
                scanner.nextLine(); // Consumindo o \n deixado pelo .nextInt()
            }
        } else {
            System.out.println("Disciplina não encontrada!");
        }

    }

    public void abrirTurma(){
        scanner.nextLine();
        System.out.println("Digite o id ou nome da disciplina: ");
        String input = scanner.nextLine();
        Disciplina disciplina = persistence.getDisciplinaByIdOrNome(input);
        if(disciplina != null){
            System.out.println("Digite o id ou nome do professor: ");
            input = scanner.nextLine();
            Professor professor = (Professor) persistence.getUsuarioByIdOrNome(input);
            if(professor != null){
                disciplina.abrirNovaTurma(professor);
            }else{
                System.out.println("Professor não encontrado!");
            }
        }else{
            System.out.println("Disciplina não encontrada!");
        }
    }

    ////////////////////
    // Section: Curso //
    ////////////////////

    public void cadastrarCurso() {
        String nome = "";
        int creditos = 0;

        scanner.nextLine(); //consumir possível \n
        System.out.println("Digite o nome do curso: ");
        nome = scanner.nextLine();
        System.out.println("Digite a quantidade de créditos do curso: ");
        creditos = scanner.nextInt();
        scanner.nextLine(); // Consumindo o \n deixado pelo .nextInt()
        persistence.saveCurso(new Curso(nome, creditos));
    }

    public void visualizarCurso() {
        scanner.nextLine(); //consumir possível \n
        System.out.println("Digite o id ou nome do curso: ");
        String input = scanner.nextLine();
        System.out.println(persistence.getCursoByIdOrNome(input).toString());
    }

    public void visualizarCursos() {
        persistence.getCursos().forEach(curso -> System.out.println(curso.toString()));
    }

    public void removerCurso(){
        System.out.println("Digite o nome ou id do curso que deseja remover:");
        scanner.nextLine(); // consumir possível \n
        scanner.nextLine();
        persistence.deleteCurso(scanner.nextLine());
    }

    public void verDisciplinasCurso(){
        String input = "";
        scanner.nextLine();
        System.out.println("Digite o nome ou id do curso que deseja ver as disciplinas: ");
        persistence.getCursoByIdOrNome(input).getDisciplinas().forEach(disciplina -> {System.out.println(disciplina.toString());});
    }

    public void updateCurso(){
        String input = "";
        scanner.nextLine();
        System.out.println("Digite o nome ou id do curso que deseja atualizar: ");
        input = scanner.nextLine();
        Curso curso = persistence.getCursoByIdOrNome(input);
        if (curso != null) {
            System.out.println("O que deseja atualizar?");
            System.out.println("1 - Nome \n 2 - Creditos \n 9 - Salvar \n 0 - Cancelar");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consumindo o \n deixado pelo .nextInt()
            while (option != 9) {
                switch (option) {
                    case 1:
                        System.out.println("Digite o novo nome do curso: ");
                        curso.setNome(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Digite a nova quantidade de créditos do curso: ");
                        curso.setCreditos(scanner.nextInt());
                        scanner.nextLine(); // Consumindo o \n deixado pelo .nextInt()
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
                System.out.println("O que deseja atualizar?");
                System.out.println("1 - Nome \n 2 - Creditos \n 9 - Salvar \n 0 - Cancelar");
                option = scanner.nextInt();
                scanner.nextLine(); // Consumindo o \n deixado pelo .nextInt()
            }
        } else {
            System.out.println("Curso não encontrado!");
        }
    }

    ////////////////////////
    // Section: Curriculo //
    ////////////////////////

    public void gerarCurriculo() {
        int ano, semestre;
        System.out.println("Digite o ano do currículo"); //Assim ou pegar automaticamente pelo tempo do sistema?
        ano = scanner.nextInt();
        scanner.nextLine(); //consumir \n que pode ficar
        System.out.println("Digite o semestre do currículo");
        semestre = scanner.nextInt();
        scanner.nextLine(); //consumir \n que pode ficar
        Curriculo curriculo = new Curriculo(ano, semestre);

        for (Curso curso : persistence.getCursos()) {
            for (Disciplina disciplina : curso.getDisciplinas().stream().filter(disciplina -> disciplina.getStatus() == Status.ATIVA).toArray(Disciplina[]::new)) {
                for (Turma turma : disciplina.getTurmas().stream().filter(turma -> turma.getStatus() == Status.ATIVA).toArray(Turma[]::new)){
                    curriculo.addTurma(turma);
                    turma.setStatus(Status.ENCERRADA);
                }
            }   
        }
        persistence.saveCurriculo(curriculo);
    }

    public void visualizarCurriculos() {
        persistence.getCurriculos().forEach(curriculo -> System.out.println(curriculo.toString()));
    }

    public void visualizarTurmasDeUmCurriculo(){
        int input = 0;
        System.out.println("Digite o id do currículo que deseja ver as turmas: ");
        input = scanner.nextInt();
        Curriculo curriculo = persistence.getCurriculoById(input);
        System.out.println("Número de turmas: " + curriculo.getTurmas().size() + "\nTurmas: \n");
        curriculo.getTurmas().forEach(turma -> System.out.println(turma.toString()));
    }

}