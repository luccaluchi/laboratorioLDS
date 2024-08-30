package com.lds.matricula_facil.model;

import jakarta.persistence.Entity;


public class Professor extends Usuario{
    private String especialidade;

    public Professor(String nome, String email, String senha, String especialidade) {
        super(nome, email, senha);
        this.especialidade = especialidade;
    }
   
    public String getEspecialidade() {
        return especialidade;
    }
    
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

}