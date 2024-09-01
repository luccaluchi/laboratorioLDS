package com.lds.matricula_facil;

import java.util.Scanner;


import com.lds.matricula_facil.util.Persistence;
import com.lds.matricula_facil.util.Utils;

public class MatriculaFacil {

    private static Persistence persistence = Persistence.getInstance();
    private static Utils utils = new Utils();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hello, World!");
        // Para teste:
        // MatriculaFacil matriculaFacil = new MatriculaFacil();
        // matriculaFacil.visualizarCursos();
        // matriculaFacil.visualizarDisciplinas();
        // matriculaFacil.visualizarUsuario();
    }

}