package com.lds.matricula_facil.util;

import com.lds.matricula_facil.model.Usuario;
import com.lds.matricula_facil.model.enums.Status;
import com.lds.matricula_facil.model.Disciplina;
import java.util.List;
import java.util.stream.Collectors; // Add this import statement

public class Utils {

    public boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public Usuario realizarLogin(String email, String senha) {
        return Persistence.getInstance().getUsuarios().stream()
        .filter(usuario -> 
        usuario.getEmail().equals(email) && usuario.getSenha().equals(senha))
        .findFirst()
        .orElse(null);
    }

    public List<Disciplina> getDisciplinasAtivas() {
        return Persistence.getInstance().getDisciplinas().stream()
        .filter(disciplina -> disciplina.getStatus().equals(Status.ATIVA))
        .collect(Collectors.toList());
    }

}
