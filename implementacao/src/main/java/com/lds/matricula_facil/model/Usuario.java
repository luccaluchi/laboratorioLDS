package com.lds.matricula_facil.model;

import com.lds.matricula_facil.util.IdGenerator;




public abstract class Usuario {

    private int id = IdGenerator.generateId();
    private String nome;
    private String usuario;
    private String senha;

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.usuario = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId() {
        return id;
    }
    public abstract String toString();

    // metodo p validar senha
}