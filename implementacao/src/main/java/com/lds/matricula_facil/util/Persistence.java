package com.lds.matricula_facil.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.lds.matricula_facil.model.Aluno;
import com.lds.matricula_facil.model.Curriculo;
import com.lds.matricula_facil.model.Curso;
import com.lds.matricula_facil.model.Disciplina;
import com.lds.matricula_facil.model.Professor;
import com.lds.matricula_facil.model.Secretario;
import com.lds.matricula_facil.model.Usuario;
import com.lds.matricula_facil.model.enums.Status;
import com.lds.matricula_facil.model.enums.TipoDisciplina;

public class Persistence {
    private static Persistence instance = null;
    public List<Usuario> usuarios = new ArrayList<>();;
    public List<Curso> cursos = new ArrayList<>();;
    public List<Curriculo> curriculos = new ArrayList<>();;
    public List<Disciplina> disciplinas = new ArrayList<>();
    private Utils utils = new Utils();

    private Persistence() {
    }

    public static Persistence getInstance() {
        if (instance == null) {
            instance = new Persistence();
            instance.addInitialData();
        }
        return instance;
    }
    //////////////////////
    // Section: Usuario //
    //////////////////////

    public void saveUsuario(Usuario usuario) {
        if (getUsuarioByIdOrNome(usuario.getNome()) != null) {
            System.out.println("Usuário já cadastrado");
            return;
        }
        usuarios.add(usuario);
    }

    public Usuario getUsuario(Usuario usuario) {
        return usuarios.stream().filter(user -> user.getId() == usuario.getId()).findFirst().orElse(null);
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public Usuario getUsuarioByIdOrNome(String idOrNome) {
        if (utils.isNumeric(idOrNome)) {
            int id = Integer.parseInt(idOrNome);
            return usuarios.stream().filter(usuario -> usuario.getId() == id).findFirst().orElse(null);
        } else {
            return usuarios.stream().filter(usuario -> usuario.getNome().equalsIgnoreCase(idOrNome)).findFirst()
                    .orElse(null);
        }
    }

    public boolean deleteUsuarioByIdOrNomee(String idOrNome) {
        Usuario usuario = getUsuarioByIdOrNome(idOrNome);
        if (usuario != null) {
            usuarios.remove(usuario);
            return true;
        }
        return false;
    }

    public boolean deleteUsuarioByIdOrNome(String idOrNome) {
        return usuarios.remove(getUsuarioByIdOrNome(idOrNome));
    }

    ////////////////////
    // Section: Aluno //
    ////////////////////

    public boolean updateAluno(Aluno aluno) {
        Aluno alunoToUpdate = (Aluno) getUsuario(aluno);
        if (alunoToUpdate != null) {
            alunoToUpdate.setNome(aluno.getNome());
            alunoToUpdate.setEmail(aluno.getEmail());
            alunoToUpdate.setSenha(aluno.getSenha());
            return true;
        }
        return false;
    }

    public List<Aluno> getAlunos() {
        return usuarios.stream()
                .filter(usuario -> usuario instanceof Aluno)
                .map(usuario -> (Aluno) usuario)
                .collect(Collectors.toList());
    }

    ////////////////////////
    // Section: Professor //
    ////////////////////////

    public List<Professor> getProfessores() {
        return usuarios.stream()
                .filter(usuario -> usuario instanceof Professor)
                .map(usuario -> (Professor) usuario)
                .collect(Collectors.toList());
    }

    public boolean updateProfessor(Professor professor) {
        Professor professorToUpdate = (Professor) getUsuario(professor);
        if (professorToUpdate != null) {
            professorToUpdate.setNome(professor.getNome());
            professorToUpdate.setEmail(professor.getEmail());
            professorToUpdate.setSenha(professor.getSenha());
            professorToUpdate.setEspecialidade(professor.getEspecialidade());
            ;
            return true;
        }
        return false;
    }

    ////////////////////
    // Section: Curso //
    ////////////////////
    public boolean saveCurso(Curso curso) {
        if (getCursoByIdOrNome(curso.getNome()) != null) {
            System.out.println("Curso já cadastrado");
            return false;
        }
        cursos.add(curso);
        return true;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public Curso getCursoByIdOrNome(String idOrNome) {
        if (utils.isNumeric(idOrNome)) {
            int id = Integer.parseInt(idOrNome);
            return cursos.stream().filter(curso -> curso.getId() == id).findFirst().orElse(null);
        } else {
            return cursos.stream().filter(curso -> curso.getNome().equalsIgnoreCase(idOrNome)).findFirst().orElse(null);
        }
    }

    public boolean deleteCurso(String idOrNome) {
        Curso curso = getCursoByIdOrNome(idOrNome);
        if (curso != null) {
            cursos.remove(curso);
            return true;
        }
        return false;
    }

    public boolean updateCurso(Curso curso) {
        Curso cursoToUpdate = getCursoByIdOrNome(Integer.toString(curso.getId()));
        if (cursoToUpdate != null) {
            cursoToUpdate.setNome(curso.getNome());
            cursoToUpdate.setCreditos(curso.getCreditos());
            return true;
        }
        return false;
    }

    ////////////////////////
    // Section: Curriculo //
    ////////////////////////
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
        List<Curriculo> curriculosSemestre = new ArrayList<>();
        ;
        for (Curriculo curriculo : curriculos) {
            if (curriculo.getAno() == ano && curriculo.getSemestre() == semestre) {
                curriculosSemestre.add(curriculo);
            }
        }
        return curriculosSemestre;
    }

    /////////////////////////
    // Section: Disciplina //
    /////////////////////////
    public void saveDisciplina(Disciplina disciplina) {
        if (getDisciplinaByIdOrNome(disciplina.getNome()) != null) {
            System.out.println("Disciplina já cadastrada");
            return;
        }
        disciplinas.add(disciplina);
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public Disciplina getDisciplinaByIdOrNome(String idOrNome) {
        if (utils.isNumeric(idOrNome)) {
            int id = Integer.parseInt(idOrNome);
            return disciplinas.stream().filter(disciplina -> disciplina.getId() == id).findFirst().orElse(null);
        } else {
            return disciplinas.stream().filter(disciplina -> disciplina.getNome().equalsIgnoreCase(idOrNome))
                    .findFirst().orElse(null);
        }
    }

    public boolean updateDisciplina(Disciplina disciplina) {
        Disciplina disciplinaToUpdate = getDisciplinaByIdOrNome(Integer.toString(disciplina.getId()));
        if (disciplinaToUpdate != null) {
            disciplinaToUpdate.setNome(disciplina.getNome());
            disciplinaToUpdate.setStatus(disciplina.getStatus());
            disciplinaToUpdate.setTipo(disciplina.getTipo());
            return true;
        } else
            return false;
    }

    /////////////////////////////
    // Section: Dados iniciais //
    /////////////////////////////
    private void addInitialData() {
        saveUsuario(new Secretario("Secretaria", "admin", "admin"));

        // Adicionar 3 alunos
        Aluno a1 = new Aluno("João", "alunoJoao@email.com", "123");
        Aluno a2 = new Aluno("Maria", "alunoMaria@email.com", "123");
        Aluno a3 = new Aluno("Ricardo", "alunoRicardo@email.com", "123");
        Aluno a4 = new Aluno("a", "a", "123");
        saveUsuario(a1);
        saveUsuario(a2);
        saveUsuario(a3);
        saveUsuario(a4);

        Professor p1 = new Professor("Patrick", "professorPatrick@email.com", "123", "História");
        Professor p2 = new Professor("Pedro", "professorPedro@email.com", "123", "Matemática");
        Professor p3 = new Professor("Piter", "professorPiter@email.com", "123", "Ciências");
        saveUsuario(p1);
        saveUsuario(p2);
        saveUsuario(p3);

        // Adicionar 3 cursos
        saveCurso(new Curso("Engenharia de Software", 2000));
        saveCurso(new Curso("Engenharia de Mecânica", 2500));
        saveCurso(new Curso("Engenharia de Produção", 2500));

        // Adicionar 3 disciplinas
        Disciplina d1 = new Disciplina("Matemática", TipoDisciplina.OBRIGATORIA, Status.ATIVA);
        Disciplina d2 = new Disciplina("Física", TipoDisciplina.OBRIGATORIA, Status.ATIVA);
        Disciplina d3 = new Disciplina("Química", TipoDisciplina.OBRIGATORIA, Status.ATIVA);
        d1.abrirNovaTurma(p1);
        d2.abrirNovaTurma(p2);
        d3.abrirNovaTurma(p3);

        // Disciplinas obrigatórias
        Disciplina d4 = new Disciplina("História", TipoDisciplina.OBRIGATORIA, Status.ATIVA);
        Disciplina d5 = new Disciplina("Geografia", TipoDisciplina.OBRIGATORIA, Status.ATIVA);
        Disciplina d6 = new Disciplina("Biologia", TipoDisciplina.OBRIGATORIA, Status.ATIVA);
        Disciplina d7 = new Disciplina("Português", TipoDisciplina.OBRIGATORIA, Status.ATIVA);

        // Abrindo novas turmas para disciplinas obrigatórias
        d4.abrirNovaTurma(p1);
        d5.abrirNovaTurma(p1);
        d6.abrirNovaTurma(p1);
        d7.abrirNovaTurma(p1);

        // Disciplinas optativas
        Disciplina d8 = new Disciplina("Literatura", TipoDisciplina.OPTATIVA, Status.ATIVA);
        Disciplina d9 = new Disciplina("Filosofia", TipoDisciplina.OPTATIVA, Status.INATIVA);
        Disciplina d10 = new Disciplina("Artes", TipoDisciplina.OPTATIVA, Status.ATIVA);
        Disciplina d11 = new Disciplina("Educação Física", TipoDisciplina.OPTATIVA, Status.ATIVA);

        // Abrindo novas turmas para disciplinas optativas
        d8.abrirNovaTurma(p1);
        d9.abrirNovaTurma(p1);
        d10.abrirNovaTurma(p1);
        d11.abrirNovaTurma(p1);


        d1.getTurmas().stream().filter(turma -> turma.getNome().equals("Matemática.01")).findFirst().get().matricularAluno(a1);
        d2.getTurmas().stream().filter(turma -> turma.getNome().equals("Física.01")).findFirst().get().matricularAluno(a1);
        d3.getTurmas().stream().filter(turma -> turma.getNome().equals("Química.01")).findFirst().get().matricularAluno(a1);
        d4.getTurmas().stream().filter(turma -> turma.getNome().equals("História.01")).findFirst().get().matricularAluno(a1);

        d8.getTurmas().stream().filter(turma -> turma.getNome().equals("Literatura.01")).findFirst().get().matricularAluno(a2);
        d9.getTurmas().stream().filter(turma -> turma.getNome().equals("Filosofia.01")).findFirst().get().matricularAluno(a2);
        

        saveDisciplina(d1);
        saveDisciplina(d2);
        saveDisciplina(d3);
        saveDisciplina(d4);
        saveDisciplina(d5);
        saveDisciplina(d6);
        saveDisciplina(d7);
        saveDisciplina(d8);
        saveDisciplina(d9);
        saveDisciplina(d10);
        saveDisciplina(d11);

    }

}
