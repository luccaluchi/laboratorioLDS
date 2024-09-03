package com.lds.matricula_facil;

import java.util.Scanner;

import com.lds.matricula_facil.model.Aluno;
import com.lds.matricula_facil.model.Usuario;
import com.lds.matricula_facil.model.enums.TipoUsuario;
import com.lds.matricula_facil.util.ModuloAluno;
import com.lds.matricula_facil.util.ModuloProfessor;
import com.lds.matricula_facil.util.ModuloSecretaria;
import com.lds.matricula_facil.util.Persistence;
import com.lds.matricula_facil.util.Utils;

public class MatriculaFacil {

    private static Persistence persistence = Persistence.getInstance();
    private static Utils utils = new Utils();
    private Scanner scanner = new Scanner(System.in);
    private TipoUsuario userType;
    private Usuario user;

    public static void main(String[] args) {
        MatriculaFacil app = new MatriculaFacil();
        app.showMainMenu();
    }

    public void showMainMenu() {
        while (!realizarLogin()) {}

        switch (this.userType) {
            case PROFESSOR: 
                acessarModuloProfessor();
                break;
            case ALUNO: 
                acessarModuloAluno();
                break;
            case SECRETARIO: 
                acessarModuloSecretaria();
                break;
            default:
                break;
        }
    }

    private boolean realizarLogin() {
        System.out.println("Digite o email: ");
        String email = scanner.nextLine();
        System.out.println("Digite a senha: ");
        String senha = scanner.nextLine();
        Usuario user = (utils.realizarLogin(email, senha));
        if (user == null) {
            System.out.println("Usuário não encontrado");
            return false;
        }
        this.userType = user.getTipo();
        this.user = user;
        return true;
    }

    private void acessarModuloProfessor() {
        ModuloProfessor module = new ModuloProfessor();
    }

    private void acessarModuloSecretaria() {
        ModuloSecretaria module = new ModuloSecretaria();
    }

    private void acessarModuloAluno() {
        ModuloAluno module = new ModuloAluno((Aluno) this.user);
    }
}