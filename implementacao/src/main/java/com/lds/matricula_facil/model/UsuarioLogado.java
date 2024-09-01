package com.lds.matricula_facil.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import com.lds.matricula_facil.model.enums.TipoUsuario;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioLogado {
    private int id;
    private String nome;
    private String email;
    private TipoUsuario tipo;
}
