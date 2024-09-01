package com.lds.matricula_facil.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.lds.matricula_facil.MatriculaFacil;
import com.lds.matricula_facil.auth.Authentication;
import com.lds.matricula_facil.model.UsuarioLogin;
import com.lds.matricula_facil.model.UsuarioLogado;
import com.lds.matricula_facil.exceptions.InvalidCredentialsException;

public class TelaLogin extends JFrame {
    private JTextField emailField;
    private JPasswordField senhaField;
    private JLabel errorMessage;
    private Authentication authentication;

    public TelaLogin() {
        setTitle("Login - Matrícula Fácil");
        setSize(600, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1));

        authentication = new Authentication();
        emailField = new JTextField();
        senhaField = new JPasswordField();
        errorMessage = new JLabel("", SwingConstants.CENTER);
        errorMessage.setForeground(Color.RED);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginAction();
            }
        });

        add(new JLabel("Email:"));
        add(emailField);
        add(new JLabel("Senha:"));
        add(senhaField);
        add(errorMessage);
        add(loginButton);
    }

    private void loginAction() {
        String email = emailField.getText();
        String senha = new String(senhaField.getPassword());

        try {
            UsuarioLogado usuarioLogado = authentication.validateCredentials(new UsuarioLogin(email, senha));
            MatriculaFacil.showMainMenu(usuarioLogado);
            this.dispose();
        } catch (InvalidCredentialsException e) {
            errorMessage.setText("Credenciais inválidas.");
        } catch (Exception e) {
            errorMessage.setText("Erro ao tentar logar.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaLogin().setVisible(true);
        });
    }
}
