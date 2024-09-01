package com.lds.matricula_facil.ui;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import com.lds.matricula_facil.model.UsuarioLogado;
import com.lds.matricula_facil.ui.utils.ButtonEditor;
import com.lds.matricula_facil.ui.utils.ButtonRenderer;
import com.lds.matricula_facil.ui.utils.CustomAbstractTableModel;
import com.lds.matricula_facil.model.Disciplina;
import com.lds.matricula_facil.util.Persistence;

public class TelaAlunoMenu extends JFrame {
    private UsuarioLogado aluno;
    private Persistence persistence = Persistence.getInstance();
    
    public TelaAlunoMenu(UsuarioLogado aluno) {
        this.aluno = aluno;
        setTitle("Aluno - Matrícula Fácil");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 1));
        
        // Botão para checar o semestre
        JButton btnChecarSemestre = new JButton("Checar Semestre Atual");
        btnChecarSemestre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checarSemestreAtual();
            }
        });
        
        // Botão para se matricular
        JButton btnMatricular = new JButton("Matricular em Disciplinas");
        btnMatricular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                matricularEmDisciplinas();
            }
        });
        
        // Adicionando botões ao frame
        add(btnChecarSemestre);
        add(btnMatricular);

        SwingUtilities.invokeLater(() -> {
            this.setVisible(true);
        });
    }
    
    private void checarSemestreAtual() {
        List<Disciplina> disciplinas = persistence.getDisciplinasMatriculadas(aluno);
        int totalDisciplinas = disciplinas.size();
        int totalPages = (int) Math.ceil((double) totalDisciplinas / 10);
        
        JTable table = createTable(disciplinas, 0);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel();
        JButton prevButton = new JButton("Anterior");
        JButton nextButton = new JButton("Próximo");
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        prevButton.setEnabled(false);
        nextButton.setEnabled(totalPages > 1);
        
        int[] currentPage = {0};
        
        prevButton.addActionListener(e -> {
            if (currentPage[0] > 0) {
                currentPage[0]--;
                table.setModel(createTableModel(disciplinas, currentPage[0]));
                nextButton.setEnabled(true);
                prevButton.setEnabled(currentPage[0] == 0);
            }
        });
        
        nextButton.addActionListener(e -> {
            if (currentPage[0] < totalPages - 1) {
                currentPage[0]++;
                table.setModel(createTableModel(disciplinas, currentPage[0]));
                prevButton.setEnabled(true);
                nextButton.setEnabled(currentPage[0] == totalPages - 1);
            }
        });
        
        JOptionPane.showMessageDialog(this, panel, "Disciplinas do Semestre Atual", JOptionPane.PLAIN_MESSAGE);
    }
    
    private JTable createTable(List<Disciplina> disciplinas, int pageIndex) {
        TableModel model = createTableModel(disciplinas, pageIndex);
        return new JTable(model);
    }
    
    private TableModel createTableModel(List<Disciplina> disciplinas, int pageIndex) {
        List<Disciplina> pageData = disciplinas.subList(
            pageIndex * 10,
            Math.min((pageIndex + 1) * 10, disciplinas.size())
        );
        return new AbstractTableModel() {
            private final String[] columnNames = {"ID", "Nome", "Tipo", "Turma", "Professor"};
            
            @Override
            public int getRowCount() {
                return pageData.size();
            }
            
            @Override
            public int getColumnCount() {
                return columnNames.length;
            }
            
            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                Disciplina disciplina = pageData.get(rowIndex);
                switch (columnIndex) {
                    case 0: return disciplina.getId();
                    case 1: return disciplina.getNome();
                    case 2: return disciplina.getTipo();
                    case 3: return disciplina.getTurmas().stream().filter(turma -> turma.alunoMatriculado(aluno)).findFirst().get().getNome();
                    case 4: return disciplina.getTurmas().stream().filter(turma -> turma.alunoMatriculado(aluno)).findFirst().get().getProfessor().getNome();
                    default: return null;
                }
            }
            
            @Override
            public String getColumnName(int column) {
                return columnNames[column];
            }
        };
    }
    
    private void matricularEmDisciplinas() {
        // Lógica para matricular-se em disciplinas
        // Cria uma tabela com as disciplinas disponíveis para o aluno se matricular
        List<Disciplina> disciplinas = persistence.getDisciplinas();
        
        // Cria um modelo de tabela customizado
        TableModel model = new CustomAbstractTableModel(disciplinas);
        
        JTable table = new JTable(model);
        
        // Custom cell renderer to add a button in the "Ação" column
        table.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(3).setCellEditor(new ButtonEditor(new JCheckBox(), disciplinas, persistence, aluno));
        
        JScrollPane scrollPane = new JScrollPane(table);
        
        int option = JOptionPane.showConfirmDialog(this, scrollPane, "Disciplinas Disponíveis", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            // Aqui você pode implementar a lógica para adicionar as disciplinas selecionadas à matrícula do aluno
        }
    }      
}
