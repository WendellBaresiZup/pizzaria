package com.zup.pizzaria.models;

public enum FormaPagamento {
    CARTAO_CREDITO("Cartão de Crédito"),
    CARTAO_DEBITO("Cartão de Débito"),
    DINHEIRO("Dinheiro"),
    PIX("PIX");

    private final String descricaoPagamento;

    FormaPagamento(String descricaoPagamento){
        this.descricaoPagamento = descricaoPagamento;
    }

    public String getDescricaoPagamento() {
        return descricaoPagamento;
    }
}
