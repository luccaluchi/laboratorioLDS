package com.lds.matricula_facil.model;

import com.lds.matricula_facil.model.enums.TipoUsuario;
import com.lds.matricula_facil.util.IdGenerator;




public abstract class Usuario {

    private int id = IdGenerator.generateId();
    private String nome;
    private String email;
    private String senha;
    private TipoUsuario tipo;

    public Usuario(String nome, String email, String senha, TipoUsuario tipo) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public static Usuario fromString(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'fromString'");
    }

}