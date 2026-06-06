package com.wj.wfinance.domain.enums;

public enum AccountTypeEnum {

    CORRENTE(0, "Corrente"),
    POUPANCA(1, "Poupança");

    private final int codigo;
    private final String descricao;

    AccountTypeEnum(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }
}
