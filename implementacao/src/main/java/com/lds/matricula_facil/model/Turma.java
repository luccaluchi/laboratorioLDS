package com.lds.matricula_facil.model;

import java.util.HashMap;
import java.util.Map;


import com.lds.matricula_facil.model.enums.Status;
import com.lds.matricula_facil.util.IdGenerator;

public class Turma {
    
    private int id = IdGenerator.generateId();
    private String nome;
    private Status status = Status.ATIVA;
    private Professor professor;
    private Map<Integer, Aluno> alunos = new HashMap<>();

    public int getId() {
        return id;
    }
    
}

