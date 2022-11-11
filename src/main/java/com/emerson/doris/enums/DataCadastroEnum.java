package com.emerson.doris.enums;

public enum DataCadastroEnum {

    ULTIMOS_7_DIAS("ultimos_7_dias"),
    ULTIMOS_30_DIAS("ultimos_30_dias"),
    ULTIMOS_3_MESES("ultimos_3_meses"),
    ULTIMOS_6_MESES("ultimos_6_meses");

    private String valor;

    DataCadastroEnum(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public static DataCadastroEnum fromString(String text) {
        for (DataCadastroEnum b : DataCadastroEnum.values()) {
            if (b.valor.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
