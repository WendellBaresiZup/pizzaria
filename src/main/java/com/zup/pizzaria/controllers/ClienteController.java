package com.zup.pizzaria.controllers;

import com.zup.pizzaria.models.Cliente;
import com.zup.pizzaria.services.ClienteService;

public class ClienteController {

    private ClienteService clienteService;

    public Cliente cadastrarCliente(Cliente cliente){
        return clienteService.cadastrarCliente(cliente);
    }
}
