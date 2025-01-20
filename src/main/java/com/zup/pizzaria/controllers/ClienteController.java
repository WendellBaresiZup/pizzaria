package com.zup.pizzaria.controllers;

import com.zup.pizzaria.models.Cliente;
import com.zup.pizzaria.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = ("/clientes"))
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Object> cadastrarCliente(@RequestBody Cliente cliente) {
        ResponseEntity<String> clienteCadastrado = clienteService.cadastrarCliente(cliente);
        return ResponseEntity.status(clienteCadastrado.getStatusCode()).body(clienteCadastrado.getBody());
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes(){
        List<Cliente> clientes = clienteService.listarClientes();
        return ResponseEntity.ok(clientes);
    }
}
