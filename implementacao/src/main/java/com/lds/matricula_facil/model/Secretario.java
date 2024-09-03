package com.lds.matricula_facil.model;

import com.lds.matricula_facil.model.enums.TipoUsuario;

public class Secretario extends Usuario{

    public Secretario(String nome, String email, String senha) {
        super(nome, email, senha, TipoUsuario.SECRETARIO);
    }

    @Override
    public String toString() {
        return this.getNome()+"-"+this.getEmail();
    }

    public static Secretario fromString(String string) {
        String[] strings = string.split(",");
        return new Secretario(strings[1], strings[2], strings[3]);
    }

}
