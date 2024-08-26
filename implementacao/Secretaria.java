import java.util.List;
import java.util.ArrayList;

public class Secretaria {
    private List<Usuario> usuarios;
    private List<Curso> cursos;
    private List<Disciplina> disciplinas;
    private List<Curriculo> curriculos;

    public Secretaria() {
        usuarios = new ArrayList<>();
        cursos = new ArrayList<>();
        disciplinas = new ArrayList<>();
        curriculos = new ArrayList<>();
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public List<Curriculo> getCurriculos() {
        return curriculos;
    }

    public void setCurriculos(List<Curriculo> curriculos) {
        this.curriculos = curriculos;
    }

    public void cadastrarAluno() {
        //fazerrr
        }

    public void visualizarAlunos() {
    //fazerrr    
    }

    public void cadastrarProfessor() {
    //fazerrr    
    }

    public void visualizarProfessores() {
    //fazerrr    
    }

    public void removerUsuario(String nome) {
    //fazerrr    
    }

    public Usuario buscarUsuario(String nome) {
        //fazerrr
        return null;
    }

    public void cadastrarCurso() {
    //fazerrr    
    }

    public void removerCurso(String nome) {
    //fazerrr    
    }

    public void visualizarCursos() {
    //fazerrr    
    }

    public Curso buscarCurso(String nome) {
        //fazerrr
        return null;
    }

    public void cadastrarDisciplina() {
    //fazerrr    
    }

    public void removerDisciplina(String nome) {
    //fazerrr    
    }

    public void visualizarDisciplinas() {
    //fazerrr    
    }

    public Disciplina buscarDisciplina(String nome) {
        //fazerrr
        return null;
    }

    public void gerarCurriculo() {
    //fazerrr    
    }

    public void removerCurriculo(int id) {
    //fazerrr    
    }

    public void visualizarCurriculos() {
    //fazerrr    
    }

    public Curriculo buscarCurriculo(int id) {
        //fazerrr
        return null;
    }

    public void notificarSistemaCobranca() {
    //fazerrr    
    }
}
