package com.lds.matricula_facil.model;

import com.lds.matricula_facil.model.enums.TipoUsuario;

public class Secretario extends Usuario{

    public Secretario(String nome, String email, String senha) {
        super(nome, email, senha, TipoUsuario.SECRETARIO);
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Unimplemented method 'toString'");
    }

}
