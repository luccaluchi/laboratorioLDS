package com.lds.matricula_facil.ui.utils;

import javax.swing.*;

import com.lds.matricula_facil.model.Disciplina;
import com.lds.matricula_facil.model.UsuarioLogado;
import com.lds.matricula_facil.util.Persistence;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ButtonEditor extends DefaultCellEditor {
    private final JButton button;
    private Disciplina disciplinaSelecionada;

    public ButtonEditor(JCheckBox checkBox, List<Disciplina> disciplinas, Persistence data, UsuarioLogado aluno) {
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);

        // Verifica se o aluno já está matriculado
        if (data.getDisciplinasMatriculadas(aluno).contains(disciplinaSelecionada)) {
            // JOptionPane.showMessageDialog(button, "Você já está matriculado nesta disciplina.");
            button.setEnabled(false);
        }

        // Verifica se o aluno excedeu o limite de matrículas
        if (data.getDisciplinasMatriculadas(aluno).size() >= 6) {
            // JOptionPane.showMessageDialog(button, "Você excedeu o limite de matrículas.");
            button.setEnabled(false);
            return;
        }

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = Integer.parseInt(button.getActionCommand());
                disciplinaSelecionada = disciplinas.get(row);

                // Matricula o aluno na disciplina
                // Adicione aqui a lógica para matricular o aluno na disciplinaSelecionada
                JOptionPane.showMessageDialog(button, "Matriculado com sucesso na disciplina: " + disciplinaSelecionada.getNome());
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        button.setActionCommand(String.valueOf(row));
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        return disciplinaSelecionada;
    }
}