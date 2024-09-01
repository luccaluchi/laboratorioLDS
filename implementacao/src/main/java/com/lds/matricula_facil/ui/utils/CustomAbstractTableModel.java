package com.lds.matricula_facil.ui.utils;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import com.lds.matricula_facil.model.Disciplina;

public class CustomAbstractTableModel extends AbstractTableModel {
    private final String[] columnNames = { "Código", "Nome", "Tipo", "Ação" };
    private List<Disciplina> disciplinas = new ArrayList<>();

    public CustomAbstractTableModel(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    @Override
    public int getRowCount() {
        return disciplinas.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Disciplina disciplina = disciplinas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return disciplina.getId();
            case 1:
                return disciplina.getNome();
            case 2:
                return disciplina.getTipo();
            case 3:
                return "Matricular";
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 3) {
            return JButton.class;
        }
        return super.getColumnClass(columnIndex);
    }
};