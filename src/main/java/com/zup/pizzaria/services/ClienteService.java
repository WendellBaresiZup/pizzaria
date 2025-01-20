package com.zup.pizzaria.services;

import com.zup.pizzaria.models.Cliente;
import com.zup.pizzaria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente cadastrarCliente(Cliente cliente){
        validacoesCliente(cliente);
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientes(){
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes;
    }

    public ResponseEntity<String> validacoesCliente(Cliente cliente){
        if (cliente == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro: O nome do cliente não pode ser nulo!!");
        }
        if (cliente != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("O Cliente foi criado com sucesso!!");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao cadastrar cliente!!");
        }
    }
}
