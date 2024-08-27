package com.lds.matricula_facil.model;

import java.util.List;

import com.lds.matricula_facil.model.enums.StatusDisciplina;
import com.lds.matricula_facil.model.enums.TipoDisciplina;

public class Disciplina{
   private int id;
   private String nome;
   private TipoDisciplina tipo;
   private StatusDisciplina status;
   private List<Turma> turmas;
    
   public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public String getNome() {
    return nome;
}

public void setNome(String nome) {
    this.nome = nome;
}

public TipoDisciplina getTipo() {
    return tipo;
}

public void setTipo(TipoDisciplina tipo) {
    this.tipo = tipo;
}

public StatusDisciplina getStatus() {
    return status;
}

public void setStatus(StatusDisciplina status) {
    this.status = status;
}

public List<Turma> getTurmas() {
    return turmas;
}

public void setTurmas(List<Turma> turmas) {
    this.turmas = turmas;
}

public void encerrarMatriculas(){ 
//fazer!!
}

public void cancelarMatriculas(){ 
    //fazer!!
}
}
