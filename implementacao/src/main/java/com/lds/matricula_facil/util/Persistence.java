package com.lds.matricula_facil.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.lds.matricula_facil.model.Aluno;
import com.lds.matricula_facil.model.Curriculo;
import com.lds.matricula_facil.model.Curso;
import com.lds.matricula_facil.model.Disciplina;
import com.lds.matricula_facil.model.Professor;
import com.lds.matricula_facil.model.Secretario;
import com.lds.matricula_facil.model.Turma;
import com.lds.matricula_facil.model.Usuario;
import com.lds.matricula_facil.model.UsuarioLogado;
import com.lds.matricula_facil.model.enums.Status;
import com.lds.matricula_facil.model.enums.TipoDisciplina;
import com.lds.matricula_facil.model.enums.TipoUsuario;

public class Persistence {
    private static Persistence instance = null;
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Curso> cursos = new ArrayList<>();
    private List<Curriculo> curriculos = new ArrayList<>();
    private List<Disciplina> disciplinas = new ArrayList<>();
    private Utils utils = new Utils();

    private Persistence() {}

    public static Persistence getInstance() {
        if (instance == null) {
            instance = new Persistence();
            instance.addInitialData();
        }
        return instance;
    }

    //Section: Usuario
    public void saveUsuario(Usuario usuario) {
        if (getUsuarioByIdOrNome(usuario.getNome()) != null) {
            System.out.println("Usuário já cadastrado");
            return;
        }
        usuarios.add(usuario);
    }
    
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public Usuario getUsuarioByIdOrNome(String idOrNome){
        if (utils.isNumeric(idOrNome)) {
            int id = Integer.parseInt(idOrNome);
            return usuarios.stream().filter(usuario -> usuario.getId() == id).findFirst().orElse(null);
        } else {
            return usuarios.stream().filter(usuario -> usuario.getNome().equalsIgnoreCase(idOrNome)).findFirst().orElse(null);
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
    
    //Section: Curso
    public void saveCurso(Curso curso) {
        if (getCursoByIdOrNome(curso.getNome()) != null) {
            System.out.println("Curso já cadastrado");
            return;
        }
        cursos.add(curso);
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public Curso getCursoByIdOrNome(String idOrNome){
        if (utils.isNumeric(idOrNome)) {
            int id = Integer.parseInt(idOrNome);
            return cursos.stream().filter(curso -> curso.getId() == id).findFirst().orElse(null);
        } else {
            return cursos.stream().filter(curso -> curso.getNome().equalsIgnoreCase(idOrNome)).findFirst().orElse(null);
        }
    }

    // Section: Curriculo
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

    // Section: Disciplina
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

    public Disciplina getDisciplinaByIdOrNome(String idOrNome){
        if (utils.isNumeric(idOrNome)) {
            int id = Integer.parseInt(idOrNome);
            return disciplinas.stream().filter(disciplina -> disciplina.getId() == id).findFirst().orElse(null);
        } else {
            return disciplinas.stream().filter(disciplina -> disciplina.getNome().equalsIgnoreCase(idOrNome)).findFirst().orElse(null);
        }
    }

    private void addInitialData() {
        // Adicionar 3 alunos
        Aluno a1 = new Aluno("João", "alunoJoao@email.com", "123");
        Aluno a2 = new Aluno("Maria", "alunoMaria@email.com", "123");
        Aluno a3 = new Aluno("Ricardo", "alunoRicardo@email.com", "123");
        saveUsuario(a1);
        saveUsuario(a2);
        saveUsuario(a3);

        // Adicionar 3 professores
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

        d1.getTurmas().stream().filter(turma -> turma.getNome().equals("Matemática.01")).findFirst().get().matricularAluno(a1);
        d2.getTurmas().stream().filter(turma -> turma.getNome().equals("Física.01")).findFirst().get().matricularAluno(a1);

        saveDisciplina(d1);
        saveDisciplina(d2);
        saveDisciplina(d3);
    }

    public Optional<Usuario> getUsuarioByEmailESenha(String email, String senha) {
        return this.usuarios.stream()
                .filter(user -> user.getEmail().equals(email) && user.getSenha().equals(senha))
                .findFirst();
    }

    public List<Disciplina> getDisciplinasMatriculadas(UsuarioLogado aluno) {
        return this.disciplinas.stream()
            .filter(disciplinas -> {
                List<Turma> turmasAtivas = disciplinas.getTurmas().stream().filter(turma -> turma.getStatus() == Status.ATIVA).toList();
                return turmasAtivas.stream().filter(turma -> turma.alunoMatriculado(aluno)).findFirst().isPresent();
            })
            .toList();
    }
}
