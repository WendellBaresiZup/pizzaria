package com.zup.pizzaria.services;

import com.zup.pizzaria.models.Pagamento;
import com.zup.pizzaria.models.Pedido;
import com.zup.pizzaria.repository.PagamentoRepository;
import com.zup.pizzaria.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;
    @Autowired
    private PedidoRepository pedidoRepository;

    public Pagamento cadastarPagamento(Pagamento pagamento){
        Pedido pedido = pedidoRepository.findById(pagamento.getPedido().getId()).orElseThrow(() -> new RuntimeException("Pedido não encontrado!"));

        pagamento.setPedido(pedido);
        return pagamentoRepository.save(pagamento);
    }

}
