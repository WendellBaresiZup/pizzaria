package com.zup.pizzaria.controllers;

import com.zup.pizzaria.models.Pagamento;
import com.zup.pizzaria.services.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping
    public ResponseEntity<Pagamento> cadastrarPagamento(@RequestBody Pagamento pagamento){
        Pagamento pagamentoCadastrado = pagamentoService.cadastarPagamento(pagamento);
        return ResponseEntity.ok(pagamentoCadastrado);
    }

}
