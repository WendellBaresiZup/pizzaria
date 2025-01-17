package com.zup.pizzaria.models;

public enum FormaPagamento {
    CARTAO("Cartão"),
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
