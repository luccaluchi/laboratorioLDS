package com.lds.matricula_facil.exceptions;

public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException(){
        super("Credencias de usuário inválidas, tente novamente");
    }
}
