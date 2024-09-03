package com.lds.matricula_facil.model;

import com.lds.matricula_facil.model.enums.TipoUsuario;

public class Professor extends Usuario{
    private String especialidade;
    

    public Professor(String nome, String email, String senha, String especialidade) {
        super(nome, email, senha, TipoUsuario.PROFESSOR);
        this.especialidade = especialidade;
    }
   
    public String getEspecialidade() {
        return especialidade;
    }
    
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return "Informações do professor:" + "\n\tId: " + getId() + "\n\tNome: " + getNome() + "\n\tEspecialidade" + getEspecialidade() + "\n\tEmail: " + getEmail();
    }

    public static Professor fromString(String string) {
        String[] strings = string.split(",");
        return new Professor(strings[1], strings[2], strings[3], strings[4]);
    }
}