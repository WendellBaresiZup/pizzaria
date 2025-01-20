package com.zup.pizzaria.models;

import jakarta.persistence.*;


import java.time.LocalDateTime;
@Entity
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pedido_id", referencedColumnName = "id")
    private Pedido pedido;

    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;
    private double valorPago;
    private LocalDateTime dataHoraPagamento;

    public Pagamento(){
    }

    public void detalhesPagamento(){
        System.out.println("ID do Pagamento: " + id);
        System.out.println("ID do Pedido: " + pedido.getId());
        System.out.println("Forma de Pagamento do Pedido: " + formaPagamento.getDescricaoPagamento());
        System.out.printf("Valor do Pagamento: R$ %.2f", valorPago);
        System.out.println("Data e Hora do Pagamento: " + dataHoraPagamento);
    }

    public boolean validarPagamento(){
        if (valorPago <= 0){
            System.out.println("O valor tem que ser maior que 0 e maior que o valor do pedido!!");
            return false;
        }
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public LocalDateTime getDataHoraPagamento() {
        return dataHoraPagamento;
    }

    public void setDataHoraPagamento(LocalDateTime dataHoraPagamento) {
        this.dataHoraPagamento = dataHoraPagamento;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
