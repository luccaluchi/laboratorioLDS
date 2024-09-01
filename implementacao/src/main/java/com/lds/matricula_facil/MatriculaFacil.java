package com.lds.matricula_facil;

import javax.swing.*;

import com.lds.matricula_facil.model.UsuarioLogado;
import com.lds.matricula_facil.ui.TelaAlunoMenu;
import com.lds.matricula_facil.ui.TelaLogin;
import com.lds.matricula_facil.ui.TelaProfessorMenu;
import com.lds.matricula_facil.ui.TelaSecretarioMenu;

public class MatriculaFacil{

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaLogin loginScreen = new TelaLogin();
            loginScreen.setVisible(true);
        });
    }
    
    public static void showMainMenu(UsuarioLogado usuario) {
        switch (usuario.getTipo()) {
            case ALUNO: {
                new TelaAlunoMenu(usuario);
                break;
            }
            case SECRETARIO: {
                new TelaSecretarioMenu().setVisible(true);
                break;
            }
            case PROFESSOR: {
                new TelaProfessorMenu().setVisible(true);
                break;
            }
            default: break;
        }
    }    
}