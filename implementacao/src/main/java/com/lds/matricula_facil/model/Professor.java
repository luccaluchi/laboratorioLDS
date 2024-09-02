package com.lds.matricula_facil.model;


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

    @Override
    public String toString() {
        return "Informações do professor:" + "\n\tId: " + getId() + "\n\tNome: " + getNome() + "\n\tEspecialidade" + getEspecialidade() + "\n\tEmail: " + getEmail();
    }

}