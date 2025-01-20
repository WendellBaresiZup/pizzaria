package com.zup.pizzaria.services;

import com.zup.pizzaria.dtos.PedidoDTO;
import com.zup.pizzaria.models.Cliente;
import com.zup.pizzaria.models.Pedido;
import com.zup.pizzaria.repository.ClienteRepository;
import com.zup.pizzaria.repository.PedidoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;

    public PedidoService(PedidoRepository pedidoRepository, ClienteRepository clienteRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
    }

    public PedidoDTO criarPedido(Pedido pedido) {
        validacoesPedido(pedido);
        pedidoRepository.save(pedido);

        // Obtenho cliente
        Cliente cliente = clienteRepository
                .findById(pedido.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        return new PedidoDTO(cliente.getNome(), cliente.getEmail(), pedido.getDescricao());
    }

    public List<Pedido> listarPedidos(){
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidos;
    }

    public ResponseEntity<String> validacoesPedido(Pedido pedido){
        if (pedido == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro: O pedido não pode ser nulo!!");
        }
        if (pedido != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("O Pedido foi criado com sucesso!!");
        }
        else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao cadastrar pedido!!");
        }
    }
}
