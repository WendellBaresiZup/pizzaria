package com.zup.pizzaria.controllers;

import com.zup.pizzaria.models.Cliente;
import com.zup.pizzaria.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (value = ("/clientes"))
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Object> cadastrarCliente(@RequestBody Cliente cliente) {
        if (cliente == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro: O nome do cliente não pode ser nulo!!");
        }
        Cliente clienteCadastrado = clienteService.cadastrarCliente(cliente);
        if (cliente != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("O Cliente foi criado com sucesso!!");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao cadastrar cliente!!");
        }
    }
}
