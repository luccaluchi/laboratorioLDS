package com.lds.matricula_facil;

import java.sql.SQLException;
import org.h2.tools.Server;


public class MatriculaFacil {
    public static void main(String[] args) {
                try {
                    Server server = Server.createWebServer("-webPort", "8082", "-tcpAllowOthers").start();
                } catch (SQLException e) {
                    System.out.println("Erro ao iniciar o servidor H2. Exeption: " + e);
                }

    }    
}