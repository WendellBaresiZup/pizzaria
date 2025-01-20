package com.zup.pizzaria.services;

import com.zup.pizzaria.models.Pagamento;
import com.zup.pizzaria.repository.PagamentoRepository;
import com.zup.pizzaria.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;
    @Autowired
    private PedidoRepository pedidoRepository;

}
