package com.lds.matricula_facil;

import java.util.Scanner;

import com.lds.matricula_facil.model.Aluno;
import com.lds.matricula_facil.model.Curso;
import com.lds.matricula_facil.model.Disciplina;
import com.lds.matricula_facil.model.Professor;
import com.lds.matricula_facil.model.enums.Status;
import com.lds.matricula_facil.model.enums.TipoDisciplina;
import com.lds.matricula_facil.util.Persistence;
import com.lds.matricula_facil.util.Utils;

public class MatriculaFacil {

    private static Persistence persistence = Persistence.getInstance();
    private static Utils utils = new Utils();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hello, World!");
        // Para teste:
        // MatriculaFacil matriculaFacil = new MatriculaFacil();
        // matriculaFacil.visualizarCursos();
        // matriculaFacil.visualizarDisciplinas();
        // matriculaFacil.visualizarUsuario();
    }

    // Section: Aluno
    private void cadastrarAluno() {
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

    // Try catch não foi uma boa alternativa
    private void visualizarUsuario() {
        String input = scanner.nextLine();
        System.out.println("Digite o id ou nome do usuário: ");
        if (utils.isNumeric(input)) {
            int id = Integer.parseInt(input);
            System.out.println(persistence.getUsuario(id).toString());
        } else {
            System.out.println(persistence.getUsuario(input).toString());
        }
    }

    
    // Section: Professor
    private void cadastrarProfessor() 
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
    
    // Section: Usuario
    private void descadastrarUsuario() {
        String input = scanner.nextLine();
        boolean wasDeleted = false;

        System.out.println("Buscar por Id ou nome? /n 1 - Id /n 2 - Nome");
        System.out.println("Digite o id ou nome do usuário: ");
        try {
            int id = Integer.parseInt(input);
            if (persistence.deleteUsuario(id))
            wasDeleted = true;
        } catch (NumberFormatException e) {
            if (persistence.deleteUsuario(input))
            wasDeleted = true;
        } finally {
            if (wasDeleted) {
                System.out.println("Registro do usuário deletado com sucesso!");
            } else {
                System.out.println("Não foi deletar o resistro do usuário!");
            }
        }
    }
    
    // Section: Disciplina
    private void cadastrarDisciplina() {
        String nome = "";
        TipoDisciplina tipo = null;
        Status status = null;
        
        System.out.println("Digite o nome da disciplina: ");
        nome = scanner.nextLine();
        System.out.println("Digite o tipo da disciplina: ");
        System.out.println("1 - OBRIGATORIA /n 2 - OPTATIVA");
        tipo = TipoDisciplina.getfromValue(scanner.nextInt());
        System.out.println("Digite o status da disciplina: ");
        System.out.println("1 - ATIVA /n 2 - INATIVA /n 3 - ENCERRADA");
        status = Status.getFromValue(scanner.nextInt());
        persistence.saveDisciplina(new Disciplina(nome, tipo, status));
    }
    
    private void visualizarDisciplina() {
        String input = scanner.nextLine();
        System.out.println("Digite o id ou nome da disciplina: ");
        if (utils.isNumeric(input)) {
            System.out.println(persistence.getDisciplina(Integer.parseInt(input)).toString());
        } else {
            System.out.println(persistence.getDisciplina(input).toString());
        }
    }

    private void visualizarDisciplinas() {
        persistence.getDisciplinas().forEach(disciplina -> System.out.println(disciplina.toString()));
    }
    
    // Section: Curso
    private void cadastrarCurso() {
        String nome = "";
        int creditos = 0;
        
        System.out.println("Digite o nome do curso: ");
        nome = scanner.nextLine();
        System.out.println("Digite a quantidade de créditos do curso: ");
        creditos = scanner.nextInt();
        persistence.saveCurso(new Curso(nome, creditos));
    }
    
    private void visualizarCurso() {
        String input = scanner.nextLine();
        System.out.println("Digite o id ou nome do curso: ");
        try {
            int id = Integer.parseInt(input);
            System.out.println(persistence.getCurso(id).toString());
        } catch (NumberFormatException e) {
            System.out.println(persistence.getCurso(input).toString());
        }
    }

    private void visualizarCursos() {
        persistence.getCursos().forEach(curso -> System.out.println(curso.toString()));
    }
    
    // Section: Curriculo
    private void gerarCurriculo() {
        
    }
    
    // Section: Turma

}