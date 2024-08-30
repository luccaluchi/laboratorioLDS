package com.lds.matricula_facil.model;
public class Aluno extends Usuario{

    public Aluno(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    @Override
    public String toString() {
        return "Informações do aluno:" + "\n\tId: " + getId() + "\n\tNome: " + getNome() + "\n\tEmail: " + getUsuario();
    }

}