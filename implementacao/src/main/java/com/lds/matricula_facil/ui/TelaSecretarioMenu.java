package com.lds.matricula_facil.ui;

import javax.swing.*;
import java.awt.*;

public class TelaSecretarioMenu extends JFrame {
    public TelaSecretarioMenu() {
        setTitle("Aluno - Matrícula Fácil");
        setSize(600, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaProfessorMenu().setVisible(true);
        });
    }
}
