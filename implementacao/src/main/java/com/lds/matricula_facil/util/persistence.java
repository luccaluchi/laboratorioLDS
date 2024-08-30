package com.lds.matricula_facil.util;

import java.util.List;

import com.lds.matricula_facil.model.Curriculo;
import com.lds.matricula_facil.model.Curso;
import com.lds.matricula_facil.model.Disciplina;
import com.lds.matricula_facil.model.Usuario;

public class persistence {
    public static List<Usuario> usuarios;
    public static List<Curso> cursos;
    public static List<Curriculo> curriculos;
    public static List<Disciplina> disciplinas;

    //Usuario
    public void saveUsuario(Usuario usuario) {
        if (getUsuarioByNome(usuario.getNome()) != null) {
            System.out.println("Usuário já cadastrado");
            return;
        }
        usuarios.add(usuario);
    }
    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    public Usuario getUsuarioById(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }
    public Usuario getUsuarioByNome(String nome) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nome)) {
                return usuario;
            }
        }
        return null;
    }
    
    //Curso
    public void saveCurso(Curso curso) {
        if (getCursoByNome(curso.getNome()) != null) {
            System.out.println("Curso já cadastrado");
            return;
        }
        cursos.add(curso);
    }
    public List<Curso> getCursos() {
        return cursos;
    }
    public Curso getCursoById(int id) {
        for (Curso curso : cursos) {
            if (curso.getId() == id) {
                return curso;
            }
        }
        return null;
    }
    public Curso getCursoByNome(String nome) {
        for (Curso curso : cursos) {
            if (curso.getNome().equals(nome)) {
                return curso;
            }
        }
        return null;
    }

    //Curriculo
    public void saveCurriculo(Curriculo curriculo) {
        curriculos.add(curriculo);
    }
    public List<Curriculo> getCurriculos() {
        return curriculos;
    }
    public Curriculo getCurriculoById(int id) {
        for (Curriculo curriculo : curriculos) {
            if (curriculo.getId() == id) {
                return curriculo;
            }
        }
        return null;
    }
    public List<Curriculo> getCurriculosByAno(int ano) {
        List<Curriculo> curriculosAno = null;
        for (Curriculo curriculo : curriculos) {
            if (curriculo.getAno() == ano) {
                curriculosAno.add(curriculo);
            }
        }
        return curriculosAno;
    }
    public List<Curriculo> getCurriculosBySemestre(int ano, int semestre) {
        List<Curriculo> curriculosSemestre = null;
        for (Curriculo curriculo : curriculos) {
            if (curriculo.getAno() == ano && curriculo.getSemestre() == semestre) {
                curriculosSemestre.add(curriculo);
            }
        }
        return curriculosSemestre;
    }


    //Disciplina
    public void saveDisciplina(Disciplina disciplina) {
        if (getDisciplinaByNome(disciplina.getNome()) != null) {
            System.out.println("Disciplina já cadastrada");
            return;
        }
        disciplinas.add(disciplina);
    }
    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public Disciplina getDisciplinaById(int id) {
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getId() == id) {
                return disciplina;
            }
        }
        return null;
    }

    public Disciplina getDisciplinaByNome(String nome) {
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getNome().equals(nome)) {
                return disciplina;
            }
        }
        return null;
    }

}
