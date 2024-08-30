package com.lds.matricula_facil.model.enums;
public enum TipoDisciplina{
    OBRIGATORIA(1),
    OPTATIVA(2);

    private final int value; 

    TipoDisciplina(int valor) {
        this.value = valor;
    }

    public static TipoDisciplina getfromValue(int valor) {
        for (TipoDisciplina tipo : TipoDisciplina.values()) {
            if (tipo.getValue() == valor) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Valor inválido: " + valor);
    }

    public int getValue() {
        return value;
    }
}