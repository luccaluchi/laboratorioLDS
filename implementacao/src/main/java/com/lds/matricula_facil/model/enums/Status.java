package com.lds.matricula_facil.model.enums;

public enum Status {
    ATIVA(1),
    INATIVA(2),
    ENCERRADA(3);

    private final int value;

    Status(int valor) {
        this.value = valor;
    }

    public static Status getFromValue(int valor) {
        for (Status status : Status.values()) {
            if (status.value == valor) {
                return status;
            }
        }
        throw new IllegalArgumentException("Valor inválido: " + valor);
    }
}