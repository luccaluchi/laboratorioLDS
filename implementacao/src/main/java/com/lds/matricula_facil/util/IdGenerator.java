package com.lds.matricula_facil.util;

public class IdGenerator {

    private static int lastId = 0;

    public static int generateId() {
        lastId++;
        return lastId;
    }

    public static int getLastId() {
        return lastId;
    }

}
