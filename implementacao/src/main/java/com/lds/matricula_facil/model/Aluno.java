package com.lds.matricula_facil.model;
import java.util.ArrayList;

import com.lds.matricula_facil.model.enums.TipoUsuario;
import com.lds.matricula_facil.util.Persistence;
public class Aluno extends Usuario{
    Persistence persistence = Persistence.getInstance();

    public Aluno(String nome, String email, String senha) {
        super(nome, email, senha, TipoUsuario.ALUNO);
    }

    public ArrayList<Turma> turmasMatriculado() {
        ArrayList<Turma> turmasMatriculado = new ArrayList<>();
        persistence.getDisciplinas().forEach(disciplina -> {
            disciplina.getTurmas().forEach(turma -> {
                if (turma.getAlunos().contains(this)) {
                    turmasMatriculado.add(turma);
                }
            });
        });
        return turmasMatriculado;
    }

    @Override
    public String toString() {
        return "Informações do aluno:" + "\n\tId: " + getId() + "\n\tNome: " + getNome() + "\n\tEmail: " + getEmail();
    }

    public static Aluno fromString(String string) {
        String[] strings = string.split(",");
        return new Aluno(strings[1], strings[2], strings[3]);
    }

}