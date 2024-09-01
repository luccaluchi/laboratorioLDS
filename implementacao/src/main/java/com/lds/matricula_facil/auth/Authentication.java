package com.lds.matricula_facil.auth;

import java.util.Optional;

import com.lds.matricula_facil.exceptions.InvalidCredentialsException;
import com.lds.matricula_facil.model.Usuario;
import com.lds.matricula_facil.model.UsuarioLogado;
import com.lds.matricula_facil.model.UsuarioLogin;
import com.lds.matricula_facil.util.Persistence;

public class Authentication {
    private Persistence repository = Persistence.getInstance();

    public Authentication() {}

    public UsuarioLogado validateCredentials(UsuarioLogin usuarioCred) throws Exception, InvalidCredentialsException {
        Optional<Usuario> usuario = repository.getUsuarioByEmailESenha(usuarioCred.email(), usuarioCred.senha());
        
        if (usuario.isPresent()) {
            return UsuarioLogado.builder()
                    .email(usuario.get().getEmail())
                    .nome(usuario.get().getNome())
                    .id(usuario.get().getId())
                    .tipo(usuario.get().getTipo())
                    .build();
        }
        
        throw new InvalidCredentialsException();
    }    
}
