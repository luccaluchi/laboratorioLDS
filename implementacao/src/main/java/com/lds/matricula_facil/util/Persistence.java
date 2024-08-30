package com.lds.matricula_facil.util;

import java.util.ArrayList;
import java.util.List;

import com.lds.matricula_facil.model.Aluno;
import com.lds.matricula_facil.model.Curriculo;
import com.lds.matricula_facil.model.Curso;
import com.lds.matricula_facil.model.Disciplina;
import com.lds.matricula_facil.model.Professor;
import com.lds.matricula_facil.model.Usuario;
import com.lds.matricula_facil.model.enums.Status;
import com.lds.matricula_facil.model.enums.TipoDisciplina;

public class Persistence {
    private static Persistence instance = null;
    public List<Usuario> usuarios = new ArrayList<>();;
    public List<Curso> cursos = new ArrayList<>();;
    public List<Curriculo> curriculos = new ArrayList<>();;
    public List<Disciplina> disciplinas = new ArrayList<>();;

    private Persistence() {
    }

    public static Persistence getInstance() {
        if (instance == null) {
            instance = new Persistence();
            instance.addInitialData();
        }
        return instance;
    }

    //Usuario
    public void saveUsuario(Usuario usuario) {
        if (getUsuario(usuario.getNome()) != null) {
            System.out.println("Usuário já cadastrado");
            return;
        }
        usuarios.add(usuario);
    }
    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    public Usuario getUsuario(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }
    public Usuario getUsuario(String nome) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equalsIgnoreCase(nome)) {
                return usuario;
            }
        }
        return null;
    }

    public boolean deleteUsuario(int id) {
        Usuario usuario = getUsuario(id);
        if (usuario != null) {
            usuarios.remove(usuario);
            return true;
        }
        return false;
    }

    public boolean deleteUsuario(String nome) {
        Usuario usuario = getUsuario(nome);
        if (usuario != null) {
            usuarios.remove(usuario);
            return true;
        }
        return false;
    }
    
    //Curso
    public void saveCurso(Curso curso) {
        if (getCurso(curso.getNome()) != null) {
            System.out.println("Curso já cadastrado");
            return;
        }
        cursos.add(curso);
    }
    public List<Curso> getCursos() {
        return cursos;
    }
    public Curso getCurso(int id) {
        for (Curso curso : cursos) {
            if (curso.getId() == id) {
                return curso;
            }
        }
        return null;
    }
    public Curso getCurso(String nome) {
        for (Curso curso : cursos) {
            if (curso.getNome().equalsIgnoreCase(nome)) {
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
        List<Curriculo> curriculosAno = new ArrayList<>();
        for (Curriculo curriculo : curriculos) {
            if (curriculo.getAno() == ano) {
                curriculosAno.add(curriculo);
            }
        }
        return curriculosAno;
    }
    public List<Curriculo> getCurriculosBySemestre(int ano, int semestre) {
        List<Curriculo> curriculosSemestre = new ArrayList<>();;
        for (Curriculo curriculo : curriculos) {
            if (curriculo.getAno() == ano && curriculo.getSemestre() == semestre) {
                curriculosSemestre.add(curriculo);
            }
        }
        return curriculosSemestre;
    }


    //Disciplina
    public void saveDisciplina(Disciplina disciplina) {
        if (getDisciplina(disciplina.getNome()) != null) {
            System.out.println("Disciplina já cadastrada");
            return;
        }
        disciplinas.add(disciplina);
    }
    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public Disciplina getDisciplina(int id) {
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getId() == id) {
                return disciplina;
            }
        }
        return null;
    }

    public Disciplina getDisciplina(String nome) {
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getNome().equalsIgnoreCase(nome)) {
                return disciplina;
            }
        }
        return null;
    }

    private void addInitialData(){
        // Adicionar 3 alunos
        saveUsuario(new Aluno("João", "alunoJoao@email.com", "123"));
        saveUsuario(new Aluno("Maria", "alunoMaria@email.com", "123"));
        saveUsuario(new Aluno("Ricardo", "alunoRicardo@email.com", "123"));

        // Adicionar 3 professores
        saveUsuario(new Professor("Patrick", "professorPatrick@email.com", "123", "História"));
        saveUsuario(new Professor("Pedro", "professorPedro@email.com", "123", "Matemática"));
        saveUsuario(new Professor("Piter", "professorPiter@email.com", "123", "Ciências"));

        // Adicionar 3 cursos
        saveCurso(new Curso("Engenharia de Software", 2000));
        saveCurso(new Curso("Engenharia de Mecânica", 2500));
        saveCurso(new Curso("Engenharia de Produção", 2500));

        // Adicionar 3 disciplinas
        saveDisciplina(new Disciplina("Matemática", TipoDisciplina.OBRIGATORIA, Status.ATIVA));
        saveDisciplina(new Disciplina("Física", TipoDisciplina.OBRIGATORIA, Status.ATIVA));
        saveDisciplina(new Disciplina("Química", TipoDisciplina.OBRIGATORIA, Status.ATIVA));       

    }

}
