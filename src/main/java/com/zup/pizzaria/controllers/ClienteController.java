package com.zup.pizzaria.controllers;

import com.zup.pizzaria.models.Cliente;
import com.zup.pizzaria.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (value = ("/clientes"))
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public Cliente cadastrarCliente(Cliente cliente){
        return clienteService.cadastrarCliente(cliente);
    }
}
